package com.te.mms.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "financials")
public class Financial {
	@Column(name = "movie_id")
	@Id
	private Integer movieId;
	
	@Column(name = "budget")
	private Double budget;
	@Column(name = "revenue")
	private Double revenue;
	@Column(name = "unit")
	private Unit unitType;
	@Column(name = "currency")
	private Currency currencyType;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
	private Movie movie;
}
