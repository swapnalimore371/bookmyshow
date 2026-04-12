package com.bookmyshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.repository.MovieRepository;

@Service
public class MovieService {

@Autowired
MovieRepository movieRepository;


// Get all movies
public List<Movie> getMovies(){
return movieRepository.findAll();
}


// Get movie by ID
public Movie getMovieById(Long id){
return movieRepository.findById(id)
		.orElseThrow(() -> new IllegalArgumentException("Movie not found with id: " + id));
}


// Add movie
public Movie addMovie(Movie movie){
return movieRepository.save(movie);
}


// Update movie
@Transactional
public Movie updateMovie(Long id, Movie movie){

Movie existingMovie = movieRepository.findById(id)
		.orElseThrow(() -> new IllegalArgumentException("Movie not found with id: " + id));

existingMovie.setTitle(movie.getTitle());
existingMovie.setDescription(movie.getDescription());
existingMovie.setGenre(movie.getGenre());
existingMovie.setLanguage(movie.getLanguage());
existingMovie.setDuration(movie.getDuration());
existingMovie.setTrailerLink(movie.getTrailerLink());
existingMovie.setReleaseDate(movie.getReleaseDate());
existingMovie.setPosterUrl(movie.getPosterUrl());
existingMovie.setRating(movie.getRating());
existingMovie.setDirector(movie.getDirector());
existingMovie.setCast(movie.getCast());

return movieRepository.save(existingMovie);
}


// Delete movie
public String deleteMovie(Long id){
if(!movieRepository.existsById(id)) {
	throw new IllegalArgumentException("Movie not found with id: " + id);
}

movieRepository.deleteById(id);

return "Movie Deleted Successfully";
}

}
