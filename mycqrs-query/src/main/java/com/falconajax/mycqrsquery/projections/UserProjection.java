package com.falconajax.mycqrsquery.projections;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.falconajax.mycqrsquery.data.AppUser;
import com.falconajax.mycqrsquery.data.UserRepository;
import com.falconajax.mycqrsquery.model.UserModel;
import com.falconajax.mycqrsquery.queries.GetUsersQuery;

@Component
public class UserProjection {
	
	private UserRepository userRepo;

	public UserProjection(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	
	@QueryHandler
	public List<UserModel> handle(GetUsersQuery getUsersQuery) {
		
		List<AppUser> users = userRepo.findAll();
		
		List<UserModel> userModels = users.stream().map(x-> { UserModel um = new UserModel(); BeanUtils.copyProperties(x, um ); return um;}).collect(Collectors.toList());
		
		return userModels;
	}
	

}
