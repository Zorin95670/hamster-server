package com.moittie.hamsterserver.persistence.repository;

import com.moittie.hamsterserver.persistence.models.Activity;
import com.moittie.hamsterserver.persistence.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ActivityRepository extends CrudRepository<Activity, UUID>, JpaSpecificationExecutor<Activity> {

    Page<Activity> findAllByUserId(UUID userId, Pageable pageable);

    Optional<Activity> findActivityByIdAndUserId(UUID id, UUID userId);
}