package com.vuhien.application.service;

import com.vuhien.application.entity.Cinema;
import com.vuhien.application.model.request.CinemaRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by VuHien96 on 18/08/2021 14:10
 */
@Service
public interface CinemaService {
    Page<Cinema> getCinemaPage(Cinema cinema, Pageable pageable);
    List<Cinema> getAllCinema();
    Cinema getCinemaById(Long id);
    Cinema createCinema(CinemaRequest cinemaRequest);
    void updateCinema(CinemaRequest cinemaRequest,Long id);
    void deleteCinema(Long id);
}
