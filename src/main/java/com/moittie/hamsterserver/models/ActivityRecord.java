package com.moittie.hamsterserver.models;

import com.moittie.hamsterserver.persistence.models.Tag;

import java.util.List;

public record ActivityRecord(
        String name,
        String description,
        String link,
        Long startDate,
        Long endDate,
        List<String> tags) {
}
