package com.moviebookingplatform.util;

import org.springframework.stereotype.Component;

/**
 * Different rule can be configured here. I have made this as a final so that
 * rule cannot be overridden. But this can be changed as per the requirement.
 * Also better approach would be to configure rules in database. Rules can be
 * attach at movie level, theatre level or user level also.
 * 
 * @author manojpal
 *
 */
@Component
public final class RuleTemplate {

	public Object fetchRuleTemplate(int movieId) {
		return null;
	}

}
