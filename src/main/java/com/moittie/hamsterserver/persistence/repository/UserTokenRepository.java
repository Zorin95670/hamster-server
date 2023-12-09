package com.moittie.hamsterserver.persistence.repository;

import com.moittie.hamsterserver.persistence.models.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserTokenRepository extends JpaRepository<UserToken, Long>, JpaSpecificationExecutor<UserToken> {

    Optional<UserToken> findByUsrId(UUID usrId);

    Optional<UserToken> findByToken(String token);
}