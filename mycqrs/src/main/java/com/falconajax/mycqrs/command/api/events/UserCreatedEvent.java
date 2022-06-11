package com.falconajax.mycqrs.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedEvent {
	private String firstName;
	private String lastName;
	
	private String userUniqueId;
}
