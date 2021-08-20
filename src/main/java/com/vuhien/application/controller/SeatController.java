package com.vuhien.application.controller;

import com.vuhien.application.entity.Seat;
import com.vuhien.application.model.request.SeatRequest;
import com.vuhien.application.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by VuHien96 on 20/08/2021 19:53
 */
@RestController
@RequestMapping("/api/seats")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @PostMapping("/search")
    public ResponseEntity<Object> seatPage(@RequestBody Seat seat,
                                           @PageableDefault(sort = "seat_id",
                                                   direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Seat> seatPage = seatService.seatPage(seat, pageable);
        return new ResponseEntity<>(seatPage, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAllSeats() {
        List<Seat> seatList = seatService.getAllSeats();
        return new ResponseEntity<>(seatList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSeatById(@PathVariable Long id) {
        Seat seat = seatService.getSeatById(id);
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createSeat(@RequestBody SeatRequest seatRequest) {
        Seat seat = seatService.creatSeat(seatRequest);
        return new ResponseEntity<>(seat, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSeat(@RequestBody SeatRequest seatRequest, @PathVariable Long id) {
        seatService.updateSeat(seatRequest, id);
        return new ResponseEntity<>("Cập nhật thành công", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
