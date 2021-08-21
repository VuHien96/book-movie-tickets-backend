package com.vuhien.application.model.mapper;

import com.github.slugify.Slugify;
import com.vuhien.application.entity.Category;
import com.vuhien.application.entity.Movie;
import com.vuhien.application.model.dto.MovieDTO;
import com.vuhien.application.model.request.MovieRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VuHien96 on 20/08/2021 23:37
 */
public class MovieMapper {

    private MovieMapper() {
    }

    public static MovieDTO toMovieDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movie.getMovieId());
        movieDTO.setMovieName(movie.getMovieName());
        movieDTO.setTrailer(movie.getTrailer());
        movieDTO.setImage(movie.getImage());
        movieDTO.setDescription(movie.getDescription());
        movieDTO.setMovieDuration(movie.getMovieDuration());
        movieDTO.setMovieReview(movie.getMovieReview());
        movieDTO.setDirector(movie.getDirector());
        movieDTO.setActor(movie.getActor());
        movieDTO.setAge(movie.getAge());
//        movieDTO.setAliases(movie.getAliases());
        movieDTO.setPublished(movie.isPublished());
        movieDTO.setComingSoon(movie.isComingSoon());
        movieDTO.setPremiereDate(movie.getPremiereDate());
        movieDTO.setCreatedAt(movie.getCreatedAt());
        movieDTO.setModifiedAt(movie.getModifiedAt());
//        movieDTO.setStatus(movie.isStatus());
//        movieDTO.setCategories(movie.getCategories());

        return movieDTO;
    }

    public static Movie toMovie(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setMovieName(movieRequest.getMovieName());
        movie.setTrailer(movieRequest.getTrailer());
        movie.setImage(movieRequest.getImage());
        movie.setDescription(movieRequest.getDescription());
        movie.setMovieDuration(movieRequest.getMovieDuration());
        movie.setDirector(movieRequest.getDirector());
        movie.setActor(movieRequest.getActor());
        movie.setAge(movieRequest.getAge());
        Slugify slug = new Slugify();
        movie.setAliases(slug.slugify(movieRequest.getMovieName()));
        movie.setPublished(movieRequest.isPublished());
        movie.setComingSoon(movieRequest.isComingSoon());
        movie.setPremiereDate(movieRequest.getPremiereDate());
        movie.setCreatedAt(LocalDateTime.now());
        movie.setStatus(movieRequest.isStatus());
        List<Category> categories = new ArrayList<>();
        for (Long id : movieRequest.getCategoryIds()) {
            Category category = new Category();
            category.setId(id);
            categories.add(category);
        }
        movie.setCategories(categories);

        return movie;
    }

    public static Movie toMovie(MovieRequest movieRequest, Movie movie, Long movieId) {
        movie.setMovieId(movieId);
        movie.setMovieName(movieRequest.getMovieName());
        movie.setTrailer(movieRequest.getTrailer());
        movie.setImage(movieRequest.getImage());
        movie.setDescription(movieRequest.getDescription());
        movie.setMovieDuration(movieRequest.getMovieDuration());
        movie.setDirector(movieRequest.getDirector());
        movie.setActor(movieRequest.getActor());
        movie.setAge(movieRequest.getAge());
        Slugify slug = new Slugify();
        movie.setAliases(slug.slugify(movieRequest.getMovieName()));
        movie.setPublished(movieRequest.isPublished());
        movie.setComingSoon(movieRequest.isComingSoon());
        movie.setPremiereDate(movieRequest.getPremiereDate());
        movie.setModifiedAt(LocalDateTime.now());
        movie.setStatus(movieRequest.isStatus());
        List<Category> categories = new ArrayList<>();
        for (Long id : movieRequest.getCategoryIds()) {
            Category category = new Category();
            category.setId(id);
            categories.add(category);
        }
        movie.setCategories(categories);

        return movie;
    }
}
