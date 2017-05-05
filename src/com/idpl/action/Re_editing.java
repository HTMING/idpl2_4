package com.idpl.action;

/**
 * Created by TIJK on 2017/5/4.
 */
import com.idpl.dao.*;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class Re_editing extends BaseAction{
    private long experimentId;
    private Experiment experiment;
    public void setExperimentId(long experimentId){
        this.experimentId=experimentId;
    }
    public long getExperimentId(){
        return this.experimentId;
    }
    public void setExperiment(Experiment experiment) {this.experiment=experiment;}
    public Experiment getExperiment() {return this.experiment;}
    public String execute() {
        HttpSession session = ServletActionContext.getRequest ().getSession();
        String result="fail";
        ExperimentDAO experimentDAO= ExperimentDAOFactory.getExperimentDAOInstance();
        String username=(String)session.getAttribute("username");
        if (username != null) {
            try {
                experiment = experimentDAO.queryById_exp(experimentId, "experiment");
                result = "success";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
            result = "login";
        return result;
    }
}
