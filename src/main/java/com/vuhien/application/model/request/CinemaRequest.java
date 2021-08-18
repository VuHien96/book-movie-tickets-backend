package com.vuhien.application.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by VuHien96 on 18/08/2021 14:13
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CinemaRequest {
    private String cinemaName;
    private int numberSeats;
    private String cinemaComplexId;
}
