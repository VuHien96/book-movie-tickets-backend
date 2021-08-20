package com.vuhien.application.service.impl;

import com.vuhien.application.entity.SeatType;
import com.vuhien.application.exception.BadRequestException;
import com.vuhien.application.exception.InternalServerException;
import com.vuhien.application.exception.NotFoundException;
import com.vuhien.application.repository.SeatTypeRepository;
import com.vuhien.application.service.SeatTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by VuHien96 on 20/08/2021 16:32
 */
@Component
public class SeatTypeServiceImpl implements SeatTypeService {
    private static final Logger logger = LoggerFactory.getLogger(SeatTypeServiceImpl.class);

    @Autowired
    private SeatTypeRepository seatTypeRepository;

    @Override
    public Page<SeatType> seatTypePage(SeatType seatType, Pageable pageable) {
        return seatTypeRepository.seatTypePage(seatType.getSeatTypeName(), pageable);
    }

    @Override
    public List<SeatType> getAllSeatType() {
        return seatTypeRepository.findAll();
    }

    @Override
    public SeatType getSeatTypeById(Long id) {
        Optional<SeatType> seatType = seatTypeRepository.findById(id);
        if (seatType.isEmpty()) {
            throw new NotFoundException("Loại ghế không tồn tại");
        }
        return seatType.get();
    }

    @Override
    public SeatType createSeatType(SeatType seatType) {
        Optional<SeatType> st = seatTypeRepository.findBySeatTypeName(seatType.getSeatTypeName());
        if (st.isPresent()) {
            throw new BadRequestException("Tên loại ghế đã tồn tại trong hệ thống");
        }
        SeatType rs = new SeatType();
        rs.setSeatTypeName(seatType.getSeatTypeName());
        rs.setDescription(seatType.getDescription());
        rs.setSurcharge(seatType.getSurcharge());
        seatTypeRepository.save(rs);
        return rs;
    }

    @Override
    public void updateSeatType(SeatType seatType, Long id) {
        Optional<SeatType> s = seatTypeRepository.findById(id);
        if (s.isEmpty()) {
            throw new NotFoundException("Loại ghế không tồn tại");
        }
        Optional<SeatType> st = seatTypeRepository.findBySeatTypeName(seatType.getSeatTypeName());
        if (st.isPresent()) {
            if (!st.get().getSeatTypeId().equals(seatType.getSeatTypeId())) {
                throw new BadRequestException("Tên loại ghế đã tồn tại trong hệ thống");
            }
        }
        SeatType rs = s.get();
        rs.setSeatTypeName(seatType.getSeatTypeName());
        rs.setDescription(seatType.getDescription());
        rs.setSurcharge(seatType.getSurcharge());
        seatTypeRepository.save(rs);
    }

    @Override
    public void deleteSeatType(Long id) {
        Optional<SeatType> s = seatTypeRepository.findById(id);
        if (s.isEmpty()) {
            throw new NotFoundException("Loại ghế không tồn tại");
        }
        try {
            seatTypeRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Có lỗi: {}", e.getMessage());
            throw new InternalServerException("Lỗi khi xóa danh mục!");
        }
    }
}
