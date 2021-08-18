package com.vuhien.application.model.mapper;

import com.vuhien.application.entity.Cinema;
import com.vuhien.application.entity.CinemaComplex;
import com.vuhien.application.model.request.CinemaRequest;

/**
 * Created by VuHien96 on 18/08/2021 20:31
 */
public class CinemaMapper {
    public static Cinema toCinema(CinemaRequest cinemaRequest) {
        Cinema cinema = new Cinema();
        cinema.setCinemaName(cinemaRequest.getCinemaName());
        cinema.setNumberSeats(cinemaRequest.getNumberSeats());
        CinemaComplex cinemaComplex = new CinemaComplex();
        cinemaComplex.setCinemaComplexId(cinemaRequest.getCinemaComplexId());
        cinema.setCinemaComplex(cinemaComplex);

        return cinema;
    }

    public static Cinema toCinema(CinemaRequest cinemaRequest, Cinema cinema, Long id) {
        cinema.setCinemaId(id);
        cinema.setCinemaName(cinemaRequest.getCinemaName());
        cinema.setNumberSeats(cinemaRequest.getNumberSeats());
        CinemaComplex cinemaComplex = new CinemaComplex();
        cinemaComplex.setCinemaComplexId(cinemaRequest.getCinemaComplexId());
        cinema.setCinemaComplex(cinemaComplex);

        return cinema;
    }
}
