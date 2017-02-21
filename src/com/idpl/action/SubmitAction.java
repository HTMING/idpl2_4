package com.idpl.action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.buaa.jsi.portal.*;

import com.idpl.dao.*;


public class SubmitAction extends BaseAction{
	private long experimentId;
	private Experiment experiment;
	public long getExperimentId(){
		return experimentId;
	}
	public void setExperimentId(long experimentId){
		this.experimentId=experimentId;
	}
	public String execute(){
		HttpSession session = ServletActionContext.getRequest ().getSession();
		String result="fail";
		
		String username=(String) session.getAttribute("username");
//		System.out.println(experimentId);
		if(username!=null)
		{
			Record record=null;
			int repeat_number=-1;
			int number_number=-1;
			int parallel_number=-1;
			ExperimentDAO experimentDAO=ExperimentDAOFactory.getExperimentDAOInstance();
			try {
				experiment = experimentDAO.queryById(experimentId, "experiment", username);
				Transfer transfer = Transfer.getInstance();
				transfer.setUser(username);
				transfer.setId(experimentId);
				transfer.setStarttime(experiment.getTimeStart());
				transfer.setStoptime(experiment.getTimeEnd());
				
				List<SExperiment> sexpList = new ArrayList<SExperiment>();
				SExperiment sexperiment=null;
				/* get Stage List*/
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
		}
		else result="login";
		return result;
	}
}
