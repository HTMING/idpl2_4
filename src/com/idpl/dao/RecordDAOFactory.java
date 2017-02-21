package com.idpl.dao;

public class RecordDAOFactory {
	public static RecordDAO getRecordDAOInstance(){
		return new RecordDAOImpl();
	}
}
