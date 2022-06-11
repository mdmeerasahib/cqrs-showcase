package com.falconajax.mycqrs.command.api.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserCommand {
	
	private String firstName;
	private String lastName;
	
	@TargetAggregateIdentifier
	private String userUniqueId;

}
