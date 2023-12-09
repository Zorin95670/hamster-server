package com.moittie.hamsterserver.persistence.repository;

import com.moittie.hamsterserver.persistence.models.ActivityTagView;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityTagViewRepository extends CrudRepository<ActivityTagView, Long>, JpaSpecificationExecutor<ActivityTagView>, CountRepository<ActivityTagView> {
}