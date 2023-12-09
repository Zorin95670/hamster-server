package com.moittie.hamsterserver.persistence.models;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Data;

import java.sql.Timestamp;

@MappedSuperclass
@Data
public class AbstractEntity {

    @Column(name = "insert_date", updatable = false)
    private Timestamp insertDate;

    @Column(name = "update_date")
    @Version
    private Timestamp updateDate;
}