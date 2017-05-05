package com.idpl.action;

import cn.edu.buaa.jsi.portal.SExperiment;
import cn.edu.buaa.jsi.portal.Transfer;
import com.idpl.dao.Experiment;
import com.idpl.dao.ExperimentDAO;
import com.idpl.dao.ExperimentDAOFactory;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TIJK on 2017/5/4.
 */
public class UpdateExperiment {
    private String experimentName;
    private long experimentId;
    private String username;
    private String timeStart_date;
    private String timeStart_time;
    private String timeEnd_date;
    private String timeEnd_time;

    //add by tijk
    private String src_host;
    private String dst_host;
    private String src_path;
    private String dst_path;
    private String[] testsequence;
    private String testsequence1;
    private String cron_hour;
    private String cron_minute;


    private long timeStartUnixtime;
    private long timeEndUnixtime;
    private long createUnixtime;
    private long date;
    private String note;
    public String getExperimentName(){
        return experimentName;
    }

    public void setExperimentName(String expName){
        this.experimentName=expName;
    }

    public long getExperimentId(){
        return experimentId;
    }

    public void setExperimentId(long experimentId){
        this.experimentId=experimentId;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getTimeStart_date(){
        return this.timeStart_date;
    }
    public String getTimeStart_time(){
        return this.timeStart_time;
    }
    public String getTimeEnd_date(){
        return this.timeEnd_date;
    }
    public String getTimeEnd_time(){
        return this.timeEnd_time;
    }
    public void setTimeStart_date(String timeStart_date){
        this.timeStart_date=timeStart_date;
    }
    public void setTimeStart_time(String timeStart_time){
        this.timeStart_time=timeStart_time;
    }
    public void setTimeEnd_date(String timeEnd_date){
        this.timeEnd_date=timeEnd_date;
    }
    public void setTimeEnd_time(String timeEnd_time){
        this.timeEnd_time=timeEnd_time;
    }



    public String getSrc_host() {return src_host;}
    public String getDst_host() {return dst_host;}
    public String getSrc_path() {return src_path;}
    public String getDst_path() {return dst_path;}
    public String[] getTestsequence() {return testsequence;}
    public String getCron_hour() {return cron_hour;}
    public String getCron_minute() {return cron_minute;}


    public void setSrc_host(String src_host) {this.src_host=src_host;}
    public void setDst_host(String dst_host) {this.dst_host=dst_host;}
    public void setSrc_path(String src_path) {this.src_path=src_path;}
    public void setDst_path(String dst_path) {this.dst_path=dst_path;}
    public void setCron_hour(String cron_hour) {this.cron_hour=cron_hour;}
    public void setCron_minute(String cron_minute) {this.cron_minute=cron_minute;}
    public void setTestsequence(String[] testsequence) {this.testsequence=testsequence;}



    public long getTimeStartUnixtime(){
        return this.timeStartUnixtime;
    }
    public void setTimeStartUnixtime(long timeStartUnixtime){
        this.timeStartUnixtime=timeStartUnixtime;
    }
    public long getTimeEndUnixtime(){
        return this.timeEndUnixtime;
    }
    public void setTimeEndUnixtime(long timeEndUnixtime){
        this.timeEndUnixtime=timeEndUnixtime;
    }
    public long getDate(){
        return this.date;
    }
    public void setDate(long date){
        this.date=date;
    }
    public String getNote(){
        return this.note;
    }
    public void setNote(String note){
        this.note=note;
    }
    public long getCreateUnixtime(){
        return this.createUnixtime;
    }
    public void setCreateUnixtime(long createUnixtime){
        this.createUnixtime=createUnixtime;
    }

    public String execute() {
        HttpSession session = ServletActionContext.getRequest ().getSession();
        String result = "fail";
        String username=(String) session.getAttribute("username");
        if(username!=null)
        {
            ExperimentDAO experimentDAO= ExperimentDAOFactory.getExperimentDAOInstance();
            Experiment experiment=new Experiment();
            experiment.setExperimentName(experimentName);
            experiment.setSrc_host(src_host);
            experiment.setDst_host(dst_host);
            experiment.setSrc_path(src_path);;
            experiment.setDst_path(dst_path);
            experiment.setCron_hour(cron_hour);
            experiment.setCron_minute(cron_minute);

            testsequence1 = testsequence[0];
            for (int i = 1; i < testsequence.length; ++i)
                testsequence1 += "," + testsequence[i];

            experiment.setTestsequence(testsequence1);
            //experiment.setTimeStart(timeStart);
            //experiment.setTimeEnd(timeEnd);
//			experiment.setDate(date);
            experiment.setTimeCreate(createUnixtime);
            experiment.setUsername(username);
            //System.out.println("112");
            try {

                experimentDAO.update(experiment, "experiment", experimentId);
                //session.setAttribute("experimentId", ExperimentId);
                result="success";
                //System.out.println("113");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            // test
            if (cron_hour.length() != 0)
                cron_hour = "cron_hour=\"" + cron_hour + "\"";
            if (cron_minute.length() != 0)
                cron_minute = "cron_minute=\"" + cron_minute + "\"";
            System.out.println(testsequence);
            String var = "SRC_HOST=\"" + src_host + "\" SRC_PATH=\"" + src_path + "\" DST_HOST=\"" + dst_host + "\" DST_PATH=\"" + dst_path
                    + "\"  TESTSEQUENCE=\"" + testsequence1 +"\"" + cron_hour + cron_minute + "cron_window=\"300\" TIMEOUT=\"120\"";
            SExperiment exp = new SExperiment(experimentId, var);
            List<SExperiment> list = new ArrayList<SExperiment>();
            list.add(exp);

            Transfer transfer = Transfer.getInstance();
            transfer.setExpList(list);
            transfer.setUser(username);
            transfer.setId(experimentId);
            transfer.setStarttime(0);
            transfer.setStoptime(0);
            try {
                //System.out.println("4.26");
                transfer.submit();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        else
            result="login";
        return result;
    }
}
