package com.falconajax.mycqrs.command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.falconajax.mycqrs.command.api.data.AppUser;
import com.falconajax.mycqrs.command.api.data.UserRepository;

@Component
public class UserEventsHandler {
	
	private UserRepository userRepo;
	

	public UserEventsHandler(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}


	@EventHandler
	public void on(UserCreatedEvent event) {
		AppUser user = new AppUser();
		BeanUtils.copyProperties(event, user);
		userRepo.save(user);
	}
}
