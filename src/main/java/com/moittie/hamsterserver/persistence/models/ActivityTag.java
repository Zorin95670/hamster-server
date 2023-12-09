package com.moittie.hamsterserver.persistence.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "activity_tags")
@EqualsAndHashCode(callSuper = true)
@Data
public class ActivityTag extends AbstractEntity {
    @Id
    @Column(name = "atg_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_tags_seq")
    @SequenceGenerator(name = "activity_tags_seq", sequenceName = "activity_tags_atg_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "act_id", nullable = false)
    private UUID activityId;

    @Column(name = "tag_id", nullable = false)
    private UUID tagId;

    @PrePersist
    public void prePersist() {
        this.setInsertDate(Timestamp.valueOf(LocalDateTime.now()));
    }
}
