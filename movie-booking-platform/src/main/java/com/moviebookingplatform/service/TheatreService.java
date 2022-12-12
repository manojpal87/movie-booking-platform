package com.moviebookingplatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingplatform.entity.Movie;
import com.moviebookingplatform.entity.Theatre;
import com.moviebookingplatform.repository.MovieRepository;
import com.moviebookingplatform.repository.TheatreRepository;
import com.moviebookingplatform.service.kafka.KafkaPublisher;
import com.moviebookingplatform.util.ApplicationConstant;
import com.moviebookingplatform.util.ShowTime;

/**
 * This service will be responsible for theatres on-boarding and their
 * operations.
 * 
 * @author manojpal
 *
 */
@Service
public class TheatreService {

	@Autowired
	private TheatreRepository repository;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private KafkaPublisher kafkaPublisher;

	/**
	 * This API will perform below operations- <BR>
	 * <Li>1- Onboard theatre in database
	 * <Li>2- Publish the notification in kafka cluster so that theatre would be
	 * available for search service.
	 * 
	 * @param theatre
	 * @return
	 */
	public Theatre createTheatre(Theatre theatre) {

		Theatre persistedEntity = repository.save(theatre);
		kafkaPublisher.publish(ApplicationConstant.NEW_THEATRE_ONBOARDED, persistedEntity);

		return persistedEntity;
	}

	/**
	 * Assuming that only movie update will happen.
	 * 
	 * @param theatre
	 * @param theatreId
	 * @return
	 */
	public Theatre updateTheatre(Theatre theatre, int theatreId) {
		Optional<Theatre> optionalData = repository.findById(theatreId);

		if (optionalData.isPresent()) {
			Theatre data = optionalData.get();

			data.setMovies(theatre.getMovies());
			return repository.save(data);
		}
		return null;
	}

	public Theatre fetchById(int theatreId) {

		Optional<Theatre> optionalData = repository.findById(theatreId);
		Theatre theatre = optionalData.orElseThrow();
		// TODO - need to see the association mapping even explicitly trigger not
		// working
		// theatre.setMovies(movieRepository.findAllByTheatreId(theatre.getId()));

		return theatre;
	}

	public List<Theatre> fetchAll() {

		return repository.findAll();
	}

	public Movie fetchMovieById(int movieId) {

		return movieRepository.findById(movieId).orElseThrow();
	}

	public List<Theatre> searchTheatreByShowTime(ShowTime showTime) {

		return repository.findAllByTheatreId(showTime);
	}

}
