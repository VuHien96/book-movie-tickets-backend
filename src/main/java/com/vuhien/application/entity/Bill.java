package com.vuhien.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by VuHien96 on 16/08/2021 22:10
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;
    @Column(name = "total_price")
    private float totalPrice;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "status")
    private boolean status;
    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
