package com.vuhien.application.repository;

import com.vuhien.application.entity.Seat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by VuHien96 on 20/08/2021 17:27
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    Optional<Seat> findBySeatName(String name);

    @Query(value = "SELECT s.seat_id," +
            "s.seat_name, " +
            "s.order_number, " +
            "s.status, " +
            "s.row_name, " +
            "s.seat_type_id, " +
            "s.cinema_id " +
            "FROM seat s " +
            "WHERE (:seatName is null or lower(s.seat_name) like %:seatName%) " +
            "AND (:rowName is null or lower(s.row_name) like %:rowName%) ",
            countQuery = "SELECT c count (*) " +
                    "FROM seat c " +
                    "WHERE (:seatName is null or lower(s.seat_name) like %:seatName%) " +
                    "AND (:rowName is null or lower(s.row_name) like %:rowName%) ",
            nativeQuery = true)
    Page<Seat> seatPage(@Param("seatName") String seatName,
                        @Param("rowName") String rowName,
                        Pageable pageable);
}
