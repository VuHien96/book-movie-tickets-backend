package com.vuhien.application.service;

import com.vuhien.application.entity.CinemaComplex;
import com.vuhien.application.model.request.CinemaComplexRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by VuHien96 on 18/08/2021 10:46
 */
@Service
public interface CinemaComplexService {
    Page<CinemaComplex> getCinemaComplexPages(CinemaComplex cinemaComplex, Pageable pageable);
    List<CinemaComplex> getAllCinemaComplex();
    CinemaComplex getCinemaComplexById(String id);
    CinemaComplex createCinemaComplex(CinemaComplexRequest cinemaComplexRequest);
    void updateCinemaComplex(CinemaComplexRequest cinemaComplexRequest, String id);
    void deleteCinemaComplex(String id);
}
