package com.idpl.action;


import com.idpl.dao.*;
import com.idpl.code.*;

public class RegisterAction extends BaseAction{
	private String usernameRegister;
	private String passwordRegister;
	
	public void setUsernameRegister(String usernameRegister){
		this.usernameRegister=usernameRegister;
	}
	public String getUsernameRegister(){
		return this.usernameRegister;
	}
	public void setPasswordRegister(String passwordRegister){
		this.passwordRegister=passwordRegister;
	}
	public String getPasswordRegister(){
		return this.passwordRegister;
	}
	public String execute(){
		UserDAO userDAO=UserDAOFactory.getRecordDAOInstance();
		String result="false";
		try {
			if(userDAO.hasExisted(usernameRegister, "user").equals("true"))
				return result;
			String password = null;
			User user = new User();
			user.setUsername(usernameRegister);
			password = AES.encrypt(usernameRegister, passwordRegister);
			user.setPassword(password);
			userDAO.insert(user, "user");
			result = "true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
}
