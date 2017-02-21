package com.idpl.action;

import javax.servlet.http.*;
import org.apache.struts2.ServletActionContext; 

public class LogoutAction extends BaseAction{
	public String execute(){
		HttpSession session = ServletActionContext.getRequest ().getSession();
		String result="fail";
		String username=(String)session.getAttribute("username");
//		System.out.println(experimentId);
		if(username!=null)
		{
			try {
				session.setAttribute("username", null);
				result="true";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else result="login";
		return result;		
	}
}
