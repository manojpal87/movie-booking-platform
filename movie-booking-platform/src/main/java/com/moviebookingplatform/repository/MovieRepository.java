package com.moviebookingplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingplatform.entity.Movie;

/**
 * Repo to handle Movie crud operations
 * 
 * @author manojpal
 *
 */
@Repository

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	List<Movie> findAllByTheatreId(int theatreId);

}
