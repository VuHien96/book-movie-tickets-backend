package com.vuhien.application.controller;

import com.vuhien.application.entity.CinemaComplex;
import com.vuhien.application.model.request.CinemaComplexRequest;
import com.vuhien.application.service.CinemaComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by VuHien96 on 18/08/2021 11:35
 */
@RestController
@RequestMapping("/api/cinema-complex")
public class CinemaComplexController {

    @Autowired
    private CinemaComplexService cinemaComplexService;

    @PostMapping("/search")
    public ResponseEntity<Object> getCinemaComplexPages(@RequestBody CinemaComplex cinemaComplex, Pageable pageable) {
        Page<CinemaComplex> cinemaComplexPage = cinemaComplexService.getCinemaComplexPages(cinemaComplex, pageable);
        return new ResponseEntity<>(cinemaComplexPage, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAllCinemaComplex() {
        List<CinemaComplex> cinemaComplexList = cinemaComplexService.getAllCinemaComplex();
        return new ResponseEntity<>(cinemaComplexList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCinemaById(@PathVariable String id) {
        CinemaComplex cinemaComplex = cinemaComplexService.getCinemaComplexById(id);
        return new ResponseEntity<>(cinemaComplex, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createCinemaComplex(@RequestBody CinemaComplexRequest cinemaComplexRequest) {
        CinemaComplex cinemaComplex = cinemaComplexService.createCinemaComplex(cinemaComplexRequest);
        return new ResponseEntity<>(cinemaComplex, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCinemaComplex(@RequestBody CinemaComplexRequest cinemaComplexRequest, @PathVariable String id) {
        cinemaComplexService.updateCinemaComplex(cinemaComplexRequest, id);
        return new ResponseEntity<>("Cập nhật thành công", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCinemaComplex(@PathVariable String id) {
        cinemaComplexService.deleteCinemaComplex(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
