package com.te.mms.dto;

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
public class MovieBasicDTO {
	private String title;
	private String industryType;
	private Double imdbRating;
	private String studio;
}
