package com.moittie.hamsterserver.persistence.specification.filter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;

import java.util.UUID;

public class UUIDPredicateFilter extends PredicateFilter {

    /**
     * Create UUID filter with field name and default type is "UUID".
     *
     * @param name  Field name.
     * @param value Field value.
     */
    public UUIDPredicateFilter(final String name, final String value) {
        super(name, value, FilterType.Type.UUID);
    }

    @Override
    public final <T> Predicate getPredicate(final int index, final CriteriaBuilder builder, final Expression<T> field) {
        if (this.getIsNotOperator(index)) {
            return builder.notEqual(field, UUID.fromString(this.getValue(index)));
        }
        return builder.equal(field, UUID.fromString(this.getValue(index)));
    }
}
