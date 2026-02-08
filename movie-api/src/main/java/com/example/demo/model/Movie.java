package com.example.demo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//This class Represents a Movie Entity in our application
//It defines what properties a movie has and validation rules
public class Movie {
	
	//Unque id for each movie
	//If taken database we use persistence.GeneratedValue or Sequence generator depending on type of database we are using, here we are building a demo applicationusing Arraylist so not needed
	private Long id;
	
	//We use @NotBlank(cannot be null, empty or just whitespace), @Size(must be between 1 and 200 characters) as validations to this property
	@NotBlank(message="Movie title is required")
	@Size(min=1,max=200,message="Title must be between 1 and 200 characters.")
	private String title;
	
	/**
	 * Movie description
	 * @NotBlank: Required field and @Size: Max 2000 characters
	 */
	@NotBlank(message="Description is required")
	@Size(max=2000, message="Description size must be max 2000 characters")
	private String description;
	
	/**
	 * Movie genre
	 */
	@NotBlank(message="Genre is required")
	private String genre;
	
	/**
     * Release year of the movie
     * 
     * @NotNull: Cannot be null
     * @Min: Earliest movie year (1888 - first movie ever made)
     * @Max: Cannot be more than 10 years in future
     */
	@NotNull(message="Release year is required")
	@Min(value=1888, message="Release year must be after 1888")
	@Max(value=2035, message="Release year cannot be too far in the future")
	private Integer releaseYear;
	
	/**
     * Movie rating (0.0 to 10.0)So we will validate using @Min and @Max
     */
	@Min(value=0, message="Rating must be atleast 0")
	@Max(value=10, message="Rating must be atmost 10")
	private Double rating;
	
	/**
     * Director's name(We validate using @NotBlank)
     */
	@NotBlank(message = "Director name is required")
	private String director;
	
	/**
     * Duration in minutes(Simple to take in minutes as it will be confusing in hours as the movies will be 2 hours 45 min and so on)
     * (We use @Min to validate the duration)
     */
	@Min(value=1, message="Duration must be atleast 1 minute")
	private Integer durationMinutes;
	
	/**Getters and Setters methods 
	* are used in spring to convert JSON to/from object
	**/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(Integer durationMinutes) {
		this.durationMinutes = durationMinutes;
	}
	
	/**
	 * Spring needs empty constructor for creating objects
	 * when receiving JSON data from API requests
	 */
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(Long id,
			@NotBlank(message = "Movie title is required") @Size(min = 1, max = 200, message = "Title must be between 1 and 200 characters.") String title,
			@NotBlank(message = "Description is required") @Size(max = 2000, message = "Description size must be max 2000 characters") String description,
			@NotBlank(message = "Genre is required") String genre,
			@NotNull(message = "Release year is required") @Min(value = 1888, message = "Release year must be after 1888") @Max(value = 2035, message = "Release year cannot be too far in the future") Integer releaseYear,
			@Min(value = 0, message = "Rating must be atleast 0") @Max(value = 10, message = "Rating must be atmost 10") Double rating,
			@NotBlank(message = "Director name is required") String director,
			@Min(value = 1, message = "Duration must be atleast 1 minute") Integer durationMinutes) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.director = director;
		this.durationMinutes = durationMinutes;
	}
	/**
	 * toString() method returns a string representation
	 * for the Movie Object which is useful debugging and logging
	 */
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", description=" + description + ", genre=" + genre
				+ ", releaseYear=" + releaseYear + ", rating=" + rating + ", director=" + director
				+ ", durationMinutes=" + durationMinutes + "]";
	}
	
	
	
	
	
	
}
