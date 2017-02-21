package com.idpl.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.idpl.dao.ExperimentDAO;
import com.idpl.dao.ExperimentDAOFactory;

public class DeleteExperimentAction extends BaseAction{
	private long experimentId;
	public long getExperimentId(){
		return this.experimentId;
	}
	public void setExperimentId(long experimentId){
		this.experimentId=experimentId;
	}
	public String execute(){
		HttpSession session = ServletActionContext.getRequest ().getSession();
		String result="fail";
		ExperimentDAO experimentDAO=ExperimentDAOFactory.getExperimentDAOInstance();
		String username=(String)session.getAttribute("username");
//		System.out.println(experimentId);
		if(username!=null)
		{
			try {
				experimentDAO.delete(experimentId, "experiment");
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
