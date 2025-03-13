package com.example.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.bean.UsersData;

public interface UserDataService extends UserDetailsService{
	
	public String saveUserData(UsersData udata);

}
