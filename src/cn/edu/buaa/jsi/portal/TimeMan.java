package cn.edu.buaa.jsi.portal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.edu.buaa.jsi.db.DBConnector;

/**
 * 
 * @author yyq @{2014/10/23}
 *
 */
public class TimeMan implements Runnable {

	private int dagClusterID;
	private long id;
	private List<SourceData> sourceDataList;
	private List<DesData> desDataList;
	private List<Job> jobList;
	private int failCounter=0;

	/**
	 * The TimeMan class queries the state of DAG job and reads time information
	 * from log files,then update database.In database,each single job has a
	 * record contains "State""SubmitTime""RunningTime""CompletedTime" and so
	 * on.When a job's state changes,new information occurs in it's log file,a
	 * line begin with "000""001""005" represents submit,execute,terminate
	 * respectively.So accurate time will be get by analyzing these log files.
	 * 
	 * @param id
	 *            the id of the whole experiment,which is used in TimaMan class
	 *            to update database
	 * @param dagClusterID
	 *            the clusterId of DAG job,which is used to query state
	 * @param sourceDataList
	 *            the list of SourceData,which will be passed as a parameter to
	 *            the method dataRemove to remove source data
	 * @param desDataList
	 *            the list of DesData,which will be passed as a parameter to the
	 *            method dataRemove to remove data
	 * @param jobList
	 *            the list of Job,each job has a log file and a piece of record
	 *            in database
	 */
	public TimeMan(long id, int dagClusterID, List<SourceData> sourceDataList,
			List<DesData> desDataList, List<Job> jobList) {
		super();
		this.id = id;
		this.dagClusterID = dagClusterID;
		this.sourceDataList = sourceDataList;
		this.desDataList = desDataList;
		this.jobList = jobList;
	}

