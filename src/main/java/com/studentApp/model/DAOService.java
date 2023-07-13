package com.studentApp.model;

import java.sql.ResultSet;

public interface DAOService {

	public void connectDB();

	public boolean verifyCredential(String email, String password);
	
	public void newRegistration(String name,String city,String email,String mobile);

	public ResultSet listRegistration();

	public void deleteByEmail(String email);

	public void updateRegistration(String email, String mobile);

}
