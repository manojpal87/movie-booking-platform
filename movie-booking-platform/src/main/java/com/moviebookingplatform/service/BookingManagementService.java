package com.moviebookingplatform.service;

import org.springframework.stereotype.Service;

/**
 * 
 * This service is responsible for fetching the booking details.<Br>
 * This will interact with cache first then actual booking database cluster.
 * <Br>
 * For archived or older history this will connect with cassandra cluster.
 * 
 * @author manojpal
 *
 */
@Service
public class BookingManagementService {

}
