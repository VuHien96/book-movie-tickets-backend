package com.vuhien.application.repository;

import com.vuhien.application.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by VuHien96 on 20/08/2021 22:26
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByMovieName(String name);

    @Query(value = "SELECT distinct m.movie_id, " +
            "m.movie_name, " +
            "m.trailer, " +
            "m.image, " +
            "m.description, " +
            "m.movie_duration, " +
            "m.movie_review, " +
            "m.director, " +
            "m.actor, " +
            "m.age, " +
            "m.published, " +
            "m.coming_soon, " +
            "m.premiere_date," +
            "m.created_at, " +
            "m.status," +
            "m.aliases," +
            "m.modified_at " +
            "FROM movie m " +
            "INNER JOIN category_movie cm ON cm.movie_id = m.movie_id " +
            "INNER JOIN categories c ON c.id = cm.category_id " +
            "WHERE 1=1 " +
            "AND (:movieName is null or lower(m.movie_name) like %:movieName%) " +
            "AND (:director is null  or lower(m.director) like %:director%) " +
            "AND (:actor is null or lower(m.actor) like %:actor%) " +
            "AND (:categoryId is null or c.id =:categoryId) ",
            countQuery = "SELECT distinct count (*) " +
                    "FROM movie m " +
                    "INNER JOIN category_movie cm ON cm.movie_id = m.movie_id " +
                    "INNER JOIN categories c ON c.id = cm.category_id " +
                    "WHERE 1=1 " +
                    "AND (:movieName is null or lower(m.movie_name) like %:movieName%) " +
                    "AND (:director is null  or lower(m.director) like %:director%) " +
                    "AND (:actor is null or lower(m.actor) like %:actor%) " +
                    "AND (:categoryId is null or c.id =:categoryId)",
            nativeQuery = true)
    Page<Movie> moviePage(@Param("movieName") String movieName,
                          @Param("director") String director,
                          @Param("actor") String actor,
                          @Param("categoryId") Long categoryId,
                          Pageable pageable);

}
