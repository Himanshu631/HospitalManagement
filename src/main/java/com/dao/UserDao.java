package com.dao;

import java.sql.*;

import com.entity.User;

public class UserDao {
	
	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean register(User u) {
		boolean f = false;
		try {
			
			String q = "insert into user_details(uname,email,password) values(?,?,?)";
			
			
			PreparedStatement ps = conn.prepareStatement(q);
			ps.setString(1,u.getName());
			ps.setString(2,u.getEmail());
			ps.setString(3,u.getPassword());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}
	
	
}
