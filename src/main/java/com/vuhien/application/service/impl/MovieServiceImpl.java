package com.vuhien.application.service.impl;

import com.vuhien.application.entity.Movie;
import com.vuhien.application.exception.BadRequestException;
import com.vuhien.application.exception.InternalServerException;
import com.vuhien.application.exception.NotFoundException;
import com.vuhien.application.model.dto.MovieDTO;
import com.vuhien.application.model.mapper.MovieMapper;
import com.vuhien.application.model.request.MovieRequest;
import com.vuhien.application.model.request.MovieSearchRequest;
import com.vuhien.application.repository.MovieRepository;
import com.vuhien.application.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by VuHien96 on 21/08/2021 11:16
 */
@Component
public class MovieServiceImpl implements MovieService {
    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Page<MovieDTO> moviePages(MovieSearchRequest request, Pageable pageable) {
        Page<Movie> movies = movieRepository.moviePage(request.getMovieName(),
                request.getDirector(),
                request.getActor(),
                request.getCategoryId(),
                pageable);
        return movies.map(MovieMapper::toMovieDTO);
    }

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()) {
            throw new NotFoundException("Phim không tồn tại");
        }
        return movie.get();
    }

    @Override
    public Movie createMovie(MovieRequest movieRequest) {
        Optional<Movie> movie = movieRepository.findByMovieName(movieRequest.getMovieName());
        if (movie.isPresent()) {
            throw new BadRequestException("Tên phim đã tồn tại");
        }
        Movie rs = MovieMapper.toMovie(movieRequest);
        movieRepository.save(rs);
        return rs;
    }

    @Override
    public void updateMovie(MovieRequest movieRequest, Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()) {
            throw new NotFoundException("Phim không tồn tại");
        }
        Movie rs = MovieMapper.toMovie(movieRequest, movie.get(), id);
        movieRepository.save(rs);
    }

    @Override
    public void deleteMovie(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()) {
            throw new NotFoundException("Phim không tồn tại");
        }
        try {
            movieRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Có lỗi: {}", e.getMessage());
            throw new InternalServerException("Có lỗi trong khi xóa");
        }
    }
}
