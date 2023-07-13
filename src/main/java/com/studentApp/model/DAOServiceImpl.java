package com.studentApp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {

	private Connection con;
	private Statement stmnt;

	@Override
	public void connectDB() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentregistration", "root", "test");
			stmnt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean verifyCredential(String email, String password) {
		
		try {
			ResultSet result = stmnt.executeQuery("Select * from login Where email='"+email+"'and password='"+password+"'");
			return result.next();
			
		} catch (Exception e) {
		}
		
		return false;
	}

	@Override
	public void newRegistration(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("Insert into registration Values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			
		} catch (Exception e) {
		}
		
	}

	@Override
	public ResultSet listRegistration() {
		try {
			ResultSet result = stmnt.executeQuery("Select * from registration");
			return result;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void deleteByEmail(String email) {
		try {
			stmnt.executeUpdate("Delete from registration Where email='"+email+"'");
			
		} catch (Exception e) {
		}		
	}

	@Override
	public void updateRegistration(String email, String mobile) {
		try {
			stmnt.executeUpdate("Update registration set mobile='"+mobile+"' Where email='"+email+"'");
			
		} catch (Exception e) {
		}
		
	}

}
