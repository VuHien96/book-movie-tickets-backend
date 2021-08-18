package com.vuhien.application.repository;

import com.vuhien.application.entity.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by VuHien96 on 18/08/2021 14:10
 */
@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    Optional<Cinema> findByCinemaName(String name);

    @Query(value = "SELECT c.cinema_id," +
            "c.cinema_name," +
            "c.number_seats," +
            "c.cinema_complex_id " +
            "FROM cinema c " +
            "WHERE (:name is null or lower(c.cinema_name) LIKE %:name%) ",
            countQuery = "SELECT count (*)" +
                    "FROM cinema c " +
                    "WHERE (:name is null or lower(c.cinema_name) LIKE %:name%) ", nativeQuery = true)
    Page<Cinema> getCinemaPage(@Param("name") String name,
                               Pageable pageable);
}
