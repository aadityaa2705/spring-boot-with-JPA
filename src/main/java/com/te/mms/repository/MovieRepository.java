package com.te.mms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.mms.entity.Industry;
import com.te.mms.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	List<Movie> findByImdbRatingIsNull();

	List<Movie> findByImdbRatingIsNotNull();

	List<Movie> findByIndustryTypeOrderByImdbRatingDesc(Industry industry);
	
	List<Movie> findTop5ByIndustryTypeOrderByImdbRatingAsc(Industry industry);
}
