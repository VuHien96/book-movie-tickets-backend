package com.vuhien.application.service.impl;

import com.vuhien.application.entity.CinemaComplex;
import com.vuhien.application.exception.BadRequestException;
import com.vuhien.application.exception.InternalServerException;
import com.vuhien.application.exception.NotFoundException;
import com.vuhien.application.model.mapper.CinemaComplexMapper;
import com.vuhien.application.model.request.CinemaComplexRequest;
import com.vuhien.application.repository.CinemaComplexRepository;
import com.vuhien.application.service.CinemaComplexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by VuHien96 on 18/08/2021 10:46
 */
@Component
public class CinemaComplexServiceImpl implements CinemaComplexService {

    private static final Logger logger = LoggerFactory.getLogger(CinemaComplexServiceImpl.class);

    @Autowired
    private CinemaComplexRepository cinemaComplexRepository;

    @Override
    public Page<CinemaComplex> getCinemaComplexPages(CinemaComplex cinemaComplex, Pageable pageable) {
        return cinemaComplexRepository.getCinemaComplexPages(cinemaComplex.getCinemaComplexId(), cinemaComplex.getCinemaComplexName(), pageable);
    }

    @Override
    public List<CinemaComplex> getAllCinemaComplex() {
        return cinemaComplexRepository.findAll();
    }

    @Override
    public CinemaComplex getCinemaComplexById(String id) {
        Optional<CinemaComplex> cinemaComplex = cinemaComplexRepository.findById(id);
        if (cinemaComplex.isEmpty()) {
            throw new NotFoundException("Không tồn tại");
        }
        return cinemaComplex.get();
    }

    @Override
    public CinemaComplex createCinemaComplex(CinemaComplexRequest cinemaComplexRequest) {
        Optional<CinemaComplex> cc = cinemaComplexRepository.findByCinemaComplexName(cinemaComplexRequest.getCinemaComplexName());
        if (cc.isPresent()) {
            throw new BadRequestException("Tên đã tồn tại trong hệ thống");
        }
        CinemaComplex cinemaComplex = CinemaComplexMapper.toCinemaComplex(cinemaComplexRequest);
        cinemaComplexRepository.save(cinemaComplex);
        return cinemaComplex;
    }

    @Override
    public void updateCinemaComplex(CinemaComplexRequest cinemaComplexRequest, String id) {
        Optional<CinemaComplex> rs = cinemaComplexRepository.findById(id);
        if (rs.isEmpty()) {
            throw new NotFoundException("Không tồn tại");
        }
        Optional<CinemaComplex> cc = cinemaComplexRepository.findByCinemaComplexName(cinemaComplexRequest.getCinemaComplexName());
        if (cc.isPresent()) {
            if (!cc.get().getCinemaComplexId().equals(cinemaComplexRequest.getCinemaComplexId())) {
                throw new BadRequestException("Tên đã tồn tại trong hệ thống");
            }
        }
        CinemaComplex cinemaComplex = CinemaComplexMapper.toCinemaComplex(cinemaComplexRequest, rs.get(), id);
        cinemaComplexRepository.save(cinemaComplex);
    }

    @Override
    public void deleteCinemaComplex(String id) {
        Optional<CinemaComplex> cinemaComplex = cinemaComplexRepository.findById(id);
        if (cinemaComplex.isEmpty()) {
            throw new NotFoundException("Không tồn tại");
        }
        try {
            cinemaComplexRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Có lỗi: {}", e.getMessage());
            throw new InternalServerException("Có lỗi trong khi xóa");
        }
    }
}
