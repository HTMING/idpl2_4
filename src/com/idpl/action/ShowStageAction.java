package com.idpl.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.idpl.dao.Record;
import com.idpl.dao.RecordDAO;
import com.idpl.dao.RecordDAOFactory;


public class ShowStageAction extends BaseAction{
	private long experimentId;
	private List<Record> stageList;
	public void setExperimentId(long experimentId){
		this.experimentId=experimentId;
	}
	public long getExperimentId(){
		return this.experimentId;
	}
	public void setStageList(List<Record> stageList){
		this.stageList=stageList;
	}
	public List<Record> getStageList(){
		return this.stageList;
	}
	public String execute(){
		HttpSession session = ServletActionContext.getRequest ().getSession();
		String result="fail";
		RecordDAO recordDAO=RecordDAOFactory.getRecordDAOInstance();
		String username=(String)session.getAttribute("username");
		if(username!=null&&!username.equals("manager"))
		{
			try {
//				System.out.println(experimentId);
				stageList=recordDAO.queryAll("test",username,experimentId);
//				System.out.println(stageList.size());
//				System.out.println("ShowStageAction Doing");
				result="success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(username!=null&&username.equals("manager"))
		{
			System.out.print("Manager is Doing!");
			try {
//				System.out.println(experimentId);
				stageList=recordDAO.queryAll("test",username,experimentId);
//				System.out.println(stageList.size());
//				System.out.println("ShowStageAction Doing");
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
