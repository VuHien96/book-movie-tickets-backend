package com.vuhien.application.controller;

import com.vuhien.application.entity.SeatType;
import com.vuhien.application.service.SeatTypeService;
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
 * Created by VuHien96 on 20/08/2021 16:45
 */
@RestController
@RequestMapping("/api/seat-types")
public class SeatTypeController {

    @Autowired
    private SeatTypeService seatTypeService;

    @PostMapping("/search")
    public ResponseEntity<Object> seatTypePage(@RequestBody SeatType seatType,
                                               @PageableDefault(sort = "seat_type_id",
                                                       direction = Sort.Direction.DESC) Pageable pageable) {
        Page<SeatType> seatTypePage = seatTypeService.seatTypePage(seatType, pageable);
        return new ResponseEntity<>(seatTypePage, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAllSeatType() {
        List<SeatType> seatTypeList = seatTypeService.getAllSeatType();
        return new ResponseEntity<>(seatTypeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSeatTypeById(@PathVariable Long id) {
        SeatType seatType = seatTypeService.getSeatTypeById(id);
        return new ResponseEntity<>(seatType, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createSeatType(@RequestBody SeatType seatType) {
        SeatType st = seatTypeService.createSeatType(seatType);
        return new ResponseEntity<>(st, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSeatType(@RequestBody SeatType seatType, @PathVariable Long id) {
        seatTypeService.updateSeatType(seatType, id);
        return new ResponseEntity<>("Cập nhật thành công", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSeatType(@PathVariable Long id) {
        seatTypeService.deleteSeatType(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }

}
