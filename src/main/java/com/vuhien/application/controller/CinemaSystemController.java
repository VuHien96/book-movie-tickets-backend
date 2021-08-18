package com.vuhien.application.controller;

import com.vuhien.application.entity.CinemaSystem;
import com.vuhien.application.service.CinemaSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by VuHien96 on 18/08/2021 09:31
 */
@RestController
@RequestMapping("/api/cinema-systems")
public class CinemaSystemController {

    @Autowired
    private CinemaSystemService cinemaSystemService;

    @GetMapping
    public ResponseEntity<Object> getAllCinemaSystems() {
        List<CinemaSystem> cinemaSystems = cinemaSystemService.getAllCinemaSystem();
        return new ResponseEntity<>(cinemaSystems, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<Object> getCinemaSystemPage(@RequestBody CinemaSystem cinemaSystem, Pageable pageable) {
        Page<CinemaSystem> cinemaSystemPage = cinemaSystemService.getCinemaSystemPage(cinemaSystem, pageable);
        return new ResponseEntity<>(cinemaSystemPage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createCinemaSystem(@RequestBody CinemaSystem cinemaSystem) {
        CinemaSystem cs = cinemaSystemService.createCinemaSystem(cinemaSystem);
        return new ResponseEntity<>(cs, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCinemaSystem(@RequestBody CinemaSystem cinemaSystem, @PathVariable String id) {
        cinemaSystemService.updateCinemaSystem(cinemaSystem, id);
        return new ResponseEntity<>("Cập nhật thành công", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCinemaSystem(@PathVariable String id) {
        cinemaSystemService.deleteCinemaSystem(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
