package com.moittie.hamsterserver.persistence.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "activity_tags_view")
@EqualsAndHashCode(callSuper = true)
@Data
public class ActivityTagView extends AbstractEntity {
    @Id
    @Column(name = "atg_id", updatable = false)
    private Long id;

    @Column(name = "act_id", nullable = false)
    private UUID activityId;

    @Column(name = "tag_id", nullable = false)
    private UUID tagId;

    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "tag_name")
    private String tagName;

    @Column(name = "tag_background_color")
    private String tagBackgroundColor;

    @Column(name = "tag_text_color")
    private String tagTextColor;
}
