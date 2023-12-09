package com.moittie.hamsterserver.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.moittie.hamsterserver.controllers.models.ApiErrorCode;
import com.moittie.hamsterserver.controllers.models.ApiException;
import com.moittie.hamsterserver.models.TagRecord;
import com.moittie.hamsterserver.persistence.models.Tag;
import com.moittie.hamsterserver.persistence.models.TagView;
import com.moittie.hamsterserver.persistence.models.User;
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
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagViewRepository tagViewRepository;

    @Override
    public Page<Tag> find(final Map<String, String> filters, final Pageable pageable) {
        return this.tagRepository.findAll(new SpecificationHelper<>(Tag.class, filters),
                pageable);
    }

    @Override
    public Page<TagView> findWithCount(final Map<String, String> filters, final Pageable pageable) {
        return this.tagViewRepository.findAll(new SpecificationHelper<>(TagView.class, filters),
                pageable);
    }

    @Override
    public Tag add(User user, TagRecord record) {
        Tag tag = new Tag();
        tag.setName(record.name());
        tag.setBackgroundColor(record.backgroundColor());
        tag.setTextColor(record.textColor());
        tag.setUserId(user.getId());

        return tagRepository.save(tag);
    }

    @Override
    public void update(User user, String id, TagRecord record) {
        UUID tagId = UUID.fromString(id);
        Tag tag = tagRepository.getTagByIdAndUserId(tagId, user.getId())
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, ApiErrorCode.NOT_FOUND_ENTITY));

        tag.setName(record.name());
        tag.setBackgroundColor(record.backgroundColor());
        tag.setTextColor(record.textColor());

        tagRepository.save(tag);
    }
}
