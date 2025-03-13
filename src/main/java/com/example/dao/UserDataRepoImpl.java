package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bean.LoginDto;
import com.example.bean.UsersData;
@Repository
public class UserDataRepoImpl implements UserDataRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String saveUserData(UsersData udata) {
		String res=null;
		try {
			String sql="Insert into USERSDATA(NAME,USERNAME,MAILID,MOBILENO,GENDER,PASSWORD,ROLE) values(?,?,?,?,?,?,?)";
			int update = jdbcTemplate.update(sql, udata.getName(),udata.getUserName(),udata.getMail(),udata.getMobileNo(),udata.getGender(),udata.getPassword(),udata.getRole());
			if(update>0) 
				res=udata.getName()+" Record Inserted sucessfully";
			else
				res="Record not Inserted";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	
	@Override
	public LoginDto findByName(String username) {
		LoginDto u=null;
		try {
			String sql="select USERNAME,PASSWORD,ROLE from USERSDATA where USERNAME=?";
			
			u= jdbcTemplate.queryForObject(sql, new Object[] {username},(rs, rowNum) -> mapUser(rs));
			
		} catch (Exception e) {
			u=null;
		}
		return u;
	}
	
	private LoginDto mapUser(ResultSet rs) throws SQLException {
		LoginDto u=new LoginDto();
		u.setUserName(rs.getString("USERNAME"));
		u.setPassword(rs.getString("PASSWORD"));
		u.setRole(rs.getString("ROLE"));
        return u;
    }

}
