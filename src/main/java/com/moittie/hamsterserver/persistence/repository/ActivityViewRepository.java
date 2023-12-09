package com.moittie.hamsterserver.persistence.repository;

import com.moittie.hamsterserver.persistence.models.Activity;
import com.moittie.hamsterserver.persistence.models.ActivityView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ActivityViewRepository extends CrudRepository<ActivityView, UUID>, JpaSpecificationExecutor<ActivityView> {
}