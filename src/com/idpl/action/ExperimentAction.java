package com.idpl.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;

import com.idpl.dao.*;
public class ExperimentAction extends BaseAction {
	private String experimentName;
	private long experimentId;
	private String username;
	private String timeStart_date;
	private String timeStart_time;
	private String timeEnd_date;
	private String timeEnd_time;
	private long timeStartUnixtime;
	private long timeEndUnixtime;
	private long createUnixtime;
	private long date;
	private String note;
	public String getExperimentName(){
		return experimentName;
	}
	
	public void setExperimentName(String expName){
		this.experimentName=expName;
	}
	
	public long getExperimentId(){
		return experimentId;
	}
	
	public void setExperimentId(long experimentId){
		this.experimentId=experimentId;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public String getTimeStart_date(){
		return this.timeStart_date;
	}
	public String getTimeStart_time(){
		return this.timeStart_time;
	}
	public String getTimeEnd_date(){
		return this.timeEnd_date;
	}
	public String getTimeEnd_time(){
		return this.timeEnd_time;
	}
	public void setTimeStart_date(String timeStart_date){
		this.timeStart_date=timeStart_date;
	}
	public void setTimeStart_time(String timeStart_time){
		this.timeStart_time=timeStart_time;
	}
	public void setTimeEnd_date(String timeEnd_date){
		this.timeEnd_date=timeEnd_date;
	}
	public void setTimeEnd_time(String timeEnd_time){
		this.timeEnd_time=timeEnd_time;
	}
	public long getTimeStartUnixtime(){
		return this.timeStartUnixtime;
	}
	public void setTimeStartUnixtime(long timeStartUnixtime){
		this.timeStartUnixtime=timeStartUnixtime;
	}
	public long getTimeEndUnixtime(){
		return this.timeEndUnixtime;
	}
	public void setTimeEndUnixtime(long timeEndUnixtime){
		this.timeEndUnixtime=timeEndUnixtime;
	}
	public long getDate(){
		return this.date;
	}
	public void setDate(long date){
		this.date=date;
	}
	public String getNote(){
		return this.note;
	}
	public void setNote(String note){
		this.note=note;
	}
	public long getCreateUnixtime(){
		return this.createUnixtime;
	}
	public void setCreateUnixtime(long createUnixtime){
		this.createUnixtime=createUnixtime;
	}
	public String execute(){
		HttpSession session = ServletActionContext.getRequest ().getSession();
//		String Date;
		long timeStart=0;
		long timeEnd=0;
		String result="fail";
		String username=(String) session.getAttribute("username");
		

		if(!timeStart_date.equals("")&&!timeStart_time.equals(""))
		{
			timeStart=timeStartUnixtime;
			if(createUnixtime>timeStartUnixtime)
			{
				
				note=" Submit Time Error!";
				return result;
			}
		}
		
		if(!timeEnd_date.equals("")&&!timeEnd_time.equals(""))
		{
			timeEnd=timeEndUnixtime;
			if(createUnixtime>timeEndUnixtime)
			{
				note=" End Time Error!";
				return result;
			}
		}
		
		if(!timeStart_date.equals("")&&!timeStart_time.equals("")&&!timeEnd_date.equals("")&&!timeEnd_time.equals(""))
		{
			if(timeStart>timeEnd||timeStart==timeEnd)
			{
				note="Set Time Error!";
				return result;
			}
		}
		
		if(username!=null)
		{
			ExperimentDAO experimentDAO=ExperimentDAOFactory.getExperimentDAOInstance();
			Experiment experiment=new Experiment();
			experiment.setExperimentName(experimentName);
			experiment.setTimeStart(timeStart);
			experiment.setTimeEnd(timeEnd);
//			experiment.setDate(date);
			experiment.setTimeCreate(createUnixtime);
			experiment.setUsername(username);
			try {
				
				experimentId=experimentDAO.insert(experiment, "experiment");
				//session.setAttribute("experimentId", ExperimentId);
				result="success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			result="login";
		return result;
	}
}
	
