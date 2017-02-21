package com.idpl.action;

import com.idpl.dao.*;

public class CheckUsernameAction extends BaseAction{
	private String usernameRegister;
	private String result;
	public void setUsernameRegister(String usernameRegister){
		this.usernameRegister=usernameRegister;
	}
	public String getUsernameRegister(){
		return this.usernameRegister;
	}
	public void setResult(String result){
		this.result=result;
	}
	public String getResult(){
		return this.result;
	}
	
	public String execute(){
		UserDAO userDAO=UserDAOFactory.getRecordDAOInstance();
		String result="false";
		try {
			System.out.println(usernameRegister);
			result = userDAO.hasExisted(usernameRegister, "user");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
