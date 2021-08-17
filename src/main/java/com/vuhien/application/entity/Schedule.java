package com.vuhien.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by VuHien96 on 16/08/2021 15:39
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    @Column(name = "ticket_price")
    private float ticketPrice;
    @Column(name = "show_date")
    private LocalDateTime showDate;
    private int movieDuration;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "cinema_complex_id")
    private CinemaComplex cinemaComplex;
    @ManyToOne
    @JoinColumn(name = "cinema_system_id")
    private CinemaSystem cinemaSystem;

}
