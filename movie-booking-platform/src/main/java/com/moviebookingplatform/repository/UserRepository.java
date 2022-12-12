package com.moviebookingplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingplatform.entity.User;

/**
 * Repo to handle user crud operations
 * 
 * @author manojpal
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