	public void run() {
		// TODO Auto-generated method stub

		try {
			final DBConnector dbconnector = DBConnector.getInstance();
			final RWDB rwDB = RWDB.getInstance();
			final ReadXML readxml = ReadXML.getInstance();
			final String db_table = readxml.getDBTABLE();
//			final String log_home = "http://" + readxml.getIPV4("BUAA") + ":"
//					+ readxml.getHTTPPORT("BUAA") + readxml.getHTTPSUF("BUAA");
//			final String log_home =  readxml.rootnode.element("ws").elementText("ipandport") + readxml.rootnode.element("ws").elementText("loghome");
			final String  log_home = readxml.rootnode.element("ws").elementText("condorloghome");
			
			System.out.println("timeman: loghome="+log_home);
			final SimpleDateFormat df = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			BufferedReader br;
			String line = null;
			String[] tokens;
			String state;
			long RunningTime;
			long CompletedTime;
			long SubmitTime;
			URL log_url;
			URL ws_url = new URL(readxml.getWS());
			int clusterId;
			int flag_Idle = 0;
			int flag_Running = 0;
			int flag_Completed = 0;

			// read DAG log,update State,SubmitTime,CompletedTime in database
			//查询dag状态，更新到数据库，删已完成的dag？，把时间去掉，时间关系不大
			log_url = new URL(log_home + dagClusterID + ".log");
			
			String Currentstate="Idle";
/*
 * (Non-batch mode only) Current status of the job, which varies somewhat according to the job universe and the timing of updates. 
 * H = on hold, R = running, I = idle (waiting for a machine to execute on), C = completed, X = removed, 
 * S = suspended (execution of a running job temporarily suspended on execute node), 
 * < = transferring input (or queued to do so), and > = transferring output (or queued to do so).
 */
			while(true){
				state = querysuc(ws_url, dagClusterID, 0);
				if(state!=Currentstate){
					rwDB.writeState(id, state);
				}
				
				if (state.equals("Running") || state.equals("Idle")){
					//2分钟查询一次
					Thread.sleep(1000*60*2);
					continue;
				}else if (state.equals("fail")|| state.equals("Hold") || state.equals("Removed") || state.equals("Completed")){
					rwDB.writeState(id, state);
					if(state.equals("Completed"))
						JobMan.removeJob(ws_url, dagClusterID, 0, "dag state:"+state);
					break;
				}
//				else {
//					final long removeTime = df.parse(df.format(new Date()))
//							.getTime() / 1000;
//					// Remove the DAG
////					JobMan.removeJob(ws_url, dagClusterID, 0, "Time's up!");
//					
//					// Remove job in this DAG which is Running
////					clusterId = rwDB.readClusterId(id);
////					if (clusterId != 0)
////						JobMan.removeJob(ws_url, clusterId, 0, "Time's up!");
//
//					dbconnector.execute("UPDATE " + db_table
//							+ " SET CompletedTime=" + removeTime + " WHERE id="
//							+ id + " and State<>'Completed';");
//					dbconnector.execute("UPDATE " + db_table
//							+ " SET State='Removed' WHERE id=" + id
//							+ " and State<>'Completed';");
//					break;
//				}
				//1分钟查询一次
				Thread.sleep(1000*60);
			}
			
			
/*
//yyq的老代码
			System.out.println("timeman: loghome="+log_home);
			final SimpleDateFormat df = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			BufferedReader br;
			String line = null;
			String[] tokens;
			String state;
			long RunningTime;
			long CompletedTime;
			long SubmitTime;
			URL log_url;
			URL ws_url = new URL(readxml.getWS());
			int clusterId;
			int flag_Idle = 0;
			int flag_Running = 0;
			int flag_Completed = 0;

			// read DAG log,update State,SubmitTime,CompletedTime in database
			log_url = new URL(log_home + dagClusterID + ".log");
			state = querysuc(ws_url, dagClusterID, 0);
			do {	
				Thread.sleep(2000);
				
				if (state.equals("Idle") || state.equals("fail")) {
					Thread.sleep(3000);
					state = querysuc(ws_url, dagClusterID, 0);
					continue;
				} else if (state.equals("Running") || state.equals("Completed")) {

					while (!existfile(log_url)) {
						state = querysuc(ws_url, dagClusterID, 0);
						if (state.equals("Running")
								|| state.equals("Completed")
								|| state.equals("fail")) {
							Thread.sleep(2000);
							continue;
						} else
							break;
					}
					if (!existfile(log_url))
						break;

					br = new BufferedReader(new InputStreamReader(
							log_url.openStream()));
					line = br.readLine();

					do {
						Thread.sleep(2000);
						
						
						state = querysuc(ws_url, dagClusterID, 0);
						if (state.equals("Running")	|| state.equals("Completed")|| state.equals("fail")) 
							;
						else
							break;

						if (line == null) {
							br = new BufferedReader(new InputStreamReader(
									log_url.openStream()));
							line = br.readLine();
							log_url = new URL(log_home + dagClusterID + ".log");
							continue;
						} else if (line.substring(0, 3).equals("000")
								&& flag_Idle == 0) {
							tokens = line.split(" ");
							SubmitTime = df.parse(
									df.format(new Date()).substring(0, 10)
											+ " " + tokens[3]).getTime() / 1000;
							rwDB.writeSubmiteTime(id, SubmitTime);
							flag_Idle = 1;

							line = br.readLine();
							continue;
						} else if (line.substring(0, 3).equals("001")
								&& flag_Running == 0) {
							tokens = line.split(" ");
							RunningTime = df.parse(
									df.format(new Date()).substring(0, 10)
											+ " " + tokens[3]).getTime() / 1000;
							rwDB.writeRunningTime(id, RunningTime);
							rwDB.writeState(id, "Running");

							break;
						} else {
							line = br.readLine();
							continue;
						}
					} while (true);

					break;

				} else
					break;
			} while (true);

			// for each job in jobList,read it's log and update database
			for (Job job : jobList) {

				flag_Idle = 0;
				flag_Running = 0;
				flag_Completed = 0;

				state = querysuc(ws_url, dagClusterID, 0);
				if (state.equals("Running") || state.equals("Completed")
						|| state.equals("fail"))
					;
				else
					break;

				log_url = new URL(log_home + job.getLog_name());

				while (!existfile(log_url)) {
					state = querysuc(ws_url, dagClusterID, 0);
					if (state.equals("Running") || state.equals("Completed")
							|| state.equals("fail")) {
						Thread.sleep(2000);
						continue;
					} else
						break;
				}
				if (!existfile(log_url))
					break;

				br = new BufferedReader(new InputStreamReader(
						log_url.openStream()));
				line = br.readLine();

				do {
					Thread.sleep(2000);
					
					
					state = querysuc(ws_url, dagClusterID, 0);
					if (state.equals("Running") || state.equals("Completed")
							|| state.equals("fail"))
						;
					else
						break;

					if (line == null) {
						br = new BufferedReader(new InputStreamReader(
								log_url.openStream()));
						line = br.readLine();
						continue;
					} else if (line.substring(0, 3).equals("000")
							&& flag_Idle == 0) {
						tokens = line.split(" ");
						clusterId = Integer.parseInt(tokens[1].split("\\.")[0]
								.substring(1));
						SubmitTime = df.parse(
								df.format(new Date()).substring(0, 10) + " "
										+ tokens[3]).getTime() / 1000;

						rwDB.writeClusterId(job, clusterId);
						rwDB.writeSubmiteTime(job, SubmitTime);
						rwDB.writeState(job, "Idle");
						flag_Idle = 1;

						line = br.readLine();
						continue;
					} else if (line.substring(0, 3).equals("001")
							&& flag_Running == 0) {
						tokens = line.split(" ");
						RunningTime = df.parse(
								df.format(new Date()).substring(0, 10) + " "
										+ tokens[3]).getTime() / 1000;

						rwDB.writeRunningTime(job, RunningTime);
						rwDB.writeState(job, "Running");
						flag_Running = 1;

						line = br.readLine();
						continue;
					} else if (line.substring(0, 3).equals("005")
							&& flag_Completed == 0) {
						tokens = line.split(" ");
						CompletedTime = df.parse(
								df.format(new Date()).substring(0, 10) + " "
										+ tokens[3]).getTime() / 1000;

						rwDB.writeCompletedTime(job, CompletedTime);
						rwDB.writeState(job, "Completed");
						flag_Completed = 1;

						break;
					} else {
						line = br.readLine();
						continue;
					}
				} while (true);

			}
			// get DAG's information when it's state is "Completed"
			state = querysuc(ws_url, dagClusterID, 0);
			do {
				Thread.sleep(2000);
				
				if (state.equals("Running") || state.equals("fail")) {
					Thread.sleep(2000);
					state = querysuc(ws_url, dagClusterID, 0);
					continue;
				} else if (state.equals("Completed")) {
					br = new BufferedReader(new InputStreamReader(
							log_url.openStream()));
					line = br.readLine();
					do {
						if (line == null) {
							br = new BufferedReader(new InputStreamReader(
									log_url.openStream()));
							line = br.readLine();
							continue;
						} else if (line.substring(0, 3).equals("005")) {
							tokens = line.split(" ");
							CompletedTime = df.parse(
									df.format(new Date()).substring(0, 10)
											+ " " + tokens[3]).getTime() / 1000;

							rwDB.writeCompletedTime(id, CompletedTime);
							rwDB.writeState(id, "Completed");

//							 Call the dataRemove method to remove data.
							DataPlacement dataPlacement = new DataPlacement();
							dataPlacement.dataRemove(sourceDataList,
									desDataList);
							break;
						} else {
							line = br.readLine();
							continue;
						}
					} while (true);

					break;
				} else {
					final long removeTime = df.parse(df.format(new Date()))
							.getTime() / 1000;
					// Remove the DAG
					JobMan.removeJob(ws_url, dagClusterID, 0, "Time's up!");

					// Remove job in this DAG which is Running
					clusterId = rwDB.readClusterId(id);
					if (clusterId != 0)
						JobMan.removeJob(ws_url, clusterId, 0, "Time's up!");

					dbconnector.execute("UPDATE " + db_table
							+ " SET CompletedTime=" + removeTime + " WHERE id="
							+ id + " and State<>'Completed';");
					dbconnector.execute("UPDATE " + db_table
							+ " SET State='Removed' WHERE id=" + id
							+ " and State<>'Completed';");

					// Call the dataRemove method to remove data.
					DataPlacement dataPlacement = new DataPlacement();
					dataPlacement.dataRemove(sourceDataList, desDataList);
					break;
				}
			} while (true);


 */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Gives the answer whether a file exists or not.
	 * 
	 * @param log_url
	 *            URL of the file.
	 * @return true or false,true means the file exists while false means not
	 */
	private boolean existfile(URL log_url) {
		// TODO Auto-generated method stub
		try {
			log_url.openStream();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Query the state of a job.
	 * 
	 * @param url
	 *            The web service URL of HTCondor.
	 * @param clusterID
	 *            The clusterID of the job.
	 * @param jobID
	 *            The jobID of the job.
	 * @return The state or "fail"(if the query failed).
	 */
	private String querysuc(URL url, int clusterID, int jobID) {
		try {
			String state = QueryJob.queryJob(url, clusterID, jobID);
			
//			System.out.println("querysuc, state="+state+".  clusterID, jobID:"+clusterID+","+ jobID);
			return state;
		} catch (Exception e) {
			failCounter+=1;
			System.out.println("TimeMan failed to query.");
			return "fail";
		}
	}

}
