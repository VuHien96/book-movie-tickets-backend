package com.vuhien.application.service.impl;

import com.vuhien.application.entity.Seat;
import com.vuhien.application.exception.InternalServerException;
import com.vuhien.application.exception.NotFoundException;
import com.vuhien.application.model.mapper.SeatMapper;
import com.vuhien.application.model.request.SeatRequest;
import com.vuhien.application.repository.SeatRepository;
import com.vuhien.application.service.SeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by VuHien96 on 20/08/2021 17:57
 */
@Component
public class SeatServiceImpl implements SeatService {

    private static final Logger logger = LoggerFactory.getLogger(SeatServiceImpl.class);

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Page<Seat> seatPage(Seat seat, Pageable pageable) {
        return seatRepository.seatPage(seat.getSeatName(), seat.getRowName(), pageable);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Seat getSeatById(Long id) {
        Optional<Seat> seat = seatRepository.findById(id);
        if (seat.isEmpty()) {
            throw new NotFoundException("Ghế không tồn tại");
        }
        return seat.get();
    }

    @Override
    public Seat creatSeat(SeatRequest seatRequest) {
        Seat seat = SeatMapper.toSeat(seatRequest);
        seatRepository.save(seat);
        return seat;
    }

    @Override
    public void updateSeat(SeatRequest seatRequest, Long id) {
        Optional<Seat> seat = seatRepository.findById(id);
        if (seat.isEmpty()) {
            throw new NotFoundException("Ghế không tồn tại");
        }
        Seat rs = SeatMapper.toSeat(seatRequest, seat.get(), id);
        seatRepository.save(rs);
    }

    @Override
    public void deleteSeat(Long id) {
        Optional<Seat> seat = seatRepository.findById(id);
        if (seat.isEmpty()) {
            throw new NotFoundException("Ghế không tồn tại");
        }
        try {
            seatRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Có lỗi: {}", e.getMessage());
            throw new InternalServerException("Có lỗi trong khi xóa");
        }
    }
}
