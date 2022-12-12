package com.moviebookingplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Filtering criteria for movie application.Different criteria can be added.
 * 
 * @author manojpal
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {

	private String byCity;
	private String byTheatre;
	private String byMovie;
	private String ByGenre;
	private String ByShowTime;

}
