package com.vuhien.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VuHien96 on 16/08/2021 17:15
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "seat_type")
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatTypeId;
    @Column(name = "seat_type_name")
    private String seatTypeName;
    @Column(name = "description")
    private String description;
    @Column(name = "surcharge")
    private long surcharge;

}
