package com.falconajax.mycqrs.command.api.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.falconajax.mycqrs.command.api.commands.CreateUserCommand;
import com.falconajax.mycqrs.command.api.events.UserCreatedEvent;

import lombok.Data;

@Aggregate
@Data
public class UserAggregate {
	private String firstName;
	private String lastName;
	
	@AggregateIdentifier
	private String userUniqueId;

	public UserAggregate() {

	}

	@CommandHandler
	public UserAggregate(CreateUserCommand createUserCommand) {
		UserCreatedEvent event = new UserCreatedEvent();
		
		BeanUtils.copyProperties(createUserCommand, event);
		AggregateLifecycle.apply(event);
	}

	@EventSourcingHandler
	public void on(UserCreatedEvent event) {
		BeanUtils.copyProperties(event, this);
	}
	
}
