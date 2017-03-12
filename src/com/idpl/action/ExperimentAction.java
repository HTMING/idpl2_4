package com.idpl.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.*;

import cn.edu.buaa.jsi.portal.SExperiment;
import cn.edu.buaa.jsi.portal.Transfer;
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

	//add by tijk
	private String src_host;
	private String dst_host;
	private String src_path;
    private String dst_path;
    private String testsequence;
    private String cron_hour;
    private String cron_minute;


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



    public String getSrc_host() {return src_host;}
    public String getDst_host() {return dst_host;}
    public String getSrc_path() {return src_path;}
    public String getDst_path() {return dst_path;}
    public String getTestsequence() {return testsequence;}
    public String getCron_hour() {return cron_hour;}
    public String getCron_minute() {return cron_minute;}


	public void setSrc_host(String src_host) {this.src_host=src_host;}
	public void setDst_host(String dst_host) {this.dst_host=dst_host;}
	public void setSrc_path(String src_path) {this.src_path=src_path;}
	public void setDst_path(String dst_path) {this.dst_path=dst_path;}
	public void setCron_hour(String cron_hour) {this.cron_hour=cron_hour;}
	public void setCron_minute(String cron_minute) {this.cron_minute=cron_minute;}
	public void setTestsequence(String testsequence) {this.testsequence=testsequence;}



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
		//long timeStart=0;
		//long timeEnd=0;
		String result="fail";
		String username=(String) session.getAttribute("username");
		
/*
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
*/
		if(username!=null)
		{
			ExperimentDAO experimentDAO=ExperimentDAOFactory.getExperimentDAOInstance();
			Experiment experiment=new Experiment();
			experiment.setExperimentName(experimentName);
			experiment.setSrc_host(src_host);
			experiment.setDst_host(dst_host);
			experiment.setSrc_path(src_path);;
			experiment.setDst_path(dst_path);
			experiment.setCron_hour(cron_hour);
			experiment.setCron_minute(cron_minute);
			experiment.setTestsequence(testsequence);
			//experiment.setTimeStart(timeStart);
			//experiment.setTimeEnd(timeEnd);
//			experiment.setDate(date);
			experiment.setTimeCreate(createUnixtime);
			experiment.setUsername(username);
			//System.out.println("112");
			try {
				
					experimentId=experimentDAO.insert(experiment, "experiment");
				//session.setAttribute("experimentId", ExperimentId);
				result="success";
                System.out.println("113");
			} catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }



/*
			Record record=null;
			int repeat_number=-1;
			int number_number=-1;
			int parallel_number=-1;
			ExperimentDAO experimentDAO1=ExperimentDAOFactory.getExperimentDAOInstance();
			try {
				experiment = experimentDAO1.queryById(experimentId, "experiment", username);
				Transfer transfer = Transfer.getInstance();
				transfer.setUser(username);
				transfer.setId(experimentId);
				transfer.setStarttime(experiment.getTimeStart());
				transfer.setStoptime(experiment.getTimeEnd());

				List<SExperiment> sexpList = new ArrayList<SExperiment>();
				SExperiment sexperiment=null;
				//get Stage List



				List<Record> expList = null;
				RecordDAO recordDAO=RecordDAOFactory.getRecordDAOInstance();
				expList=recordDAO.queryAll("test",username,experimentId);
				Iterator<Record> iter=expList.iterator();
				while(iter.hasNext()){
					record=iter.next();
					repeat_number=Integer.parseInt(record.getRepeat());
					number_number=Integer.parseInt(record.getNumber());
					parallel_number=Integer.parseInt(record.getParallel());
					sexperiment=new SExperiment(record.getRecordId(),record.getDataSource(),record.getDataDestination(),
							record.getMethod(),record.getWay(),record.getProtocol(),record.getDataSize(),number_number,parallel_number,repeat_number);
					System.out.println(record.getRecordId()+record.getDataSource()+record.getDataDestination()+
							record.getMethod()+record.getWay()+record.getProtocol()+record.getDataSize()+repeat_number+number_number+parallel_number);
					sexpList.add(sexperiment);
				}
				transfer.setExpList(sexpList);
				transfer.submit();

				experimentDAO.submit("experiment", experimentId);
				//session.setAttribute("experimentId", ExperimentId);
				result="success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/


            String var = "SRC_HOST=\"" + src_host + "\" SRC_PATH=\"" + src_path + "\" DST_HOST=\"" + dst_host + "\" DST_PATH=\"" + dst_path
                    + "\"  TESTSEQUENCE=\"" + testsequence +"\" TIMEOUT=\"120\" cron_minute=\"20\"  ";
            SExperiment exp = new SExperiment(experimentId, var);
            List<SExperiment> list = new ArrayList<SExperiment>();
            list.add(exp);

            Transfer transfer = Transfer.getInstance();
            transfer.setExpList(list);
            transfer.setUser(username);
            transfer.setId(experimentId);
            transfer.setStarttime(0);
            transfer.setStoptime(0);
            try {
                transfer.submit();
            } catch (Exception e) {
                e.printStackTrace();
            }


		}
		else
			result="login";
		return result;
	}
}
	
