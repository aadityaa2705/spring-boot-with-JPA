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
@Table(name = "languages")
public class Language {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	@Id
	private Integer languageId;

	@Column(name = "name")
	private String name;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "language")
	@JoinColumn(name="language_id")
	private Movie movie;
}
