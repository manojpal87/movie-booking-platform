package com.moviebookingplatform.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviebookingplatform.dto.SearchCriteria;
import com.moviebookingplatform.entity.Theatre;
import com.moviebookingplatform.service.SearchService;
import com.moviebookingplatform.util.Genre;
import com.moviebookingplatform.util.ShowTime;

/**
 * Controller exposing different end points to power user movie search
 * operation.
 * 
 * @author manojpal
 *
 */
@RestController
@RequestMapping(value = "movie-booking-platform/")
public class SearchController {

	@Autowired
	SearchService searchService;

	@GetMapping("search/{theatreId}")
	public ResponseEntity<List<Theatre>> searchByTheater(@PathParam("theatreId") int theatreId) {

		return ResponseEntity.ok(searchService.searchMovieByTheatreId(theatreId));
		// Similar other end points can be exposed for different criteria
	}

	@GetMapping("search/")
	public ResponseEntity<List<Theatre>> search(@RequestParam(name = "byTheatre", required = false) String theatreName,
			@RequestParam(name = "byCity", required = false) String cityName,
			@RequestParam(name = "byMovie", required = false) String movieName,
			@RequestParam(name = "byShowTime", required = false) ShowTime showTime,
			@RequestParam(name = "byGenere", required = false) Genre genre) {

		return ResponseEntity.ok(searchService.search(SearchCriteria.builder()
				.byCity(cityName)
				.ByGenre(genre.name())
				.byMovie(movieName)
				.ByShowTime(showTime.name())
				.byTheatre(theatreName)
				.build()));
	}

}
