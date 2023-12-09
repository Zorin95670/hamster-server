package com.moittie.hamsterserver.persistence.models;

import com.moittie.hamsterserver.persistence.specification.filter.FilterType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tags")
@EqualsAndHashCode(callSuper = true)
@Data
public class Tag extends AbstractEntity {
    @Id
    @Column(name = "tag_id", updatable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Column(name = "usr_id", nullable = false)
    @FilterType(type = FilterType.Type.UUID)
    private UUID userId;

    @Column(name = "name", nullable = false)
    @FilterType(type = FilterType.Type.TEXT)
    private String name;

    @Column(name = "background_color")
    @FilterType(type = FilterType.Type.TEXT)
    private String backgroundColor;

    @Column(name = "text_color")
    @FilterType(type = FilterType.Type.TEXT)
    private String textColor;

    @PrePersist
    public void prePersist() {
        this.setInsertDate(Timestamp.valueOf(LocalDateTime.now()));
    }
}
