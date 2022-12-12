package com.moviebookingplatform.configuration;

import java.time.LocalDate;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.moviebookingplatform.entity.City;
import com.moviebookingplatform.entity.User;
import com.moviebookingplatform.repository.CityRepository;
import com.moviebookingplatform.repository.UserRepository;
import com.moviebookingplatform.util.Country;

/**
 * 
 * Basic initial data configuration. <Br>
 * This can be done through script file as well.
 * 
 * @author manojpal
 *
 */
@Configuration
public class BasicDataConfiguration {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private UserRepository userRepository;

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			//city data
			cityRepository.save(
					City.builder().name("Pune").country(Country.INDIA).postalCode(400001).state("Maharashtre").build());

			cityRepository.save(City.builder().name("Mumbai").country(Country.INDIA).postalCode(400003)
					.state("Maharashtre").build());

			cityRepository.save(
					City.builder().name("Beijing").country(Country.CHINA).postalCode(100001).state("Beijing").build());

			cityRepository.save(City.builder().name("Shanghai").country(Country.CHINA).postalCode(100002)
					.state("Shanghai").build());
			
			//user data
			userRepository.save(User.builder().name("Tom").email("abc@google.com").mobile(1981111111).dateOfBirth(LocalDate.of(1990, 2, 21)).build());
		};
	}

}
