package com.moviebookingplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingplatform.entity.Movie;
import com.moviebookingplatform.util.RuleTemplate;
import com.moviebookingplatform.util.ShowTime;

import lombok.extern.slf4j.Slf4j;

/**
 * This service would be responsible for applying discounts based on certain
 * rules and coupons.
 * 
 * @author manojpal
 *
 */
@Slf4j
@Service
public class DiscountService {

	@Autowired
	private RuleTemplate ruleTemplate;
	
	@Autowired
	private UserService userService;

	public Movie applyDiscountByShowTime(ShowTime showTime, Movie movie) {

		if (ShowTime.EVENING == showTime) {
			Object rule = ruleTemplate.fetchRuleTemplate(movie.getId());
			// based on the rule discounted price can be set
			log.info("Movie {s} is applicable for discount - {s}", movie.getName(), rule);
			movie.setDiscountedPrice(0);
		}

		return movie;
	}

	public Movie applyDiscountBasedOnUser(int userId, Movie movie) {
		// Here with the help of user service we can fetch the user details then we need
		// to booking history.
		// change the discounted price if user is applicable
		userService.fetchById(userId);
		return movie;
	}
}
