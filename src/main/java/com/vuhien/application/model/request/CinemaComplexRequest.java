package com.vuhien.application.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by VuHien96 on 18/08/2021 11:02
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CinemaComplexRequest {
    private String cinemaComplexId;
    private String cinemaComplexName;
    private String information;
    private String cinemaSystemId;
}
