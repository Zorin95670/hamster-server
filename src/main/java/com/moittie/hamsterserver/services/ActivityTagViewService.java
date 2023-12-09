package com.moittie.hamsterserver.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.moittie.hamsterserver.models.TagRecord;
import com.moittie.hamsterserver.persistence.models.Tag;
import com.moittie.hamsterserver.persistence.models.TagView;
import com.moittie.hamsterserver.persistence.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ActivityTagViewService {

    JsonNode count(Map<String, String> filters, String field, String value);
}
