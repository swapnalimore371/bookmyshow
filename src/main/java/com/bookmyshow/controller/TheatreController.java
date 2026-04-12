package com.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.bookmyshow.entity.*;
import com.bookmyshow.service.TheatreService;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    @Autowired
    TheatreService service;

    @PostMapping
    public Theatre addTheatre(@RequestBody Theatre theatre){
        return service.addTheatre(theatre);
    }

    @PostMapping("/screen")
    public Screen addScreen(@RequestBody Screen screen){
        return service.addScreen(screen);
    }

    @GetMapping
    public List<Theatre> getAll(){
        return service.getAll();
    }
}