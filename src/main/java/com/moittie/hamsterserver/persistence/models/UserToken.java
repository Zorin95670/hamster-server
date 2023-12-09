package com.moittie.hamsterserver.persistence.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.UUID;
import java.security.SecureRandom;
import java.util.Base64;

@Entity
@Table(name = "user_tokens")
@EqualsAndHashCode(callSuper = true)
@Data
public class UserToken extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_tokens_seq")
    @SequenceGenerator(name = "user_tokens_seq", sequenceName = "user_tokens_ust_id_seq", allocationSize = 1)
    @Column(name = "ust_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "usr_id", updatable = false, nullable = false)
    private UUID usrId;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "expiration_date")
    private Timestamp expirationDate;

    @PrePersist
    public void prePersist() {
        this.setInsertDate(Timestamp.valueOf(LocalDateTime.now()));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 7);

        this.setExpirationDate(new Timestamp(calendar.getTimeInMillis()));

        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);

        this.setToken(Base64.getEncoder().encodeToString(randomBytes));
    }
}
