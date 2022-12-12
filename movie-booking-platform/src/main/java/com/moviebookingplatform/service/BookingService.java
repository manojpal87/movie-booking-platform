package com.moviebookingplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.moviebookingplatform.dto.BookingDto;
import com.moviebookingplatform.service.notification.NotifactionService;

/**
 * This service is responsible for booking the seat and making the
 * payment.<Br>
 * This will talk to external payment gateway to process the payment. <Br>
 * Since this is a cloud native, multiple node scalable application hence
 * concurrency will not be handled here. <Br>
 * Optimistic locking can be implemented in database side or certain TTL can be
 * configured beyond which payment can be deemed not success. <Br>
 * 
 * After booking successful, notification & ticket will be send by notification service.<BR>
 * 
 * 
 * @author manojpal
 *
 */
@Service
public class BookingService {
	
	@Autowired
	@Qualifier("mailNotificationService")
	private NotifactionService mailNotificationService;
	@Autowired
	@Qualifier("whatsAppNotificationService")
	private NotifactionService messageNotifactionService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private UserService userService;
	@Autowired
	private TheatreService theatreService;
	
	/*
	 * This method will perform below action -  <Br>
	 * 1- Check the requested inventory in theatre table - read seatAvailable column <BR>
	 * 2- Reduce the count by requested number of seat
	 * 3- Make an entry in booking details table with status as Requested.
	 * 3- Talk to payment gateway for payment 
	 * 
	 * After successful payment - <Br>
	 * 1- Notification & ticket will send by notification service  <Br>
	 * 2- Update the booking details table with status Confirmed  <Br>
	 *  
	 * After un-successful payment -  <Br>
	 * 1- Notification will be send to customer
	 * 2- Booking details table will be updated with Cancelled status
	 * 3- Inventory will be increased in movie table
	 * 
	 */
	public void bookSeats(BookingDto bookingDto) {
		//In real time thease each service will be independent microservices and will be consumed here.
	}

}
