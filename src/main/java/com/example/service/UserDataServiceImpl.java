package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.bean.LoginDto;
import com.example.bean.UsersData;
import com.example.dao.UserDataRepo;


@Service
public class UserDataServiceImpl implements UserDataService {
	
	@Autowired
	private UserDataRepo udrepo;
	
	@Override
	public String saveUserData(UsersData udata) {
		// TODO Auto-generated method stub
		return udrepo.saveUserData(udata);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginDto loginDto = udrepo.findByName(username);
		if(loginDto==null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return User.withUsername(loginDto.getUserName()).password(loginDto.getPassword()).authorities("ROLE_"+loginDto.getRole().toUpperCase()).build();
	}

}
