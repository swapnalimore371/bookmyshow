package com.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookmyshow.entity.User;
import com.bookmyshow.service.MovieService;
import com.bookmyshow.service.ShowService;
import com.bookmyshow.service.TheatreService;
import com.bookmyshow.service.UserService;

@Controller
public class PageController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private ShowService showService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("movies", movieService.getMovies());
        model.addAttribute("theatres", theatreService.getAll());
        model.addAttribute("shows", showService.getAll());
        return "index";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("movies", movieService.getMovies());
        return "movies";
    }

    @GetMapping("/theatres")
    public String theatres(Model model) {
        model.addAttribute("theatres", theatreService.getAll());
        return "theatres";
    }

    @GetMapping("/shows")
    public String shows(Model model) {
        model.addAttribute("shows", showService.getAll());
        return "shows";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        try {
            userService.register(user);
            redirectAttributes.addFlashAttribute("successMessage", "Registration completed. You can log in now.");
            return "redirect:/login";
        } catch (IllegalArgumentException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/register";
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
