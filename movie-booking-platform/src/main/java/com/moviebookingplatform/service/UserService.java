package com.moviebookingplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingplatform.entity.User;
import com.moviebookingplatform.repository.UserRepository;

/**
 * API responsible for user maintenance.
 * 
 * @author manojpal
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User fetchById(int userId) {

		return repository.findById(userId).orElseThrow();
	}

}
