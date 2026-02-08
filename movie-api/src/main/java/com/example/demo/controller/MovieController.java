package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*") //allow all origins for demo
public class MovieController {
	@Autowired
	MovieService movieService;
	
	//Get all movies
	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies(){
		List<Movie> movies = movieService.getAllMovies();
		return ResponseEntity.ok(movies);
	}
	
	//Get movie by id
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
		Movie movie = movieService.getMovieById(id);
		return ResponseEntity.ok(movie);
	}
	
	//Post a movie
	@PostMapping
	public ResponseEntity<Movie> updateMovie(@Valid @RequestBody Movie movie){
		Movie createdMovie = movieService.createMovie(movie);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(createdMovie);
	}
	
	//Get by genre
	@GetMapping("/genre/{genre}")
	public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre){
		List<Movie> movies = movieService.getMoviesByGenre(genre);
		return ResponseEntity.ok(movies);
	}
	
	//Get count of movies
	@GetMapping("/count")
	public ResponseEntity<Map<String, Long>> getMovieCount(){
		long count = movieService.getMovieCount();
		Map<String, Long> response = new HashMap<>();
		response.put("count", count);
		
		return ResponseEntity.ok(response);
	}
}
