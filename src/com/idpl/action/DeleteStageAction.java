package com.idpl.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.idpl.dao.RecordDAO;
import com.idpl.dao.RecordDAOFactory;

public class DeleteStageAction extends BaseAction{
	private long experimentId;
	private long recordId;
	public long getExperimentId(){
		return this.experimentId;
	}
	public void setExperimentId(long experimentId){
		this.experimentId=experimentId;
	}
	public long getRecordId(){
		return this.recordId;
	}
	public void setRecordId(long recordId){
		this.recordId=recordId;
	}
	public String execute(){
		HttpSession session = ServletActionContext.getRequest ().getSession();
		String result="fail";
		RecordDAO recordDAO=RecordDAOFactory.getRecordDAOInstance();
		String username=(String)session.getAttribute("username");
//		System.out.println(experimentId);
		if(username!=null)
		{
			try {
				recordDAO.delete(recordId, "test", experimentId);
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
