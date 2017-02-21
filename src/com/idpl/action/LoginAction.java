package com.idpl.action;


import com.idpl.dao.*;
import com.idpl.code.*;

import javax.servlet.http.*;
import org.apache.struts2.ServletActionContext; 

public class LoginAction extends BaseAction{
	private String username;
	private String password;
	HttpSession session = ServletActionContext.getRequest ().getSession(); 
	
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void myvalidate(){
		System.out.println("validate");
		this.clearErrorsAndMessages();
	}
	public String execute(){
//		this.myvalidate();
		UserDAO userDAO=UserDAOFactory.getRecordDAOInstance();
		String result="false";
		try {
			password = AES.encrypt(username, password);
			System.out.println(username + '\n' + password);
			result = userDAO.isUser(username, password, "user");
			session.setAttribute("username", username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		System.out.println("login:"+result);*/
		return result;
	}
}
