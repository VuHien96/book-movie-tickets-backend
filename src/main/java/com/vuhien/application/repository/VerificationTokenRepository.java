package com.vuhien.application.repository;

import com.vuhien.application.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by VuHien96 on 17/08/2021 10:54
 */
@Repository
@Transactional(readOnly = true)
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);

    @Modifying
    @Transactional
    @Query("UPDATE VerificationToken v " +
            "SET v.confirmedAt = ?2 " +
            "WHERE v.token = ?1")
    void updateConfirmedAt(String token, LocalDateTime localDateTime);
}
