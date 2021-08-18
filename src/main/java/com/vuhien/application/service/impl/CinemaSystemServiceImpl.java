package com.vuhien.application.service.impl;

import com.github.slugify.Slugify;
import com.vuhien.application.entity.CinemaSystem;
import com.vuhien.application.exception.BadRequestException;
import com.vuhien.application.exception.InternalServerException;
import com.vuhien.application.exception.NotFoundException;
import com.vuhien.application.repository.CinemaSystemRepository;
import com.vuhien.application.service.CinemaSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by VuHien96 on 17/08/2021 19:51
 */
@Component
public class CinemaSystemServiceImpl implements CinemaSystemService {
    private static final Logger logger = LoggerFactory.getLogger(CinemaSystemServiceImpl.class);

    @Autowired
    private CinemaSystemRepository cinemaSystemRepository;

    @Override
    public Page<CinemaSystem> getCinemaSystemPage(CinemaSystem cinemaSystem, Pageable pageable) {
        return cinemaSystemRepository.getCinemaSystemPage(cinemaSystem.getCinemaSystemId(), cinemaSystem.getCinemaSystemName(), pageable);
    }

    @Override
    public List<CinemaSystem> getAllCinemaSystem() {
        return cinemaSystemRepository.findAll();
    }

    @Override
    public CinemaSystem createCinemaSystem(CinemaSystem cinemaSystem) {
        Optional<CinemaSystem> cs = cinemaSystemRepository.findByCinemaSystemName(cinemaSystem.getCinemaSystemName());
        if (cs.isPresent()) {
            throw new BadRequestException("Tên đã tồn tại trong hệ thống");
        }
        CinemaSystem rs = new CinemaSystem();
        rs.setCinemaSystemId(cinemaSystem.getCinemaSystemId());
        rs.setCinemaSystemName(cinemaSystem.getCinemaSystemName());
        Slugify slugify = new Slugify();
        rs.setAliases(slugify.slugify(cinemaSystem.getCinemaSystemName()));
        rs.setLogo(cinemaSystem.getLogo());
        cinemaSystemRepository.save(rs);
        return rs;
    }

    @Override
    public CinemaSystem getCinemaSystemById(String id) {
        Optional<CinemaSystem> cinemaSystem = cinemaSystemRepository.findById(id);
        if (cinemaSystem.isEmpty()) {
            throw new NotFoundException("Không tồn tại");
        }
        return cinemaSystem.get();
    }

    @Override
    public void updateCinemaSystem(CinemaSystem cinemaSystem, String id) {
        Optional<CinemaSystem> cs = cinemaSystemRepository.findById(id);
        if (cs.isEmpty()) {
            throw new NotFoundException("Không tồn tại");
        }
        Optional<CinemaSystem> s = cinemaSystemRepository.findByCinemaSystemName(cinemaSystem.getCinemaSystemName());
        if (s.isPresent()) {
            if (!s.get().getCinemaSystemId().equals(cinemaSystem.getCinemaSystemId())) {
                throw new BadRequestException("Tên đã tồn tại trong hệ thống");
            }
        }
        CinemaSystem rs = cs.get();
        rs.setCinemaSystemId(cinemaSystem.getCinemaSystemId());
        rs.setCinemaSystemName(cinemaSystem.getCinemaSystemName());
        Slugify slugify = new Slugify();
        rs.setAliases(slugify.slugify(cinemaSystem.getCinemaSystemName()));
        rs.setLogo(cinemaSystem.getLogo());
        cinemaSystemRepository.save(rs);
    }

    @Override
    @Transactional(rollbackFor = InternalServerException.class)
    public void deleteCinemaSystem(String id) {
        Optional<CinemaSystem> cs = cinemaSystemRepository.findById(id);
        if (cs.isEmpty()) {
            throw new NotFoundException("Không tồn tại");
        }

        try {
            cinemaSystemRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Có lỗi: {}", e.getMessage());
            throw new InternalServerException("Có lỗi trong khi xóa");
        }

    }
}
