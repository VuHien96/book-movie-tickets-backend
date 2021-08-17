package com.vuhien.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VuHien96 on 16/08/2021 19:51
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "cinema_complex")
public class CinemaComplex {
    @Id
    @Column(name = "cinema_complex_id")
    private String cinemaComplexId;
    @Column(name = "cinema_complex_name")
    private String cinemaComplexName;
    @Column(name = "information")
    private String information;

    @ManyToOne
    @JoinColumn(name = "cinema_system_id")
    private CinemaSystem cinemaSystem;
}
