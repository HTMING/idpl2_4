package com.idpl.dao;

import sun.security.pkcs11.P11Util;

public class Record {
	private long recordId;       //ʵ���¼ID
	private String testName;     //ʵ������
	private String way;          //���ݴ��䷽��
	private String method;       //���ݴ��䷽ʽ
	private String protocol;     //���ݴ�����·Э��
	private String dataSource;   //����Դ
	private String dataSize;     //���ݴ�С
	private String dataDestination;  //����Ŀ�ĵ�
	private String repeat;        //���ݴ���Ƶ��
	private String number;
	private String parallel;
	private String username;
	private int repeatPart;
	private int percentage;
	private int clusterId;       //condor��cluster��ID
	private int jobId;           //condor��job��ID


	//by TIJK
    private String experimentName;
	private long exp_Id;
	private String file_name;
	private String src_host;
	private String dst_host;
	private String time_start;
	private String time_end;
	private int md5;
	private double duration;
	private long data_size;
    private double bandwidth;
    private String tool;




	private String Time_Start;    //�����趨���俪ʼʱ��
	private String Time_End;      //�����趨�������ʱ��
	private String Date;          //�����趨ʱ��
	private String startRunning;  //����ʵ�ʿ�ʼ����ʱ��
	private String completedTime; //����ʵ�ʽ�������ʱ��
	private String State;         //���ݴ���״̬
    private long experimentId;


    public String getExperimentName() {return this.experimentName;}
    public long getExp_Id() {return this.exp_Id;}
    public String getFile_name() {return this.file_name;}
    public String getSrc_host() {return this.src_host;}
    public String getDst_host() {return this.dst_host;}
    public String getTime_start() {return this.Time_Start;}
    public String getTime_end() {return this.Time_End;}
    public int getMd5() {return this.md5;}
    public double getDuration() {return this.duration;}
    public long getData_size() {return this.data_size;}
    public double getBandwidth() {return this.bandwidth;}
    public String getTool() {return this.tool;}

    public void setExperimentName(String experimentName) {this.experimentName = experimentName;}
    public void setExp_Id(long exp_Id) {this.exp_Id = exp_Id;}
    public void setFile_name(String file_name) {this.file_name = file_name;}
    public void setSrc_host(String src_host) {this.src_host = src_host;}
    public void setDst_host(String dst_host) {this.dst_host = dst_host;}
    public void setTime_start(String time_start) {this.time_start = time_start;}
    public void setTime_end(String time_end) {this.time_end = time_end;}
    public void setMd5(int md5) {this.md5 = md5;}
    public void setDuration(double duration) {this.duration = duration;}
    public void setData_size(long data_size) {this.data_size = data_size;}
    public void setBandwidth(double bandwidth) {this.bandwidth = bandwidth;}
    public void setTool(String tool) {this.tool = tool;}




    public long getRecordId(){     //�õ�ʵ���¼ID
		return this.recordId;
	}
	public int getClusterId(){     //�õ�cluster��ID
		return this.clusterId;
	}
	public int getJobId(){         //�õ���ҵ��ID
		return this.jobId;
	}
	public String getTestName(){   //�õ�ʵ������
		return this.testName;
	}
	public String getWay(){        //�õ�ʵ�鴫�䷽��
		return this.way;
	}
	public String getMethod(){    //�õ�ʵ�鴫�䷽ʽ
		return this.method;
	}
	public String getProtocol(){   //�õ�ʵ�鴫����·Э��
		return this.protocol;
	}
	public String getDataSource(){ //�õ�����Դ
		return this.dataSource;
	}
	public String getDataSize(){  //�õ����ݴ�С
		return this.dataSize;
	}

	public String getDataDestination(){   //�õ�����Ŀ�ĵ�
		return this.dataDestination;
	}
	public String getRepeat(){        //�õ����ݴ���Ƶ��
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
	
	public String getTime_Start(){    //�õ������趨���俪ʼʱ��
		return this.Time_Start;
	}
	public String getTime_End(){      //�õ������趨�������ʱ��
		return this.Time_End;
	}
	public String getDate(){          //�õ������趨ʱ��
		return this.Date;
	}
	public int getRepeatPart(){
		return this.repeatPart;
	}
	public int getPercentage(){
		return this.percentage;
	}
	public String getStartRunning(){  //�õ����ݴ���ʵ�ʿ�ʼʱ��
		return this.startRunning;
	}
	public String getCompletedTime(){ //�õ����ݴ���ʵ�ʽ���ʱ��
		return this.completedTime;
	}
	public String getState(){        //�õ����ݴ�����ҵ״̬
		return this.State;
	}
	public long getExperimentId(){
		return this.experimentId;
	}

	public void setRecordId(long id){           //����ʵ���¼ID
		this.recordId=id;
	}
	public void setTestName(String name){    //����ʵ������
		this.testName=name;
	}
	public void setWay(String way){        //���ô��䷽��
		this.way=way;
	}
	public void setMethod(String method){   //���ô��䷽ʽ
		this.method=method;
	}
	public void setProtocol(String protocol){    //�������ݴ�����·Э��
		this.protocol=protocol;
	}
	public void setDataSource(String dataSource){   //��������Դ
		this.dataSource=dataSource;
	}
	public void setDataSize(String dataSize){      //�������ݴ�С
		this.dataSize=dataSize;
	}
	public void setDataDestination(String dataDestination){   //��������Ŀ�ĵ�
		this.dataDestination=dataDestination;
	}
	public void setRepeat(String repeat){      //�������ݴ���Ƶ��
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
	public void setTime_Start(String time_Start){   //���������趨��ʼʱ��
		this.Time_Start=time_Start;
	}
	public void setTime_End(String time_End){     //���������趨����ʱ��
		this.Time_End=time_End;
	}
	public void setDate(String date){         //���������趨ʱ��
		this.Date=date;
	}
	public void setRepeatPart(int repeatPart){
		this.repeatPart=repeatPart;
	}
	public void setPercentage(int percentage){
		this.percentage=percentage;
	}
	public void setClusterId(int clusterId){   //����Cluster��ID
		this.clusterId=clusterId;
	}
	public void setJobId(int jobId){          //������ҵ��ID
		this.jobId=jobId;
	}
	public void setStartRunning(String startRunning){     //�������ݴ���ʵ�ʿ�ʼʱ��
		this.startRunning=startRunning;
	}
	public void setCompletedTime(String completedTime){   //�������ݴ���ʵ�ʽ���ʱ��
		this.completedTime=completedTime;
	}
	public void setState(String state)         //�������ݴ���״̬
	{
		this.State=state;
	}
	public void setExperimentId(long experimentId){
		this.experimentId=experimentId;
	}
}
