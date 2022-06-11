package com.falconajax.mycqrsquery.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falconajax.mycqrsquery.model.UserModel;
import com.falconajax.mycqrsquery.queries.GetUsersQuery;

@RestController
@RequestMapping("/users")
public class UserQueryController {

	private QueryGateway queryGateway;

	public UserQueryController(QueryGateway queryGateway) {
		super();
		this.queryGateway = queryGateway;
	}

	@GetMapping
	public List<UserModel> getUser() {

		GetUsersQuery getUsersQuery = new GetUsersQuery();

		return queryGateway
				.query(getUsersQuery, ResponseTypes.multipleInstancesOf(UserModel.class)).join();
	}

}
