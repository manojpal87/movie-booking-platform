package com.moviebookingplatform.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebookingplatform.dto.BookingDto;
import com.moviebookingplatform.service.BookingService;

import lombok.extern.slf4j.Slf4j;

/**
 * This controller is responsible for booking the seat and making the
 * payment.<Br>
 * This will talk to external payment gateway to process the payment. <Br>
 * Since this is a cloud native, multiple node scalable application hence
 * concurrency will not be handled here. <Br>
 * Optimistic locking can be implemented in database side or certain TTL can be
 * configured beyond which payment can be deemed not success. <Br>
 * 
 * 
 * @author manojpal
 *
 */
@Slf4j
@RestController
@RequestMapping(value = "movie-booking-platform/")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("book")
	public ResponseEntity<Void> onboardTheatre(@Valid @RequestBody BookingDto bookingDto) {

		log.info("Booking seats with details :" + bookingDto);

		bookingService.bookSeats(bookingDto);

		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}
