package com.vuhien.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VuHien96 on 16/08/2021 20:27
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cinemaId;
    @Column(name = "cinema_name")
    private String cinemaName;
    @Column(name = "number_seats")
    private int numberSeats;

    @ManyToOne
    @JoinColumn(name = "cinema_complex_id")
    private CinemaComplex cinemaComplex;
}
