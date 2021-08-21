package com.vuhien.application.service;

import com.vuhien.application.entity.Movie;
import com.vuhien.application.model.dto.MovieDTO;
import com.vuhien.application.model.request.MovieRequest;
import com.vuhien.application.model.request.MovieSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Created by VuHien96 on 21/08/2021 10:14
 */
@Service
public interface MovieService {
    Page<MovieDTO> moviePages(MovieSearchRequest request, Pageable pageable);
    Movie getMovieById(Long id);
    Movie createMovie(MovieRequest movieRequest);
    void updateMovie(MovieRequest movieRequest,Long id);
    void deleteMovie(Long id);
}
