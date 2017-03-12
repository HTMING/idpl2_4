package com.idpl.dao;

public class Experiment {
	private long experimentId;
	private String experimentName;
	private String username;
	private long timeStart;    //��ʼʱ��
	private long timeEnd;      //����ʱ��
	private long timeCreate;  //����ʱ��
	private long date;          //�����趨ʱ��
	private String startRunning;  //����ʵ�ʿ�ʼ����ʱ��
	private String completedTime; //����ʵ�ʽ�������ʱ��
	private String state;         //���ݴ���״̬
	private String submit;
	private int stageNumber;
	private int completeNumber;
	private int allNumber;
	private int percentage;

	//add by tijk
	private String src_host;
	private String dst_host;
	private String src_path;
	private String dst_path;
	private String cron_hour;
	private String cron_minute;
	private String testsequence;


	public void setSrc_host(String src_host) {this.src_host=src_host;}
	public void setDst_host(String dst_host) {this.dst_host=dst_host;}
	public void setSrc_path(String src_path) {this.src_path=src_path;}
	public void setDst_path(String dst_path) {this.dst_path=dst_path;}
	public void setCron_hour(String cron_hour) {this.cron_hour=cron_hour;}
	public void setCron_minute(String cron_minute) {this.cron_minute=cron_minute;}
	public void setTestsequence(String testsequence) {this.testsequence=testsequence;}

	public String getSrc_host() {return this.src_host;}
	public String getDst_host() {return this.dst_host;}
	public String getSrc_path() {return this.src_path;}
	public String getDst_path() {return this.dst_path;}
	public String getCron_hour() {return this.cron_hour;}
	public String getCron_minute() {return this.cron_minute;}
	public String getTestsequence() {return this.testsequence;}


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
	public long getTimeStart(){    //�õ������趨���俪ʼʱ��
		return this.timeStart;
	}
	public long getTimeEnd(){      //�õ������趨�������ʱ��
		return this.timeEnd;
	}
	public long getTimeCreate(){
		return this.timeCreate;
	}
	public long getDate(){          //�õ������趨ʱ��
		return this.date;
	}
	public String getStartRunning(){  //�õ����ݴ���ʵ�ʿ�ʼʱ��
		return this.startRunning;
	}
	public String getCompletedTime(){ //�õ����ݴ���ʵ�ʽ���ʱ��
		return this.completedTime;
	}
	public String getState(){        //�õ����ݴ�����ҵ״̬
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
	public void setTimeStart(long timeStart){   //���������趨��ʼʱ��
		this.timeStart=timeStart;
	}
	public void setTimeEnd(long timeEnd){     //���������趨����ʱ��
		this.timeEnd=timeEnd;
	}
	public void setTimeCreate(long timeCreate){
		this.timeCreate=timeCreate;
	}
	public void setDate(long date){         //���������趨ʱ��
		this.date=date;
	}
	public void setStartRunning(String startRunning){     //�������ݴ���ʵ�ʿ�ʼʱ��
		this.startRunning=startRunning;
	}
	public void setCompletedTime(String completedTime){   //�������ݴ���ʵ�ʽ���ʱ��
		this.completedTime=completedTime;
	}
	public void setState(String state){         //�������ݴ���״̬
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