package com.vuhien.application.service.impl;

import com.vuhien.application.entity.Cinema;
import com.vuhien.application.exception.BadRequestException;
import com.vuhien.application.exception.InternalServerException;
import com.vuhien.application.exception.NotFoundException;
import com.vuhien.application.model.mapper.CinemaMapper;
import com.vuhien.application.model.request.CinemaRequest;
import com.vuhien.application.repository.CinemaRepository;
import com.vuhien.application.service.CinemaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by VuHien96 on 18/08/2021 14:10
 */
@Component
public class CinemaServiceImpl implements CinemaService {

    private static final Logger logger = LoggerFactory.getLogger(CinemaServiceImpl.class);

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public Page<Cinema> getCinemaPage(Cinema cinema, Pageable pageable) {
        return cinemaRepository.getCinemaPage(cinema.getCinemaName(), pageable);
    }

    @Override
    public List<Cinema> getAllCinema() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema getCinemaById(Long id) {
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        if (cinema.isEmpty()) {
            throw new NotFoundException("Rạp không tồn tại");
        }
        return cinema.get();
    }

    @Override
    public Cinema createCinema(CinemaRequest cinemaRequest) {
        Optional<Cinema> cinema = cinemaRepository.findByCinemaName(cinemaRequest.getCinemaName());
        if (cinema.isPresent()) {
            throw new BadRequestException("Tên rạp đã tồn tại trong hệ thống");
        }
        Cinema c = CinemaMapper.toCinema(cinemaRequest);
        cinemaRepository.save(c);
        return c;
    }

    @Override
    public void updateCinema(CinemaRequest cinemaRequest, Long id) {
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        if (cinema.isEmpty()) {
            throw new NotFoundException("Rạp không tồn tại");
        }
        Cinema rs = CinemaMapper.toCinema(cinemaRequest, cinema.get(), id);
        cinemaRepository.save(rs);
    }

    @Override
    public void deleteCinema(Long id) {
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        if (cinema.isEmpty()) {
            throw new NotFoundException("Rạp không tồn tại");
        }
        try {
            cinemaRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Có lỗi: {}", e.getMessage());
            throw new InternalServerException("Có lỗi trong khi xóa");
        }
    }
}
