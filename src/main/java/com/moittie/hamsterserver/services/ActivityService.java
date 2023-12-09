package com.moittie.hamsterserver.services;

import com.moittie.hamsterserver.models.ActivityRecord;
import com.moittie.hamsterserver.models.ActivityViewDTO;
import com.moittie.hamsterserver.persistence.models.Activity;
import com.moittie.hamsterserver.persistence.models.ActivityView;
import com.moittie.hamsterserver.persistence.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ActivityService {

    Page<ActivityViewDTO> find(final Map<String, String> filters, final Pageable pageable);

    void update(final User user, final String id, final ActivityRecord record);

    void delete(final User user, final String id);

    Activity add(final User user, final ActivityRecord record);
}
