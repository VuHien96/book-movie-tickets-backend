package com.vuhien.application.repository;

import com.vuhien.application.entity.CinemaComplex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by VuHien96 on 18/08/2021 10:37
 */
@Repository
public interface CinemaComplexRepository extends JpaRepository<CinemaComplex, String> {
    Optional<CinemaComplex> findByCinemaComplexName(String name);

    @Query(value = "SELECT cc.cinema_complex_id," +
            "cc.cinema_complex_name," +
            "cc.information, " +
            "cc.cinema_system_id " +
            "FROM cinema_complex cc " +
            "WHERE (:id is null or lower(cc.cinema_complex_id) LIKE %:id%) " +
            "AND (:name is null or lower(cc.cinema_complex_name) LIKE %:name%)",
            countQuery = "SELECT count(*)" +
                    "FROM cinema_complex cc " +
                    "WHERE (:id is null or lower(cc.cinema_complex_id) LIKE %:id%) " +
                    "AND (:name is null or lower(cc.cinema_complex_name) LIKE %:name%)",
            nativeQuery = true)
    Page<CinemaComplex> getCinemaComplexPages(@Param("id") String id,
                                              @Param("name") String name,
                                              Pageable pageable);
}
