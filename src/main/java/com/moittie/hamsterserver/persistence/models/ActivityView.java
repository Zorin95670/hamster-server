package com.moittie.hamsterserver.persistence.models;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.moittie.hamsterserver.persistence.specification.filter.FilterType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "activities_view")
@EqualsAndHashCode(callSuper = true)
@Data
public class ActivityView extends AbstractEntity {
    @Id
    @Column(name = "act_id", updatable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Column(name = "usr_id", nullable = false)
    @FilterType(type = FilterType.Type.UUID)
    private UUID userId;

    @Column(name = "name")
    @FilterType(type = FilterType.Type.TEXT)
    private String name;

    @Column(name = "description")
    @FilterType(type = FilterType.Type.TEXT)
    private String description;

    @Column(name = "link")
    @FilterType(type = FilterType.Type.TEXT)
    private String link;

    @Column(name = "start_date")
    @FilterType(type = FilterType.Type.DATE)
    private Timestamp startDate;

    @Column(name = "end_date")
    @FilterType(type = FilterType.Type.DATE)
    private Timestamp endDate;

    @Column(name = "tags")
    @FilterType(type = FilterType.Type.TEXT)
    private String tags;

    @PrePersist
    public void prePersist() {
        this.setInsertDate(Timestamp.valueOf(LocalDateTime.now()));
    }
}
