package codetest.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import Model.UserBean;



@Repository
public class UserRepo {
	public boolean checkEmail(String email) {
		boolean result=false;
		Connection cn=LinkConnection.linkConnection();
		String query="SELECT * FROM codetest.user WHERE email=?;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				result=true;
			}
		} catch (SQLException e) {
			System.out.println("Checking email error "+e.getMessage());
		}
		return result;
	}
	
	public UserBean checkPassword(String email,String password) {
		UserBean bean=null;
		Connection cn=LinkConnection.linkConnection();
		String query="SELECT * FROM codetest.user WHERE email=? AND password=?;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bean=new UserBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setRole(rs.getString(5));
			}
		} catch (SQLException e) {
			System.out.println("Checking Password Error "+e.getMessage());
		}
		return bean;
	}
}
