package com.vuhien.application.repository;

import com.vuhien.application.entity.SeatType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by VuHien96 on 20/08/2021 16:24
 */
public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {
    Optional<SeatType> findBySeatTypeName(String name);

    @Query(value = "SELECT st.seat_type_id," +
            "st.seat_type_name, " +
            "st.description, " +
            "st.surcharge " +
            "FROM seat_type st " +
            "WHERE (:seatTypeName is null or lower(st.seat_type_name) like %:seatTypeName%)",
            countQuery = "SELECT count(*) " +
                    "FROM seat_type st " +
                    "WHERE (:seatTypeName is null or lower(st.seat_type_name) like %:seatTypeName%)",
            nativeQuery = true)
    Page<SeatType> seatTypePage(@Param("seatTypeName") String seatTypeName, Pageable pageable);
}
