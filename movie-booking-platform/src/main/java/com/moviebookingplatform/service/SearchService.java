package com.moviebookingplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingplatform.dto.SearchCriteria;
import com.moviebookingplatform.entity.Movie;
import com.moviebookingplatform.entity.Theatre;
import com.moviebookingplatform.util.ShowTime;

/**
 * Search service responsible for serving all kind of queries, filter on movie
 * platform.<Br>
 * 
 * In actual enterprise application this service would be interacting to elastic
 * search cluster and would be consuming topics from kafka for near real time
 * data.<Br>
 * This service will also interact with rule engine to apply configured rule
 * based on the movie or user profiles.
 * 
 * 
 * @author manojpal
 *
 */
@Service
public class SearchService {

	@Autowired
	private TheatreService theatreService;

	@Autowired
	private DiscountService discountService;

	public Movie searchMovieById(int movieId) {

		Movie movie = theatreService.fetchMovieById(movieId);
		discountService.applyDiscountByShowTime(movie.getShowTime(), movie);

		return movie;
	}

	public List<Theatre> searchMovieByTheatreId(int theatreId) {

		return theatreService.fetchAll();
	}

	public List<Theatre> searchTheatreByShowTime(ShowTime showTime) {

		return theatreService.searchTheatreByShowTime(showTime);
	}

	/*
	 * There are two approach to it - <Br> 
	 * 1- Fetch the data by individual criteria
	 * then do the memory based filtering in java <Br> 2- Write the custum query in
	 * jpa to fetch the data<Br>
	 */
	public List<Theatre> search(SearchCriteria searchCriteria) {

		return null;
	}

	public List<Movie> searchMovieByCity(ShowTime showTime) {

		return null;
	}

}
