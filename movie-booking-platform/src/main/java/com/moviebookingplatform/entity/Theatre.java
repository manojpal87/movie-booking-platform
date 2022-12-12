package com.moviebookingplatform.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class holds theatre details
 * 
 * @author manojpal
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "theatre")
public class Theatre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "name", unique = true)
	@NotNull
	private String name;

	@Column(name = "address")
	private String address;

	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Movie> movies;

	@Column(name = "total_seat")
	@NotNull
	private int totalSeat;

	@Column(name = "seat_available", nullable = false)
	private int seatAvailable;

}
