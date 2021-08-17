package com.vuhien.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by VuHien96 on 16/08/2021 21:46
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    @Column(name = "ticket_price")
    private float ticketPrice;
    @Column(name = "surcharge")
    private long surcharge;
    @Column(name = "status")
    private boolean status;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
