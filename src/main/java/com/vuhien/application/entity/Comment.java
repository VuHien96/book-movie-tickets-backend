package com.vuhien.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by VuHien96 on 16/08/2021 21:25
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentReviewId;
    @Column(name = "content")
    private String content;
    @Column(name = "rating")
    private float rating;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
