package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	/**
	 * Get all movies
	 */
	public List<Movie> getAllMovies(){
		System.out.println("Fetching all movies");
		List<Movie> movies = movieRepository.findAll();
		System.out.println("Found "+ movies.size()+"movies");
		return movies;
	}
	
	/**
	 * Get a movie by id
	 */
	public Movie getMovieById(Long id) {
		System.out.println("Searching for the movie by id:" + id);
		
		//findById returns Optional<Movie>
		//orElseThrow: if error throws exception
		return movieRepository.findById(id)
				.orElseThrow(()->{
					System.out.println("Movie not Found by id: "+id);
					return new MovieNotFoundException(id);
				});
	}
	
	/**
	 * Create a new movie (POST method)
	 */
	public Movie createMovie(Movie movie) {
		 System.out.println("Creating new movie: " + movie.getTitle());
	        
	     // Validate business rules
	     validateMovieBusinessRules(movie);
	        
	     // Save to repository
	     Movie savedMovie = movieRepository.save(movie);
	        
	     System.out.println("Movie created successfully with ID: " + savedMovie.getId());
	     return savedMovie;
	}
	
	/**
     * Get movies by genre
     */
    public List<Movie> getMoviesByGenre(String genre) {
        System.out.println("Fetching movies with genre: " + genre);
        return movieRepository.findByGenre(genre);
    }
    
    /**
     * Get movie count
     */
    public long getMovieCount() {
        return movieRepository.count();
    }
    
    //==========Bussiness Validation==========
    private void validateMovieBusinessRules(Movie movie) {
        // Example: Rating must be set for movies before 2020
        if (movie.getReleaseYear() != null && 
            movie.getReleaseYear() < 2020 && 
            movie.getRating() == null) {
            System.out.println("Warning: Older movie without rating");
            // Could throw exception or set default rating
            movie.setRating(0.0);
        }
        
        // Example: Default duration if not provided
        if (movie.getDurationMinutes() == null) {
            movie.setDurationMinutes(120); // Default 2 hours
        }
    }
    
	
}
