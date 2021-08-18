package com.vuhien.application.controller;

import com.vuhien.application.entity.Cinema;
import com.vuhien.application.model.request.CinemaRequest;
import com.vuhien.application.service.CinemaService;
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
 * Created by VuHien96 on 18/08/2021 20:36
 */
@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @GetMapping
    public ResponseEntity<Object> getAllCinemas() {
        List<Cinema> cinemas = cinemaService.getAllCinema();
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<Object> getCinemaPage(@RequestBody Cinema cinema,
                                                @PageableDefault(sort = "cinema_id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Cinema> cinemaPage = cinemaService.getCinemaPage(cinema, pageable);
        return new ResponseEntity<>(cinemaPage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createCinema(@RequestBody CinemaRequest cinemaRequest) {
        Cinema cinema = cinemaService.createCinema(cinemaRequest);
        return new ResponseEntity<>(cinema, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCinema(@RequestBody CinemaRequest cinemaRequest, @PathVariable Long id) {
        cinemaService.updateCinema(cinemaRequest, id);
        return new ResponseEntity<>("Cập nhật thành công", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCinema(@PathVariable Long id) {
        cinemaService.deleteCinema(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
