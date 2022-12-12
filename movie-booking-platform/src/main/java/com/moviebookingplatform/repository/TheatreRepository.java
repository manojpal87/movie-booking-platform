package com.moviebookingplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moviebookingplatform.entity.Theatre;
import com.moviebookingplatform.util.ShowTime;

/**
 * Repo to handle Theatre crud operations
 * 
 * @author manojpal
 *
 */
@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

	@Query(" select t from Theatre t , Movie m where t.id = m.theatre.id and m.showTime =:showTime and m.isAvailable = true")
	List<Theatre> findAllByTheatreId(ShowTime showTime);

}
