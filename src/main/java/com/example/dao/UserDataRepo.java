package com.example.dao;

import com.example.bean.LoginDto;
import com.example.bean.UsersData;

public interface UserDataRepo {
	
	public String saveUserData(UsersData udata);
	public LoginDto findByName(String userName);

}
