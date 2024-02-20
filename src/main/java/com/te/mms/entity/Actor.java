package com.te.mms.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "actors")
public class Actor {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id")
	@Id
	private Integer actorId;
	@Column(name = "name")
	private String actorName;
	@Column(name = "birth_year")
	private LocalDate birthYear;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "actors")
//	@JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "actor_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Movie> movies;

}
