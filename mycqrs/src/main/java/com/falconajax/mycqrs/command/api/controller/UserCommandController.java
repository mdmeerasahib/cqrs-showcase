package com.falconajax.mycqrs.command.api.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falconajax.mycqrs.command.api.commands.CreateUserCommand;
import com.falconajax.mycqrs.command.api.model.UserRequestModel;

@RestController
@RequestMapping("/users")
public class UserCommandController {
	
	private CommandGateway commandGateway;
	
	public UserCommandController(CommandGateway commandGateway) {
		super();
		this.commandGateway = commandGateway;
	}

	@PostMapping
	public String addUser(@RequestBody UserRequestModel usrReqModel) {
		CreateUserCommand createUserCommand = CreateUserCommand.builder()
				.firstName(usrReqModel.getFirstName())
				.lastName(usrReqModel.getLastName())
				.userUniqueId(UUID.randomUUID().toString())
				.build();
		
		return commandGateway.sendAndWait(createUserCommand);
	}

}
