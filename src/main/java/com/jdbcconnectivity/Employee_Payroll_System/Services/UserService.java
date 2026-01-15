	package com.jdbcconnectivity.Employee_Payroll_System.Services;
	import com.jdbcconnectivity.Employee_Payroll_System.DAO.*;
	import com.jdbcconnectivity.Employee_Payroll_System.model.*;
	
	
	public class UserService {
	    private UserDAO dao = new UserDAO();
	    public boolean register(User u) { return dao.addUser(u); }
	    public User login(String username, String password) { return dao.login(username, password); }
		public boolean registerUser(User u) {
			// TODO Auto-generated method stub
			return false;
		}
	}