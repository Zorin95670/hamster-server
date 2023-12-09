package com.moittie.hamsterserver.persistence.repository;

import com.moittie.hamsterserver.persistence.models.TagView;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TagViewRepository extends CrudRepository<TagView, UUID>, JpaSpecificationExecutor<TagView>, CountRepository<TagView> {
}