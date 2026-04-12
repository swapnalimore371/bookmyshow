package com.bookmyshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.entity.Show;
import com.bookmyshow.service.ShowService;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

@Autowired
ShowService showService;

@GetMapping
public List<Show> getShows(){

return showService.getAll();

}

@PostMapping
public Show addShow(@RequestBody Show show){

return showService.addShow(show);

}

}
