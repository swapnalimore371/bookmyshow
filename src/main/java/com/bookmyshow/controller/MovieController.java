package com.bookmyshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.service.MovieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

@Autowired
MovieService movieService;


// Get all movies
@GetMapping
public List<Movie> getMovies(){
return movieService.getMovies();
}


// Get movie by id
@GetMapping("/{id}")
public Movie getMovieById(@PathVariable Long id){
return movieService.getMovieById(id);
}


// Add movie
@PostMapping
public Movie addMovie(@Valid @RequestBody Movie movie){
return movieService.addMovie(movie);
}


// Update movie
@PutMapping("/{id}")
public Movie updateMovie(@PathVariable Long id, @Valid @RequestBody Movie movie){
return movieService.updateMovie(id, movie);
}


// Delete movie
@DeleteMapping("/{id}")
public String deleteMovie(@PathVariable Long id){
try {
return movieService.deleteMovie(id);
} catch (IllegalArgumentException ex) {
throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
}
}

}
