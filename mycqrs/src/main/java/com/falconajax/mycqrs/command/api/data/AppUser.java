package com.falconajax.mycqrs.command.api.data;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AppUser {
	private String firstName;
	private String lastName;
	
	@Id
	private String userUniqueId;
}
