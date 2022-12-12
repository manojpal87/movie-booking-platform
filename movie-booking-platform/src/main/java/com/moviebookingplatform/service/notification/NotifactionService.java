package com.moviebookingplatform.service.notification;

/**
 * 
 * This interface represents high level contract for notification service.
 * 
 * @author manojpal
 *
 */
public interface NotifactionService {

	void notify(String paylaod, String reciepient);

}
