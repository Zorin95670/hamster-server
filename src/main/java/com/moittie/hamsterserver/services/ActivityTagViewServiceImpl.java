package com.moittie.hamsterserver.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.moittie.hamsterserver.controllers.models.ApiErrorCode;
import com.moittie.hamsterserver.controllers.models.ApiException;
import com.moittie.hamsterserver.models.TagRecord;
import com.moittie.hamsterserver.persistence.models.ActivityTagView;
import com.moittie.hamsterserver.persistence.models.Tag;
import com.moittie.hamsterserver.persistence.models.TagView;
import com.moittie.hamsterserver.persistence.models.User;
import com.moittie.hamsterserver.persistence.repository.ActivityTagViewRepository;
import com.moittie.hamsterserver.persistence.repository.TagRepository;
import com.moittie.hamsterserver.persistence.repository.TagViewRepository;
import com.moittie.hamsterserver.persistence.specification.SpecificationHelper;
import com.moittie.hamsterserver.utils.reflect.FieldUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class ActivityTagViewServiceImpl implements ActivityTagViewService {

    @Autowired
    private ActivityTagViewRepository activityTagViewRepository;

    @Override
    public JsonNode count(final Map<String, String> filters, final String field, final String value) {
        Specification<ActivityTagView> specification = new SpecificationHelper<>(ActivityTagView.class, filters);

        if (!FieldUtils.hasField(ActivityTagView.class, field)) {
            throw new ApiException(HttpStatus.BAD_REQUEST, ApiErrorCode.UNKNOWN_SEARCH_FIELD);
        }
        return activityTagViewRepository.count(ActivityTagView.class, specification, field, value);
    }
}
