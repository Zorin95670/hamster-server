package com.moittie.hamsterserver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moittie.hamsterserver.controllers.models.ApiErrorCode;
import com.moittie.hamsterserver.controllers.models.ApiException;
import com.moittie.hamsterserver.models.ActivityRecord;
import com.moittie.hamsterserver.models.ActivityViewDTO;
import com.moittie.hamsterserver.persistence.models.*;
import com.moittie.hamsterserver.persistence.repository.ActivityRepository;
import com.moittie.hamsterserver.persistence.repository.ActivityTagRepository;
import com.moittie.hamsterserver.persistence.repository.ActivityViewRepository;
import com.moittie.hamsterserver.persistence.repository.TagRepository;
import com.moittie.hamsterserver.persistence.specification.SpecificationHelper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityTagRepository activityTagRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ActivityViewRepository activityViewRepository;

    @Override
    public Page<ActivityViewDTO> find(final Map<String, String> filters, final Pageable pageable) {
        return activityViewRepository
                .findAll(new SpecificationHelper<>(ActivityView.class, filters), pageable)
                .map(this::convert);
    }

    @Override
    public void update(User user, String id, ActivityRecord record) {
        UUID activityId = UUID.fromString(id);
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, ApiErrorCode.NOT_FOUND_ENTITY));

        activity.setName(record.name());
        activity.setLink(record.link());
        activity.setDescription(record.description());
        activity.setStartDate(Timestamp.from(Instant.ofEpochMilli(record.startDate())));
        if (record.endDate() != null) {
            activity.setEndDate(Timestamp.from(Instant.ofEpochMilli(record.endDate())));
        }


        activityRepository.save(activity);
        record.tags().forEach(System.out::println);
        activityTagRepository.deleteAllByActivityId(activity.getId());
        activityTagRepository.flush();
        record.tags().forEach((String tagId) -> {
            tagRepository.findById(UUID.fromString(tagId)).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, ApiErrorCode.NOT_FOUND_ENTITY));
            ActivityTag activityTag = new ActivityTag();
            activityTag.setActivityId(activityId);
            activityTag.setTagId(UUID.fromString(tagId));
            activityTagRepository.save(activityTag);
        });
    }

    @Override
    public void delete(User user, String id) {
        UUID activityId = UUID.fromString(id);
        Activity activity = activityRepository.findActivityByIdAndUserId(activityId, user.getId())
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, ApiErrorCode.NOT_FOUND_ENTITY));

        activityRepository.delete(activity);
    }

    @Override
    public Activity add(User user, ActivityRecord record) {
        Activity activity = new Activity();

        activity.setName(record.name());
        activity.setLink(record.link());
        activity.setDescription(record.description());
        activity.setStartDate(Timestamp.from(Instant.ofEpochMilli(record.startDate())));
        activity.setUserId(user.getId());

        activity = activityRepository.save(activity);
        final UUID activityId = activity.getId();

        record.tags().forEach(((tagId) -> {
            ActivityTag activityTag = new ActivityTag();

            activityTag.setActivityId(activityId);
            activityTag.setTagId(UUID.fromString(tagId));

            activityTagRepository.save(activityTag);
        }));

        return activity;
    }

    ActivityViewDTO convert(ActivityView view) {
        ActivityViewDTO dto = new ActivityViewDTO();
        dto.setId(view.getId());
        dto.setName(view.getName());
        dto.setDescription(view.getDescription());
        dto.setLink(view.getLink());
        dto.setStartDate(view.getStartDate());
        dto.setEndDate(view.getEndDate());
        try {
            dto.setTags(new ObjectMapper().readTree(view.getTags()));
        } catch (JsonProcessingException e) {
            throw new ApiException(HttpStatus.BAD_REQUEST, ApiErrorCode.INVALID_VALUE);
        }
        return dto;
    }
}
