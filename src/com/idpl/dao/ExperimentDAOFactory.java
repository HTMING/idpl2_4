package com.idpl.dao;

public class ExperimentDAOFactory {
	public static ExperimentDAO getExperimentDAOInstance(){
		return new ExperimentImpl();
	}
}

