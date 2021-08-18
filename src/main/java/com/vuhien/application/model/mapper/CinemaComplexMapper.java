package com.vuhien.application.model.mapper;

import com.vuhien.application.entity.CinemaComplex;
import com.vuhien.application.entity.CinemaSystem;
import com.vuhien.application.model.request.CinemaComplexRequest;

/**
 * Created by VuHien96 on 18/08/2021 11:11
 */

public class CinemaComplexMapper {

    public static CinemaComplex toCinemaComplex(CinemaComplexRequest cinemaComplexRequest) {
        CinemaComplex cinemaComplex = new CinemaComplex();
        cinemaComplex.setCinemaComplexId(cinemaComplexRequest.getCinemaComplexId());
        cinemaComplex.setCinemaComplexName(cinemaComplexRequest.getCinemaComplexName());
        cinemaComplex.setInformation(cinemaComplexRequest.getInformation());
        CinemaSystem cinemaSystem = new CinemaSystem();
        cinemaSystem.setCinemaSystemId(cinemaComplexRequest.getCinemaSystemId());
        cinemaComplex.setCinemaSystem(cinemaSystem);

        return cinemaComplex;
    }

    public static CinemaComplex toCinemaComplex(CinemaComplexRequest cinemaComplexRequest, CinemaComplex cinemaComplex, String id) {
        cinemaComplex.setCinemaComplexId(id);
        cinemaComplex.setCinemaComplexName(cinemaComplexRequest.getCinemaComplexName());
        cinemaComplex.setInformation(cinemaComplexRequest.getInformation());
        CinemaSystem cinemaSystem = new CinemaSystem();
        cinemaSystem.setCinemaSystemId(cinemaComplexRequest.getCinemaSystemId());
        cinemaComplex.setCinemaSystem(cinemaSystem);

        return cinemaComplex;
    }
}
