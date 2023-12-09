package com.moittie.hamsterserver.persistence.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.moittie.hamsterserver.controllers.models.ApiErrorCode;
import com.moittie.hamsterserver.controllers.models.ApiException;
import com.moittie.hamsterserver.utils.reflect.FieldUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.IntStream;

public class CountRepositoryImpl<T> implements CountRepository<T> {
    /**
     * Entity manager.
     */
    @Autowired
    private EntityManager entityManager;

    @Override
    public JsonNode count(final Class<T> entity, final Specification<T> specification, final String field,
                          final String value) {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        final Root<T> root = criteria.from(entity);

        criteria.multiselect(root.get(field), builder.count(root.get(field)));

        if (StringUtils.isBlank(value)) {
            criteria.where(specification.toPredicate(root, criteria, builder));
        } else if (!value.contains(",")) {
            criteria.where(specification.toPredicate(root, criteria, builder), builder.equal(root.get(field),
                    this.convertValueToObject(entity, field, value)));
        } else {
            criteria.where(specification.toPredicate(root, criteria, builder),
                    root.get(field).in(Arrays.stream(value.split(","))
                            .map(v -> this.convertValueToObject(entity, field, v)).toList()));
        }

        criteria.groupBy(root.get(field));

        final TypedQuery<Object[]> query = this.entityManager.createQuery(criteria);

        final List<Object[]> list = query.getResultList();

        final ObjectNode json = JsonNodeFactory.instance.objectNode();

        if (StringUtils.isNotBlank(value)) {
            Arrays.stream(value.split(",")).forEach(v -> json.put(v, 0));
        }

        list.forEach(array -> {
            String name = null;

            if (array[0] != null) {
                name = array[0].toString();
            }

            json.put(name, Integer.parseInt(array[1].toString()));
        });

        return json;
    }

    /**
     * Convert value to the type configure on the class.
     *
     * @param clazz     Entity class.
     * @param fieldName Field name.
     * @param value     Field value.
     * @return Value.
     */
    public Object convertValueToObject(final Class<?> clazz, final String fieldName, final String value) {
        if (value == null) {
            return null;
        }
        final Field field = FieldUtils.getField(clazz, fieldName);
        if (Objects.requireNonNull(field).getType().equals(boolean.class)) {
            return Optional.ofNullable(BooleanUtils.toBooleanObject(value))
                    .orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, ApiErrorCode.INVALID_SEARCH_FIELD));
        }
        return value;
    }

    @Override
    public JsonNode count(final Class<T> entity, final Specification<T> specification,
                          final List<String> fields) {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        final Root<T> root = criteria.from(entity);

        List<Selection<?>> selections = new ArrayList<>();
        fields.stream().map(root::get).forEach(selections::add);
        selections.add(builder.count(root));
        criteria.multiselect(selections);


        criteria.where(specification.toPredicate(root, criteria, builder));

        List<Expression<?>> groupBy = new ArrayList<>();
        fields.stream().map(root::get).forEach(groupBy::add);
        selections.add(builder.count(root).alias("count"));
        criteria.groupBy(groupBy);

        final TypedQuery<Object[]> query = this.entityManager.createQuery(criteria);

        final ArrayNode list = JsonNodeFactory.instance.arrayNode();

        query.getResultStream().map(objects -> {
            ObjectNode json = JsonNodeFactory.instance.objectNode();

            IntStream.range(0, fields.size())
                    .forEach(index -> json.put(fields.get(index), objects[index].toString()));
            json.put("count", objects[fields.size()].toString());
            return json;
        }).forEach(list::add);

        return list;
    }
}