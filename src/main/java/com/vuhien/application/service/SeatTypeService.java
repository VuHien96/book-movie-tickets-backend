package com.vuhien.application.service;

import com.vuhien.application.entity.SeatType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by VuHien96 on 20/08/2021 16:32
 */
@Service
public interface SeatTypeService {
    Page<SeatType> seatTypePage(SeatType seatType, Pageable pageable);
    List<SeatType> getAllSeatType();
    SeatType getSeatTypeById(Long id);
    SeatType createSeatType(SeatType seatType);
    void updateSeatType(SeatType seatType,Long id);
    void deleteSeatType(Long id);
}
