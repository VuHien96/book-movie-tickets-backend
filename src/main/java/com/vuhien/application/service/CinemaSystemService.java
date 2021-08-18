package com.vuhien.application.service;

import com.vuhien.application.entity.CinemaSystem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by VuHien96 on 17/08/2021 19:50
 */
@Service
public interface CinemaSystemService {
    Page<CinemaSystem> getCinemaSystemPage(CinemaSystem cinemaSystem, Pageable pageable);
    List<CinemaSystem> getAllCinemaSystem();
    CinemaSystem createCinemaSystem(CinemaSystem cinemaSystem);
    CinemaSystem getCinemaSystemById(String id);
    void updateCinemaSystem(CinemaSystem cinemaSystem,String id);
    void deleteCinemaSystem(String id);
}
