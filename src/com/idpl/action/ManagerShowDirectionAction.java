package com.idpl.action;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.idpl.dao.*;
public class ManagerShowDirectionAction extends BaseAction{
	private List<DirectionStatis> directionStatisList;
	public List<DirectionStatis> getDirectionStatisList(){
		return this.directionStatisList;
	}
	public void setDirectionStatisList(List<DirectionStatis> directionStatisList){
		this.directionStatisList = directionStatisList;
	}
	public String execute(){
		HttpSession session = ServletActionContext.getRequest ().getSession();
		String result="fail";
		RecordDAO recordDAO=RecordDAOFactory.getRecordDAOInstance();
		String username=(String)session.getAttribute("username");	
		if(username!=null)
		{
			try {
				directionStatisList = recordDAO.queryDirection("test");
				result="success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else result="login";
		System.out.println(result);
		return result;		
	}
}