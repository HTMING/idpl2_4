package com.idpl.action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.idpl.dao.*;
public class ShowExperimentAction extends BaseAction{
	private List<Experiment> experimentList;
	private int page;
	private int nextPage;
	private int allPage;
	private int frontPage;
	public List<Experiment> getExperimentList(){
		return this.experimentList;
	}
	public void setExperimentList(List<Experiment> experimentList){
		this.experimentList=experimentList;
	}
	public int getPage(){
		return this.page;
	}
	public void setPage(int page){
		this.page=page;
	}
	public int getAllPage(){
		return this.allPage;
	}
	public void setAllPage(int allPage){
		this.allPage=allPage;
	}
	public int getNextPage(){
		return this.nextPage;
	}
	public void setNextPage(int nextPage){
		this.nextPage=nextPage;
	}
	public int getFrontPage(){
		return this.frontPage;
	}
	public void setFrontPage(int frontPage){
		this.frontPage=frontPage;
	}
	public String execute(){
		//System.out.println("11");
		HttpSession session = ServletActionContext.getRequest ().getSession();
		String result="fail";
		//System.out.println("11");
		Experiment recordOfExperiment;
		int RecordNumberInOnePage=10;
		ExperimentDAO experimentDAO=ExperimentDAOFactory.getExperimentDAOInstance();
		String username=(String)session.getAttribute("username");
		//System.out.println("ShowExperiment Action");
		if(username!=null&&!username.equals("manager"))
		{
			//System.out.println("Show Experiment!");
			try {
				if(page==0) page=1;
				List<Experiment> OrignalExperimentList=experimentDAO.queryAll("experiment", username);
				allPage=OrignalExperimentList.size();
				Iterator<Experiment> iter = OrignalExperimentList.iterator();
				for(int i = 1;i < page;i++)
					for(int j = 0;j < RecordNumberInOnePage && iter.hasNext(); j++)
					{
						frontPage=page-1;
						recordOfExperiment = iter.next();
					}
				int i=1;
				experimentList=new ArrayList<Experiment>();
				while(iter.hasNext() && i <= RecordNumberInOnePage){
					recordOfExperiment=iter.next();
					experimentList.add(recordOfExperiment);
					i++;
				}
				if(iter.hasNext()) nextPage=page+1;
				result="success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(username!=null&&username.equals("manager"))
		{
			try {
				List<Experiment> OrignalExperimentList=experimentDAO.queryAll("experiment", username);
				Iterator<Experiment> iter = OrignalExperimentList.iterator();
				experimentList=new ArrayList<Experiment>();
				while(iter.hasNext()){
					recordOfExperiment=iter.next();
					experimentList.add(recordOfExperiment);
				}
				result="manager";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else result="login";
		System.out.println("ShowExperiment:"+result);
		return result;		
	}
}
