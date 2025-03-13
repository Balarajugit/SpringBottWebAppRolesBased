package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bean.LoginDto;
import com.example.bean.Student;
@Repository
public class StudentRepoImpl implements StudentRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String saveStudent(Student s) {
		String res=null;
		try {
			String sql="Insert into STUDENT(NAME,MAILID,BRANCH,BIRTHDATE,GENDER) values(?,?,?,?,?)";
			int update = jdbcTemplate.update(sql, s.getName(),s.getMailId(),s.getBranch(),s.getDateOfBirth(),s.getGender());
			if(update>0) 
				res=s.getName()+" Student Record Inserted sucessfully";
			else
				res="Record not Inserted";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	
	@Override
	public List<Student> getAll() {
		List<Student> l=new ArrayList();
		
		try {
			
			String sql="select ID,NAME,MAILID,BRANCH,BIRTHDATE,GENDER from STUDENT";
			List<Map<String, Object>> li = jdbcTemplate.queryForList(sql);
			for(Map row : li) {
				Student s=new Student();
				s.setId((int) row.get("ID"));
				s.setName(row.get("NAME").toString());
				s.setMailId(row.get("MAILID").toString());
				s.setBranch(row.get("BRANCH").toString());
				s.setDateOfBirth(row.get("BIRTHDATE").toString());
				s.setGender(row.get("GENDER").toString());
				l.add(s);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return l;
	}
	
	
	@Override
	public Student getById(int id) {
		Student u=null;
		try {
			String sql="select ID,NAME,MAILID,BRANCH,BIRTHDATE,GENDER from STUDENT where ID=?";
			
			u= jdbcTemplate.queryForObject(sql, new Object[] {id},(rs, rowNum) -> mapStudent(rs));
			
		} catch (Exception e) {
			u=null;
		}
		return u;
	}
	
	private Student mapStudent(ResultSet rs) throws SQLException {
		Student u=new Student();
		u.setId(rs.getInt("ID"));
		u.setName(rs.getString("NAME"));
		u.setMailId(rs.getString("MAILID"));
		u.setBranch(rs.getString("BRANCH"));
		u.setDateOfBirth(rs.getString("BIRTHDATE"));
		u.setGender(rs.getString("GENDER"));
        return u;
    }
	
	
	@Override
	public String deleteById(int id) {
		String res=null;
		try {
			String sql="Delete From STUDENT where id=?";
			int update = jdbcTemplate.update(sql,id);
			if(update>0) 
				res=id +" Student Record Inserted sucessfully";
			else
				res="Record not Inserted";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

}
