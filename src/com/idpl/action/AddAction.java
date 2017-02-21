package com.idpl.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class AddAction extends BaseAction{
	private long experimentId;
	public void setExperimentId(long experimentId){
		this.experimentId=experimentId;
	}
	public long getExperimentId(){
		return this.experimentId;
	}
	public String execute(){
		HttpSession session = ServletActionContext.getRequest ().getSession();
		String username=(String) session.getAttribute("username");
		//System.out.println(experimentId);
		if(username==null) return "login";
		return "success";
	}
}
