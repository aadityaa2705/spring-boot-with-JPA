package com.te.mms.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MovieDTO {
	private Integer movieId;
	private String title;
	private String industryType;
	private LocalDate releaseYear;
	private Double imdbRating;
	private String studio;

}
