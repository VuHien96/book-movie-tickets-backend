package com.vuhien.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VuHien96 on 16/08/2021 17:28
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "cinema_system")
public class CinemaSystem {
    @Id
    @Column(name = "cinema_system_id")
    private String cinemaSystemId;
    @Column(name = "cinema_system_name")
    private String cinemaSystemName;
    @Column(name = "logo")
    private String logo;
    @Column(name = "aliases")
    private String aliases;
}
