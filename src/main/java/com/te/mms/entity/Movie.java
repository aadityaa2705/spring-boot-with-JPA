package com.te.mms.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "movies")
public class Movie {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "movie_id")
	private Integer movieId;

	@Column(name = "title")
	private String title;

	@Column(name = "industry")
	private String industryType;

	@Column(name = "release_year")
	private LocalDate releaseYear;
	@Column(name = "imdb_rating")
	private Double imdbRating;
	@Column(name = "studio")

	private String studio;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "language_id",referencedColumnName = "language_id")
	private Language language;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private List<Actor> actors;
	@OneToOne(mappedBy = "movie")
	private Financial financial;

}
