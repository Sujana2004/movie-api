package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/web")
public class MovieWebController {
    //This controller is to view in browser and will be easy for others to create movie during deployment
    private final MovieService movieService;
    
    public MovieWebController(MovieService movieService) {
        this.movieService = movieService;
    }
    
    // Home Page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Movie API!");
        model.addAttribute("movieCount", movieService.getMovieCount());
        return "index";
    }
    
    // List All Movies
    @GetMapping("/movies")
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("totalCount", movieService.getMovieCount());
        return "movieList";
    }
    
    // Show Add Movie Form
    @GetMapping("/movies/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "addMovie";
    }
    
    // Process Add Movie Form
    @PostMapping("/movies/add")
    public String addMovie(@Valid @ModelAttribute("movie") Movie movie,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            return "addMovie";
        }
        movieService.createMovie(movie);
        return "redirect:/web/movies";
    }
    
    // Show Genre Selection Page
    @GetMapping("/movies/genre")
    public String showGenreSelection(Model model) {
        model.addAttribute("totalCount", movieService.getMovieCount());
        return "genreSelect";
    }
    
    // Get Movies by Genre
    @GetMapping("/movies/genre/{genre}")
    public String getMoviesByGenre(@PathVariable String genre, Model model) {
        List<Movie> movies = movieService.getMoviesByGenre(genre);
        model.addAttribute("movies", movies);
        model.addAttribute("genre", genre);
        model.addAttribute("count", movies.size());
        return "moviesByGenre";
    }
    
    // Show Movie Count Page
    @GetMapping("/movies/count")
    public String showMovieCount(Model model) {
        model.addAttribute("count", movieService.getMovieCount());
        return "movieCount";
    }
}
