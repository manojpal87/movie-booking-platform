package com.moviebookingplatform.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class holds user information
 * 
 * @author manojpal
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int user_id;

	@Column(name = "name")
	private String name;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "mobile", length = 10)
	private long mobile;

	@Column(name = "email")
	private String email;

}
