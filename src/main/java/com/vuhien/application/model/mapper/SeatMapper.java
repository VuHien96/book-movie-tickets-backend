package com.vuhien.application.model.mapper;

import com.vuhien.application.entity.Cinema;
import com.vuhien.application.entity.Seat;
import com.vuhien.application.entity.SeatType;
import com.vuhien.application.model.request.SeatRequest;

/**
 * Created by VuHien96 on 20/08/2021 17:11
 */
public class SeatMapper {

    public static Seat toSeat(SeatRequest seatRequest) {
        Seat seat = new Seat();
        seat.setSeatName(seatRequest.getSeatName());
        seat.setRowName(seatRequest.getRowName());
        seat.setOrderNumber(seatRequest.getOrderNumber());
        seat.setStatus(seatRequest.isStatus());
        Cinema cinema = new Cinema();
        cinema.setCinemaId(seatRequest.getCinemaId());
        seat.setCinema(cinema);
        SeatType seatType = new SeatType();
        seatType.setSeatTypeId(seatRequest.getSeatTypeId());
        seat.setSeatType(seatType);
        return seat;
    }

    public static Seat toSeat(SeatRequest seatRequest, Seat seat, Long id) {
        seat.setSeatId(id);
        seat.setSeatName(seatRequest.getSeatName());
        seat.setRowName(seatRequest.getRowName());
        seat.setOrderNumber(seatRequest.getOrderNumber());
        seat.setStatus(seatRequest.isStatus());
        Cinema cinema = new Cinema();
        cinema.setCinemaId(seatRequest.getCinemaId());
        seat.setCinema(cinema);
        SeatType seatType = new SeatType();
        seatType.setSeatTypeId(seatRequest.getSeatTypeId());
        seat.setSeatType(seatType);

        return seat;
    }


}
