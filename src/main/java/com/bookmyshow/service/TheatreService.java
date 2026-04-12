package com.bookmyshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.entity.Screen;
import com.bookmyshow.entity.Theatre;
import com.bookmyshow.repository.ScreenRepository;
import com.bookmyshow.repository.TheatreRepository;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepo;

    @Autowired
    private ScreenRepository screenRepo;

    public Theatre addTheatre(Theatre theatre) {
        return theatreRepo.save(theatre);
    }

    public Screen addScreen(Screen screen) {
        if (screen.getTheatre() == null || screen.getTheatre().getId() == null) {
            throw new IllegalArgumentException("Theatre id is required");
        }

        Theatre theatre = theatreRepo.findById(screen.getTheatre().getId())
                .orElseThrow(() -> new RuntimeException("Theatre not found"));

        screen.setTheatre(theatre);
        return screenRepo.save(screen);
    }

    public List<Theatre> getAll() {
        return theatreRepo.findAll();
    }
}
