package com.vuhien.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by VuHien96 on 16/08/2021 15:37
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "trailer")
    private String trailer;
    @Column(name = "image")
    private String image;
    @Column(name = "description")
    private String description;
    @Column(name = "movie_duration")
    private int movieDuration;
    @Column(name = "movie_review")
    private float movieReview;
    @Column(name = "director")
    private String director;
    @Column(name = "actor")
    private String actor;
    @Column(name = "age")
    private String age;
    @Column(name = "aliases")
    private String aliases;
    @Column(name = "published")
    private boolean published;
    @Column(name = "coming_soon")
    private boolean comingSoon;
    @Column(name = "premiere_date")
    private LocalDateTime premiereDate;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
    @Column(name = "status")
    private boolean status;

    @ManyToMany
    @JoinTable(name = "category_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_movie_id"))
    private List<CategoryMovie> categoryMovies;

}
