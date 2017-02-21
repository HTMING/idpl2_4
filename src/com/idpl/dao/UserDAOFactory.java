package com.idpl.dao;

public class UserDAOFactory {
	public static UserDAO getRecordDAOInstance(){
		return new UserDAOImpl();
	}
}
