package com.moviebookingplatform.dto;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.moviebookingplatform.util.ShowTime;

import lombok.Data;

@Data
@Validated
public class BookingDto {

	@NotNull
	private String theatreName;
	@NotNull
	private String movieName;
	@NotNull
	private int userId;
	@NotNull
	private int numberOfSeats;
	@NotNull
	private ShowTime showTime;

}
