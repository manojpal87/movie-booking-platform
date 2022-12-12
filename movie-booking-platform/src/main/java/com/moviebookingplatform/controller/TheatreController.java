package com.moviebookingplatform.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebookingplatform.entity.Theatre;
import com.moviebookingplatform.service.TheatreService;

@RestController
@RequestMapping(value = "movie-booking-platform/")
public class TheatreController {

	@Autowired
	private TheatreService theatreService;

	/**
	 * This end point will be used to on-board new theatre.
	 * 
	 * 
	 * @param theatre
	 * @return
	 */

	@PostMapping("theatres")
	public ResponseEntity<Theatre> onboardTheatre(@Valid @RequestBody Theatre theatre) {
		/*
		 * Enterprise/real application will have following things - 1- DTO needs to be
		 * exposed instead of persistent entity and data assemblers will be used for
		 * conversion 2- Header can be introduced and validated
		 */

		return new ResponseEntity<Theatre>(theatreService.createTheatre(theatre), HttpStatus.CREATED);
	}

	@GetMapping("theatres")
	public ResponseEntity<List<Theatre>> fetchTheatreList() {

		return ResponseEntity.ok(theatreService.fetchAll());
	}

	@GetMapping("theatres/{id}")
	public ResponseEntity<Theatre> fetchById(@PathVariable("id") int theatreId) {

		return ResponseEntity.ok(theatreService.fetchById(theatreId));
	}

	@PutMapping("theatres/{id}")
	public ResponseEntity<Theatre> updateTheatre(@RequestBody Theatre theatre, @PathVariable("id") int theatreId) {
		return new ResponseEntity<Theatre>(theatreService.updateTheatre(theatre, theatreId), HttpStatus.ACCEPTED);
	}

}
