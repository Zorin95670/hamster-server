package com.moittie.hamsterserver.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.moittie.hamsterserver.persistence.models.Tag;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@Data
public class ActivityViewDTO {
    private UUID id;
    private UUID userId;
    private String name;
    private String description;
    private String link;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp startDate;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp endDate;
    private JsonNode tags;
}
