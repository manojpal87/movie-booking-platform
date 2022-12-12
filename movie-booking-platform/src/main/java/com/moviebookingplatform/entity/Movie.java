package com.moviebookingplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.moviebookingplatform.util.Genre;
import com.moviebookingplatform.util.ShowTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class holds movie related details.
 * 
 * @author manojpal
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name = "theatre_id")
	private Theatre theatre;

	@Column(name = "name")
	private String name;

	@Column(name = "language")
	private String language;

	@Enumerated(EnumType.STRING)
	@Column(name = "genre")
	private Genre genere;

	@Enumerated(EnumType.STRING)
	@Column(name = "show_time")
	private ShowTime showTime;

	@Column(name = "is_available")
	private Boolean isAvailable;

	@Column(name = "actual_ticket_Price")
	private int actualTicketPrice;

	@Column(name = "discounted_Price")
	private int discountedPrice;

}
