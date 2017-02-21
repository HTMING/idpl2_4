package com.idpl.dao;

public class DirectionStatis {
	private String sourceToDestination;
	private int putNumber;
	private int getNumber;
	public void setSourceToDestination(String sourceToDestination){
		this.sourceToDestination = sourceToDestination;
	}
	public String getSourceToDestination(){
		return this.sourceToDestination;
	}
	public void setPutNumber(int putNumber){
		this.putNumber = putNumber;
	}
	public int getPutNumber(){
		return this.putNumber;
	}
	public void setGetNumber(int getNumber){
		this.getNumber = getNumber;
	}
	public int getGetNumber(){
		return this.getNumber;
	}
}
