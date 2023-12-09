package com.moittie.hamsterserver.persistence.repository;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountRepository<T> {

    JsonNode count(Class<T> entity, Specification<T> specification, String field, String value);

    JsonNode count(Class<T> entity, Specification<T> specification, List<String> fields);
}