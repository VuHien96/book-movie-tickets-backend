package com.vuhien.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by VuHien96 on 16/08/2021 16:56
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;
    @Column(name = "row_name")
    private String rowName;
    @Column(name = "seat_name")
    private String seatName;
    @Column(name = "order_number")
    private int orderNumber;
    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "seat_type_id")
    private SeatType seatType;
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;
}
