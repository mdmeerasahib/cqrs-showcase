package com.falconajax.mycqrs.command.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestModel {
	
	private String firstName;
	private String lastName;
	private String userUniqueId;

}
