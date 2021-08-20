package com.vuhien.application.service;

import com.vuhien.application.entity.Seat;
import com.vuhien.application.model.request.SeatRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by VuHien96 on 20/08/2021 17:57
 */
@Service
public interface SeatService {
    Page<Seat> seatPage(Seat seat, Pageable pageable);
    List<Seat> getAllSeats();
    Seat getSeatById(Long id);
    Seat creatSeat(SeatRequest seatRequest);
    void updateSeat(SeatRequest seatRequest,Long id);
    void deleteSeat(Long id);
}
