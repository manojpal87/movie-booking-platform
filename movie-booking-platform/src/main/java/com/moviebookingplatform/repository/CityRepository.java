package com.moviebookingplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingplatform.entity.City;

/**
 * Repo to handle City crud operations
 * 
 * @author manojpal
 *
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
