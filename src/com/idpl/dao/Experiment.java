package com.idpl.dao;

public class Experiment {
	private long experimentId;
	private String experimentName;
	private String username;
	private long timeStart;    //开始时间
	private long timeEnd;      //结束时间
	private long timeCreate;  //创建时间
	private long date;          //数据设定时间
	private String startRunning;  //数据实际开始传输时间
	private String completedTime; //数据实际结束传输时间
	private String state;         //数据传输状态
	private String submit;
	private int stageNumber;
	private int completeNumber;
	private int allNumber;
	private int percentage;
	public long getExperimentId(){
		return this.experimentId;
	}
	public void setExperimentId(long experimentId)
	{
		this.experimentId=experimentId;
	}
	public String getExperimentName(){
		return this.experimentName;
	}
	public void setExperimentName(String experimentName){
		this.experimentName=experimentName;
	}
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public long getTimeStart(){    //得到数据设定传输开始时间
		return this.timeStart;
	}
	public long getTimeEnd(){      //得到数据设定传输结束时间
		return this.timeEnd;
	}
	public long getTimeCreate(){
		return this.timeCreate;
	}
	public long getDate(){          //得到数据设定时间
		return this.date;
	}
	public String getStartRunning(){  //得到数据传输实际开始时间
		return this.startRunning;
	}
	public String getCompletedTime(){ //得到数据传输实际结束时间
		return this.completedTime;
	}
	public String getState(){        //得到数据传输作业状态
		return this.state;
	}
	public String getSubmit(){
		return this.submit;
	}
	public int getStageNumber(){
		return this.stageNumber;
	}
	public int getCompleteNumber(){
		return this.completeNumber;
	}
	public int getAllNumber(){
		return this.allNumber;
	}
	public int getPercentage(){
		return this.percentage;
	}
	public void setTimeStart(long timeStart){   //设置数据设定开始时间
		this.timeStart=timeStart;
	}
	public void setTimeEnd(long timeEnd){     //设置数据设定结束时间
		this.timeEnd=timeEnd;
	}
	public void setTimeCreate(long timeCreate){
		this.timeCreate=timeCreate;
	}
	public void setDate(long date){         //设置数据设定时间
		this.date=date;
	}
	public void setStartRunning(String startRunning){     //设置数据传输实际开始时间
		this.startRunning=startRunning;
	}
	public void setCompletedTime(String completedTime){   //设置数据传输实际结束时间
		this.completedTime=completedTime;
	}
	public void setState(String state){         //设置数据传输状态
		this.state=state;
	}
	public void setSubmit(String submit){
		this.submit=submit;
	}
	public void setStageNumber(int stageNumber){
		this.stageNumber=stageNumber;
	}
	public void setCompleteNumber(int completeNumber){
		this.completeNumber=completeNumber;
	}
	public void setAllNumber(int allNumber){
		this.allNumber=allNumber;
	}
	public void setPercentage(int percentage){
		this.percentage=percentage;
	}
}