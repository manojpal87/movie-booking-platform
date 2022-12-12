package com.moviebookingplatform.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * This controller is responsible for fetching the booking details.<Br>
 * This will interact with cache first then actual booking database cluster.
 * <Br>
 * For archived or older history this will connect with cassandra cluster.
 * 
 * @author manojpal
 *
 */
@RestController
public class BookingManagementController {

}
