package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Movie;

/**
 * This class handles all the data storage operations
 * and hibernate
 * (writes what we want in java and hibernate communicates with database using SQL)
 * is written simply in application.py
 */
@Repository
public class MovieRepository {
	
	//For demo we are using ArrayList (IN memory storage for movies)
	private final List<Movie> movies = new ArrayList<>();
	
	/**
	 * ID Generator
	 * AtomicLong: won't create duplicate IDs even in multiple requests
	 */
	private final AtomicLong idGenerator = new AtomicLong(0);
	
	/**
     * Constructor - We initialize with sample data
     * 
     * This runs when the application starts.
     * We add some sample movies so the list isn't empty.
     */
	public MovieRepository() {
		//Add sample movies for testing
		initializeSampleData();
	}
	
	private void initializeSampleData() {
        // Movie 1: Inception
        save(new Movie(
            null,                           // ID will be auto-generated
            "Inception",                    // Title
            "A thief who enters the dreams of others to steal secrets from their subconscious.",
            "Sci-Fi",                       // Genre
            2010,                           // Release Year
            8.8,                            // Rating
            "Christopher Nolan",            // Director
            148                             // Duration in minutes
        ));
        
        // Movie 2: The Shawshank Redemption
        save(new Movie(
            null,
            "The Shawshank Redemption",
            "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
            "Drama",
            1994,
            9.3,
            "Frank Darabont",
            142
        ));
        
        // Movie 3: The Dark Knight
        save(new Movie(
            null,
            "The Dark Knight",
            "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
            "Action",
            2008,
            9.0,
            "Christopher Nolan",
            152
        ));
        
        System.out.println(" Sample movies loaded: " + movies.size() + " movies");
    }
	
	//Save (Post or create) - add a new movie
	public Movie save(Movie movie) {
        // Generate new ID: incrementAndGet() returns next number (1, 2, 3...)
        Long newId = idGenerator.incrementAndGet();
        
        // Set the ID on the movie object
        movie.setId(newId);
        
        // Add to our ArrayList
        movies.add(movie);
        
        // Log for debugging
        System.out.println("Saved movie: " + movie.getTitle() + " with ID: " + newId);
        
        // Return the saved movie (now has an ID)
        return movie;
    }
	
	
	//GET- find all (only read)
	public List<Movie> findAll(){
		//Return a copy, not the original List
		return new ArrayList<>(movies);
	}
	
	//GET - find by id
	//We use Optional to avoid NullPointException
	public Optional<Movie> findById(Long id){
		//Stream through all movies, find matching ID
		return movies.stream()
				.filter(movie->movie.getId().equals(id)) //Filter By ID
				.findFirst();
	}
	
	/**
     * EXISTS BY ID - Check if a movie exists
     */
    public boolean existsById(Long id) {
        return movies.stream()
                .anyMatch(movie -> movie.getId().equals(id));
    }
    
    /**
     * COUNT - Get total number of movies
     */
    public long count() {
        return movies.size();
    }
    
    /**
     * FIND BY GENRE - Search movies by genre
     */
    public List<Movie> findByGenre(String genre) {
        return movies.stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .toList();
    }
}
