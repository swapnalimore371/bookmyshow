package com.bookmyshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Show;
import com.bookmyshow.entity.Screen;
import com.bookmyshow.entity.Theatre;
import com.bookmyshow.repository.MovieRepository;
import com.bookmyshow.repository.ShowRepository;
import com.bookmyshow.repository.ScreenRepository;
import com.bookmyshow.repository.TheatreRepository;

@Service
public class ShowService {

    @Autowired
    private ShowRepository repo;

    @Autowired
    private TheatreRepository theatreRepo;

    @Autowired
    private ScreenRepository screenRepo;

    @Autowired
    private MovieRepository movieRepo;

    public Show addShow(Show show){
        if (show.getMovie() == null || show.getMovie().getId() == null) {
            throw new IllegalArgumentException("Movie id is required");
        }
        if (show.getTheatre() == null || show.getTheatre().getId() == null) {
            throw new IllegalArgumentException("Theatre id is required");
        }
        if (show.getScreen() == null || show.getScreen().getId() == null) {
            throw new IllegalArgumentException("Screen id is required");
        }

        Movie movie = movieRepo.findById(show.getMovie().getId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Theatre theatre = theatreRepo.findById(show.getTheatre().getId())
                .orElseThrow(() -> new RuntimeException("Theatre not found"));

        Screen screen = screenRepo.findById(show.getScreen().getId())
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        if (screen.getTheatre() == null || !screen.getTheatre().getId().equals(theatre.getId())) {
            throw new RuntimeException("Screen does not belong to the selected theatre");
        }

        show.setMovie(movie);
        show.setTheatre(theatre);
        show.setScreen(screen);
        if (show.getAvailableSeats() <= 0) {
            show.setAvailableSeats(screen.getTotalSeats());
        }

        return repo.save(show);
    }

    public List<Show> getAll(){
        return repo.findAll();
    }
}
