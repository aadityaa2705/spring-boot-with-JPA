package com.te.mms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.mms.dto.MovieBasicDTO;
import com.te.mms.dto.MovieDTO;
import com.te.mms.entity.Industry;
import com.te.mms.repository.MovieRepository;
import com.te.mms.util.MovieUtils;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	
	private MovieRepository movieRepository;

	@Override
	public List<MovieDTO> getMoviesByNullRating() {
		return movieRepository.findByImdbRatingIsNull().stream().map(toDTO -> MovieUtils.convertEntityToDTO(toDTO))
				.collect(Collectors.toList());

	}

	@Override
	public List<MovieDTO> getMoviesByRating() {
		return movieRepository.findByImdbRatingIsNotNull().stream().map(toDTO -> MovieUtils.convertEntityToDTO(toDTO))
				.collect(Collectors.toList());
	}

	@Override
	public List<MovieDTO> getMoviesByIndustry(Industry industry) {
		return movieRepository.findByIndustryTypeOrderByImdbRatingDesc(industry).stream()
				.map(e -> MovieUtils.convertEntityToDTO(e)).collect(Collectors.toList());
	}

	@Override
	public List<MovieBasicDTO> getTop5MoviesByIndustry(Industry industry) {
		return movieRepository.findTop5ByIndustryTypeOrderByImdbRatingAsc(industry).stream()
				.map(e -> MovieUtils.convertEntityToBasicDTO(e)).collect(Collectors.toList());

	}

}
