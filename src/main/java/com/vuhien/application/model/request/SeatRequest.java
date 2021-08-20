package com.vuhien.application.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by VuHien96 on 20/08/2021 17:05
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SeatRequest {
    private Long seatId;
    private String rowName;
    private String seatName;
    private int orderNumber;
    private Long seatTypeId;
    private Long cinemaId;
    private boolean status;
}
