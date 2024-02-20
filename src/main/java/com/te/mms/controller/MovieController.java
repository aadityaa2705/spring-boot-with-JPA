package com.te.mms.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.mms.dto.MovieBasicDTO;
import com.te.mms.dto.MovieDTO;
import com.te.mms.entity.Industry;
import com.te.mms.response.ApiResponse;
import com.te.mms.service.MovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "api/movies")
@RestController
public class MovieController {

	private final MovieService movieService;

	@GetMapping("rating/null")
	public ResponseEntity<ApiResponse> getMoviesByNullRating() {
		List<MovieDTO> movies = movieService.getMoviesByNullRating();
		return ResponseEntity
				.<ApiResponse>ofNullable(ApiResponse.builder().message("Get movies api worked successfully.")
						.timestamp(LocalDateTime.now()).data(movies).status(HttpStatus.OK).build());
	}
	
	@GetMapping("rating")
	public ResponseEntity<ApiResponse> getMoviesByRating() {
		List<MovieDTO> movies = movieService.getMoviesByRating();
		return ResponseEntity
				.<ApiResponse>ofNullable(ApiResponse.builder().message("Get movies api worked successfully.")
						.timestamp(LocalDateTime.now()).data(movies).status(HttpStatus.OK).build());
	}
	//TODO: Write a SQL query to retrieve all Bollywood movies, ordering them by IMDb rating in descending order.
	
	@GetMapping("industry")
	public ResponseEntity<ApiResponse> getMoviesByIndustry(@RequestParam(name = "type") Industry industry) {
		List<MovieDTO> movies = movieService.getMoviesByIndustry(industry);
		return ResponseEntity
				.<ApiResponse>ofNullable(ApiResponse.builder().message("Get movies api worked successfully.")
						.timestamp(LocalDateTime.now()).data(movies).status(HttpStatus.OK).build());
	}
	
	//TODO: create a SQL query to select the top 5 Bollywood movies with the lowest IMDb ratings, ordered in ascending order

	@GetMapping("")
	public ResponseEntity<ApiResponse> getTop5MoviesByIndustry(@RequestParam(name = "type") Industry industry) {
		List<MovieBasicDTO> movies = movieService.getTop5MoviesByIndustry(industry);
		return ResponseEntity
				.<ApiResponse>ofNullable(ApiResponse.builder().message("Get movies api worked successfully.")
						.timestamp(LocalDateTime.now()).data(movies).status(HttpStatus.OK).build());
	}
	
}
