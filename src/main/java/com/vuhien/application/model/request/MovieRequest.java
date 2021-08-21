package com.vuhien.application.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by VuHien96 on 21/08/2021 00:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MovieRequest {
    @NotBlank(message = "Tên phim trống")
    private String movieName;
    @NotBlank(message = "Trailer phim trống")
    private String trailer;
    @NotBlank(message = "Ảnh phim trống")
    private String image;
    private String description;
    private int movieDuration;
    private String director;
    @NotBlank(message = "Diễn viên trống")
    private String actor;
    private String age;
    private boolean published;
    private boolean comingSoon;
    private LocalDateTime premiereDate;
    private boolean status;
    @NotNull(message = "Danh mục trống")
    private List<Long> categoryIds;
}
