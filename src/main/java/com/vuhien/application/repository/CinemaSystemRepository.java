package com.vuhien.application.repository;

import com.vuhien.application.entity.CinemaSystem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by VuHien96 on 17/08/2021 19:50
 */
@Repository
public interface CinemaSystemRepository extends JpaRepository<CinemaSystem, String> {

    Optional<CinemaSystem> findByCinemaSystemName(String name);

    @Query(value = "SELECT cs.cinema_system_id," +
            "cs.aliases, " +
            "cs.cinema_system_name, " +
            "cs.logo " +
            "FROM cinema_system cs " +
            "WHERE (:id is null or lower(cs.cinema_system_id) LIKE %:id%) " +
            "AND (:name is null or lower(cs.cinema_system_name) LIKE %:name%)",
            countQuery = "SELECT count(*)" +
                    "FROM cinema_system cs " +
                    "WHERE (:id is null or lower(cs.cinema_system_id) LIKE %:id%) " +
                    "AND (:name is null or lower(cs.cinema_system_name) LIKE %:name%)"
            , nativeQuery = true)
    Page<CinemaSystem> getCinemaSystemPage(@Param("id") String id,
                                           @Param("name") String name,
                                           Pageable pageable);

}
