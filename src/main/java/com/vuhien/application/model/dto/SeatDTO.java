package com.vuhien.application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by VuHien96 on 20/08/2021 17:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SeatDTO {
    private Long seatId;
    private String rowName;
    private String seatName;
    private String orderNumber;
    private String seatTypeId;
    private String cinemaId;
    private boolean status;
}
