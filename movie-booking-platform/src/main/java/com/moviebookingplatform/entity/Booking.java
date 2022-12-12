package com.moviebookingplatform.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.moviebookingplatform.util.BookingStatus;
import com.moviebookingplatform.util.ShowTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class holds booking details
 * 
 * @author manojpal
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking_details")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int bookingId;

	@Column(name = "theatre_id")
	private int theatreId;

	@Column(name = "movie_id")
	private int movieId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "number_Of_Seats")
	private int numberOfSeats;

	@Column(name = "booking_date")
	private LocalDate bookingDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "show_time")
	private ShowTime showTime;

	@Enumerated(EnumType.STRING)
	@Column(name = "booking_status")
	private BookingStatus bookingStatus;

}
