package com.idpl.dao;

public class Record {
	private long recordId;       //实验记录ID
	private String testName;     //实验名称
	private String way;          //数据传输方法
	private String method;       //数据传输方式
	private String protocol;     //数据传输链路协议
	private String dataSource;   //数据源
	private String dataSize;     //数据大小
	private String dataDestination;  //数据目的地
	private String repeat;        //数据传输频率
	private String number;
	private String parallel;
	private String username;
	private int repeatPart;
	private int percentage;
	private int clusterId;       //condor的cluster的ID
	private int jobId;           //condor的job的ID

	private String Time_Start;    //数据设定传输开始时间
	private String Time_End;      //数据设定传输结束时间
	private String Date;          //数据设定时间
	private String startRunning;  //数据实际开始传输时间
	private String completedTime; //数据实际结束传输时间
	private String State;         //数据传输状态
	private long experimentId;
	public long getRecordId(){     //得到实验记录ID
		return this.recordId;
	}
	public int getClusterId(){     //得到cluster的ID
		return this.clusterId;
	}
	public int getJobId(){         //得到作业的ID
		return this.jobId;
	}
	public String getTestName(){   //得到实验名称
		return this.testName;
	}
	public String getWay(){        //得到实验传输方法
		return this.way;
	}
	public String getMethod(){    //得到实验传输方式
		return this.method;
	}
	public String getProtocol(){   //得到实验传输链路协议
		return this.protocol;
	}
	public String getDataSource(){ //得到数据源
		return this.dataSource;
	}
	public String getDataSize(){  //得到数据大小
		return this.dataSize;
	}

	public String getDataDestination(){   //得到数据目的地
		return this.dataDestination;
	}
	public String getRepeat(){        //得到数据传输频率
		return this.repeat;
	}
	public String getNumber(){
		return this.number;
	}
	public String getParallel(){
		return this.parallel;
	}
	public String getUsername(){
		return this.username;
	}
	
	public String getTime_Start(){    //得到数据设定传输开始时间
		return this.Time_Start;
	}
	public String getTime_End(){      //得到数据设定传输结束时间
		return this.Time_End;
	}
	public String getDate(){          //得到数据设定时间
		return this.Date;
	}
	public int getRepeatPart(){
		return this.repeatPart;
	}
	public int getPercentage(){
		return this.percentage;
	}
	public String getStartRunning(){  //得到数据传输实际开始时间
		return this.startRunning;
	}
	public String getCompletedTime(){ //得到数据传输实际结束时间
		return this.completedTime;
	}
	public String getState(){        //得到数据传输作业状态
		return this.State;
	}
	public long getExperimentId(){
		return this.experimentId;
	}

	public void setRecordId(long id){           //设置实验记录ID
		this.recordId=id;
	}
	public void setTestName(String name){    //设置实验名称
		this.testName=name;
	}
	public void setWay(String way){        //设置传输方法
		this.way=way;
	}
	public void setMethod(String method){   //设置传输方式
		this.method=method;
	}
	public void setProtocol(String protocol){    //设置数据传输链路协议
		this.protocol=protocol;
	}
	public void setDataSource(String dataSource){   //设置数据源
		this.dataSource=dataSource;
	}
	public void setDataSize(String dataSize){      //设置数据大小
		this.dataSize=dataSize;
	}
	public void setDataDestination(String dataDestination){   //设置数据目的地
		this.dataDestination=dataDestination;
	}
	public void setRepeat(String repeat){      //设置数据传输频率
		this.repeat=repeat;
	}
	public void setNumber(String number){
		this.number=number;
	}
	public void setParallel(String parallel){
		this.parallel=parallel;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setTime_Start(String time_Start){   //设置数据设定开始时间
		this.Time_Start=time_Start;
	}
	public void setTime_End(String time_End){     //设置数据设定结束时间
		this.Time_End=time_End;
	}
	public void setDate(String date){         //设置数据设定时间
		this.Date=date;
	}
	public void setRepeatPart(int repeatPart){
		this.repeatPart=repeatPart;
	}
	public void setPercentage(int percentage){
		this.percentage=percentage;
	}
	public void setClusterId(int clusterId){   //设置Cluster的ID
		this.clusterId=clusterId;
	}
	public void setJobId(int jobId){          //设置作业的ID
		this.jobId=jobId;
	}
	public void setStartRunning(String startRunning){     //设置数据传输实际开始时间
		this.startRunning=startRunning;
	}
	public void setCompletedTime(String completedTime){   //设置数据传输实际结束时间
		this.completedTime=completedTime;
	}
	public void setState(String state)         //设置数据传输状态
	{
		this.State=state;
	}
	public void setExperimentId(long experimentId){
		this.experimentId=experimentId;
	}
}
