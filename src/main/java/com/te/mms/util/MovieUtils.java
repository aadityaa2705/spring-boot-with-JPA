package com.te.mms.util;

import com.te.mms.dto.MovieBasicDTO;
import com.te.mms.dto.MovieDTO;
import com.te.mms.entity.Movie;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieUtils {
	public MovieDTO convertEntityToDTO(Movie movie) {
		return MovieDTO.builder().movieId(movie.getMovieId()).title(movie.getTitle())
				.industryType(movie.getIndustryType()).imdbRating(movie.getImdbRating()).studio(movie.getStudio())
				.releaseYear(movie.getReleaseYear()).build();
	}

	public MovieBasicDTO convertEntityToBasicDTO(Movie movie) {
		return MovieBasicDTO.builder().title(movie.getTitle()).industryType(movie.getIndustryType())
				.imdbRating(movie.getImdbRating()).studio(movie.getStudio()).build();
	}
}
