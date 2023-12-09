package com.moittie.hamsterserver.persistence.repository;

import com.moittie.hamsterserver.persistence.models.ActivityTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface ActivityTagRepository extends JpaRepository<ActivityTag, Long>, JpaSpecificationExecutor<ActivityTag> {

    Iterable<ActivityTag> findAllByActivityId(UUID id);
    void deleteAllByActivityId(UUID id);
}