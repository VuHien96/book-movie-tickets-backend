package com.vuhien.application.controller;

import com.vuhien.application.entity.Movie;
import com.vuhien.application.model.dto.MovieDTO;
import com.vuhien.application.model.request.MovieRequest;
import com.vuhien.application.model.request.MovieSearchRequest;
import com.vuhien.application.repository.MovieRepository;
import com.vuhien.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by VuHien96 on 21/08/2021 11:22
 */
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/search")
    public ResponseEntity<Object> moviePage(@RequestBody MovieSearchRequest request,
                                            @PageableDefault(sort = "movie_id",
                                                    direction = Sort.Direction.DESC) Pageable pageable) {
        Page<MovieDTO> moviePage = movieService.moviePages(request, pageable);
        return new ResponseEntity<>(moviePage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createMovie(@Valid @RequestBody MovieRequest movieRequest) {
        Movie movie = movieService.createMovie(movieRequest);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMovie(@Valid @RequestBody MovieRequest movieRequest, @PathVariable Long id) {
        movieService.updateMovie(movieRequest, id);
        return new ResponseEntity<>("Cập nhật thành công", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }

}
