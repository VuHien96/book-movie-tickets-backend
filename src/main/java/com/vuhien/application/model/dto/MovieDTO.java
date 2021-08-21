package com.vuhien.application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by VuHien96 on 20/08/2021 22:57
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MovieDTO {
    private Long movieId;
    private String movieName;
    private String trailer;
    private String image;
    private String description;
    private int movieDuration;
    private float movieReview;
    private String director;
    private String actor;
    private String age;
    //    private String aliases;
    private boolean published;
    private boolean comingSoon;
    private LocalDateTime premiereDate;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
//    private boolean status;
//    private List<Category> categories;
}
