package com.moittie.hamsterserver.persistence.repository;

import com.moittie.hamsterserver.persistence.models.Tag;
import com.moittie.hamsterserver.persistence.models.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface TagRepository extends CrudRepository<Tag, UUID>, JpaSpecificationExecutor<Tag> {

    Optional<Tag> getTagByIdAndUserId(UUID id, UUID userId);
}