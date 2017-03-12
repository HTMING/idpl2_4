package com.idpl.action;

import com.idpl.dao.Record;
import com.idpl.dao.RecordDAO;
import com.idpl.dao.RecordDAOFactory;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TIJK on 2017/3/6.
 */
public class showDetailAction {
    private long experimentId;
    private String experimentName;
    private Record record;
    private List<Record> recordList = new ArrayList<Record>();;

    public void setRecordList(List<Record> recordList) {this.recordList = recordList;}
    public List<Record> getRecordList() {return  this.recordList;}
    public void setExperimentId(long experimentId){
        this.experimentId = experimentId;
    }
    public long getExperimentId(){
        return this.experimentId;
    }
    public void setExperimentName(String experimentName) {this.experimentName = experimentName;}
    public String getExperimentName() {return this.experimentName;}

    public String execute() {
        HttpSession session = ServletActionContext.getRequest ().getSession();
        String result="fail";
        RecordDAO recordDAO= RecordDAOFactory.getRecordDAOInstance();
        String username=(String)session.getAttribute("username");
        if(username!=null)
        {
            try {
                //	System.out.println(experimentId);
                record=recordDAO.queryById(experimentId,"log_record");
                record.setExperimentName(experimentName);
                recordList.add(record);
                result="success";
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else result="fail";
        return result;
    }
}
