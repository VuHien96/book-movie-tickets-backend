package com.vuhien.application.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by VuHien96 on 21/08/2021 11:13
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MovieSearchRequest {
    private String movieName;
    private String director;
    private String actor;
    private Boolean published;
    private Boolean comingSoon;
    private Long categoryId;
}
