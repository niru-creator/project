package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserDetailsService{

	@Autowired
	private userRepository repo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		fetching user from databases
		
		User userByUserName = repo.getUserByUserName(email);
		
		if(userByUserName==null)
		{
			throw new UsernameNotFoundException("could not found user !!");
		}
	CUserDetail detail=	new CUserDetail(userByUserName);
		return detail;
	}

}
