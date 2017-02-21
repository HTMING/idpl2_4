package com.idpl.action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.idpl.dao.*;
public class ManagerShowExperimentAction extends BaseAction{
	private List<Experiment> experimentList;
	public List<Experiment> getExperimentList(){
		return this.experimentList;
	}
	public void setExperimentList(List<Experiment> experimentList){
		this.experimentList=experimentList;
	}
	public String execute(){
		HttpSession session = ServletActionContext.getRequest ().getSession();
		String result="fail";
		Experiment recordOfExperiment;
		ExperimentDAO experimentDAO=ExperimentDAOFactory.getExperimentDAOInstance();
		String username=(String)session.getAttribute("username");
		System.out.println("ShowExperiment Action");		
		if(username!=null)
		{
			try {
				List<Experiment> OrignalExperimentList=experimentDAO.queryAll("experiment", username);
				Iterator<Experiment> iter = OrignalExperimentList.iterator();
				experimentList=new ArrayList<Experiment>();
				while(iter.hasNext()){
					recordOfExperiment=iter.next();
					experimentList.add(recordOfExperiment);
				}
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
