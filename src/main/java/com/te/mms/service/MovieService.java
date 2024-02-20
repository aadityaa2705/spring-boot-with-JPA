package com.te.mms.service;

import java.util.List;

import com.te.mms.dto.MovieBasicDTO;
import com.te.mms.dto.MovieDTO;
import com.te.mms.entity.Industry;

public interface MovieService {

	List<MovieDTO> getMoviesByNullRating();

	List<MovieDTO> getMoviesByRating();

	List<MovieDTO> getMoviesByIndustry(Industry industry);

	List<MovieBasicDTO> getTop5MoviesByIndustry(Industry industry);
	
}
