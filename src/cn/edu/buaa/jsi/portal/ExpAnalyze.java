package cn.edu.buaa.jsi.portal;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.dom4j.DocumentException;

import cn.edu.buaa.jsi.db.DBConnector;

/**
 * 
 * @author yyq @ {2014/10/23}
 *
 */
public class ExpAnalyze implements Runnable {

	private List<SExperiment> expList = new ArrayList<SExperiment>();
	private String user;
	private long id;
	private long starttime;
	private long stoptime;

	/**
	 * <P>
	 * Analyzes the list of experiments.
	 * <P>
	 * First,create the directory for DAG files.Then get each experiment from
	 * List<Experiment>,call "dataGenerate" to generate data needed and create
	 * submit description file(files if repeat is not 1) for this experiment.
	 * Then generate the DAG input file according to the number of all jobs.Call
	 * "dataTransfer" to submit DAG.
	 * 
	 * @param expList
	 *            list of all experiments
	 * @param user
	 *            User name,which will be used to create directory for DAG
	 *            files.
	 * @param id
	 *            id of this whole experiment
	 * @param starttime
	 *            time to start this experiment,specified by user
	 * @param stoptime
	 *            time to stop this experiment(if it's not completed up to this
	 *            point of time ),specified by user
	 */
	public ExpAnalyze(List<SExperiment> expList, String user, long id,
			long starttime, long stoptime) {
		this.expList = expList;
		this.user = user;
		this.id = id;
		this.starttime = starttime;
		this.stoptime = stoptime;
	}


	/**
	 * @author sunshine
	 * 生成condor的提交文件
	 * 数据库保存的东西应该是作业相关的。。具体不确定
	 */
	
	@Override
	public void run() {

		final ReadXML readxml = ReadXML.getInstance();
		final String db_table = readxml.getDBTABLE();
		final String dagFilesTmp = "../webapps/idpl/tmp/";
		
//		System.out.println("connet db start...");
		final DBConnector dbconnector = DBConnector.getInstance();
//		System.out.println("connet db sucess..");
		
		List<SourceData> sourceDataList = new ArrayList<SourceData>();
		List<DesData> desDataList = new ArrayList<DesData>();
		List<Job> jobList = new ArrayList<Job>();

		String data_Usertime;
		String protocol, putorget, v4orv6, source, destination;
		String arguments = null, requirements = null;
		String source_ip, destination_ip, des_machine, source_machine;
		String source_httpport, source_ftpport, des_ftpport, source_httpsuf;
		String des_DataDirectory, source_DataDirectory;
		String FTP_USER, FTP_PASSWD;
		String NumofLog = null;
		String log_name = null;
		long exp_id;
		int flag = 0;
		int FilesNumber;
		int ddClusterID;
		int parallel, repeat;
		int num_Job = 0;

		dbconnector.execute("insert into " + db_table
				+ " (id,exp_id,repeat_id,State,Description) values(" + id
				+ ",0,0,'Waiting','DAG');");

		DagGenFiles dagGenFiles = new DagGenFiles();
		DataPlacement dataPlacement = new DataPlacement();

		// Create directory for DAG files.
//		final String dagFilesLocation = dagFilesTmp + user + "_"
//				+ new Date().getTime() + "/";
		final String dagFilesLocation = dagFilesTmp + user + id+ "/";
		new File(dagFilesLocation).mkdirs();

		try {

			for (SExperiment exp : expList) {
				exp_id = exp.getExp_id();
				String exp_var=exp.getVar();
				// Generate DAG  file  
//				dagGenFiles.genDag(exp_id, dagFilesLocation, exp_var);
				dagGenFiles.genDag(id, dagFilesLocation, exp_var);
				
				
//				log_name=exp_id+"/placement6.log";
				
//				dbconnector.execute("insert into " + db_table
//				+ " (id,exp_id,LogName,State) values("
//				+ id + "," + exp_id + ",'" + log_name
//				+ "','Waiting');");
				
 
//这个log id不是实验的id，是condor作业的
//				log_name=id+".log";
//				dbconnector.execute("update " + db_table + " set LogName=" + log_name + " where id=" + id +";");
				
				
//				SourceData sourceData = dataPlacement.dataGenerate(exp, user);
//				sourceDataList.add(sourceData);
//				SourceData sourceData = dataPlacement.dataGenerate(exp, user);
//				data_Usertime = sourceData.getUser_time();
//				ddClusterID = sourceData.getDdClusterID();
//				if (flag == 0) {
//					NumofLog = Integer.toString(ddClusterID);
//					flag = 1;
//				}
//				
//				source = exp.getSource();
//				destination = exp.getDestination();
//				protocol = exp.getProtocol();
//				putorget = exp.getPutorget();
//				v4orv6 = exp.getV4orv6();
//				FilesNumber = exp.getFilesNumber();
//				parallel = exp.getParallel();
//				repeat = exp.getRepeat();
//
//				/**
//				 * According to how many times to repeat,generates submit
//				 * description file(s) for this experiment,adds each job to
//				 * jobList and database.
//				 */
//				for (int i = 1; i <= repeat; i++) {
//					Job job = new Job();
//					log_name = NumofLog + "." + num_Job + ".log";
//					dagGenFiles.genJobSub(dagFilesLocation, log_name, num_Job,
//							arguments, requirements);
//					num_Job++;
//					job.setId(id);
//					job.setExp_id(exp_id);
//					job.setRepeat_id(i);
//					job.setLog_name(log_name);
//					jobList.add(job);
//
//					dbconnector.execute("insert into " + db_table
//							+ " (id,exp_id,repeat_id,LogName,State) values("
//							+ id + "," + exp_id + "," + i + ",'" + log_name
//							+ "','Waiting');");
//				}
			}
//			// Generate DAG input file according to the total number of jobs.
//			dagGenFiles.genDagInput(num_Job, dagFilesLocation);

			dataPlacement.dataTransfer(id, sourceDataList, desDataList,
					starttime, stoptime, dagFilesLocation, jobList);

		} catch (IOException | ServiceException | ParseException
				| InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 * @author sunshine
	 * 下面是yyq的老代码
	 */
	
//	@Override
//	public void run() {
//
//		final ReadXML readxml = ReadXML.getInstance();
//		final String db_table = readxml.getDBTABLE();
//		final String dagFilesTmp = "../webapps/idpl/tmp/";
//		
////		System.out.println("connet db start...");
//		final DBConnector dbconnector = DBConnector.getInstance();
////		System.out.println("connet db sucess..");
//		
//		List<SourceData> sourceDataList = new ArrayList<SourceData>();
//		List<DesData> desDataList = new ArrayList<DesData>();
//		List<Job> jobList = new ArrayList<Job>();
//
//		String data_Usertime;
//		String protocol, putorget, v4orv6, source, destination;
//		String arguments, requirements;
//		String source_ip, destination_ip, des_machine, source_machine;
//		String source_httpport, source_ftpport, des_ftpport, source_httpsuf;
//		String des_DataDirectory, source_DataDirectory;
//		String FTP_USER, FTP_PASSWD;
//		String NumofLog = null;
//		String log_name = null;
//		long exp_id;
//		int flag = 0;
//		int FilesNumber;
//		int ddClusterID;
//		int parallel, repeat;
//		int num_Job = 0;
//
//		dbconnector.execute("insert into " + db_table
//				+ " (id,exp_id,repeat_id,State,Description) values(" + id
//				+ ",0,0,'Waiting','DAG');");
//
//		DagGenFiles dagGenFiles = new DagGenFiles();
//		DataPlacement dataPlacement = new DataPlacement();
//
//		// Create directory for DAG files.
//		final String dagFilesLocation = dagFilesTmp + user + "_"
//				+ new Date().getTime() + "/";
//		new File(dagFilesLocation).mkdirs();
//
//		try {
//
//			for (SExperiment exp : expList) {
//				exp_id = exp.getExp_id();
//				SourceData sourceData = dataPlacement.dataGenerate(exp, user);
//				data_Usertime = sourceData.getUser_time();
//				ddClusterID = sourceData.getDdClusterID();
//				if (flag == 0) {
//					NumofLog = Integer.toString(ddClusterID);
//					flag = 1;
//				}
//				
//				source = exp.getSource();
//				destination = exp.getDestination();
//				protocol = exp.getProtocol();
//				putorget = exp.getPutorget();
//				v4orv6 = exp.getV4orv6();
//				FilesNumber = exp.getFilesNumber();
//				parallel = exp.getParallel();
//				repeat = exp.getRepeat();
//
//				if (v4orv6.equalsIgnoreCase("ipv4")) {
//					source_ip = readxml.getIPV4(source);
//					destination_ip = readxml.getIPV4(destination);
//				} else {
//					source_ip = readxml.getIPV6(source);
//					destination_ip = readxml.getIPV6(destination);
//				}
//				// http
//				if (protocol.equalsIgnoreCase("http")) {
//					sourceData.setSource_dataDirectory(readxml
//							.getHTTPHOME(source) + data_Usertime + "/");
//					sourceDataList.add(sourceData);
//					desDataList.add(new DesData(destination, "-d "
//							+ readxml.getHTTPHOME(destination) + data_Usertime
//							+ "/"));
//					source_httpport = readxml.getHTTPPORT(source);
//					source_httpsuf = readxml.getHTTPSUF(source);
//					des_machine = readxml.getMACHINE(destination);
//					des_DataDirectory = readxml.getHTTPHOME(destination)
//							+ data_Usertime + "/";
//					arguments = "-t " + source_ip + ":" + source_httpport
//							+ " -s " + source_httpsuf + data_Usertime + "/"
//							+ " -d " + des_DataDirectory + " -n " + ddClusterID
//							+ " -p http -D get -N " + FilesNumber + " -P "
//							+ parallel;
//					requirements = "machine == \"" + des_machine + "\"";
//
//				} else {
//					sourceData.setSource_dataDirectory(readxml
//							.getFTPHOME(source)
//							+ "download/"
//							+ data_Usertime
//							+ "/");
//					sourceDataList.add(sourceData);
//
//					// ftp,get
//					if (putorget.equalsIgnoreCase("get")) {
//						desDataList.add(new DesData(destination, "-d "
//								+ readxml.getFTPHOME(destination) + "download/"
//								+ data_Usertime + "/"));
//						source_ftpport = readxml.getFTPPORT(source);
//						des_machine = readxml.getMACHINE(destination);
//						FTP_USER = readxml.getFTPUSER(source);
//						FTP_PASSWD = readxml.getFTPPASSWD(source);
//						des_DataDirectory = readxml.getFTPHOME(destination)
//								+ "download/" + data_Usertime + "/";
//						arguments = "-t " + source_ip + ":" + source_ftpport
//								+ " -s /download/" + data_Usertime + "/"
//								+ " -d " + des_DataDirectory + " -n "
//								+ ddClusterID + " -p ftp -D get -N "
//								+ FilesNumber + " -P " + parallel
//								+ " FTP_USER=" + FTP_USER + " FTP_PASSWD="
//								+ FTP_PASSWD;
//						requirements = "machine == \"" + des_machine + "\"";
//					}
//					// ftp,put
//					else {
//						des_ftpport = readxml.getFTPPORT(destination);
//						source_machine = readxml.getMACHINE(source);
//						FTP_USER = readxml.getFTPUSER(destination);
//						FTP_PASSWD = readxml.getFTPPASSWD(destination);
//						
//						source_DataDirectory = readxml.getFTPHOME(source)
//								+ "download/" + data_Usertime + "/";
//						des_DataDirectory = readxml.getFTPHOME(destination)
//								+ "upload/" + data_Usertime + "/";
//						
////						desDataList.add(new DesData(destination, "-t "
////								+ destination_ip + " -d " + des_DataDirectory
////								+ " -n " + ddClusterID + " -p ftp -N "
////								+ FilesNumber + " FTP_USER=" + FTP_USER
////								+ " FTP_PASSWD=" + FTP_PASSWD));
//						
//						desDataList.add(new DesData(destination, "-t "
//								+ destination_ip + " -d " + "upload/" + data_Usertime + "/"
//								+ " -n " + ddClusterID + " -p ftp -N "
//								+ FilesNumber + " FTP_USER=" + FTP_USER
//								+ " FTP_PASSWD=" + FTP_PASSWD));
//
//						arguments = "-t " + destination_ip + ":" + des_ftpport
//								+ " -s " + source_DataDirectory + " -d "
//								+ "/upload/" + data_Usertime + "/" + " -n "
//								+ ddClusterID + " -p ftp -D put -N "
//								+ FilesNumber + " -P " + parallel
//								+ " FTP_USER=" + FTP_USER + " FTP_PASSWD="
//								+ FTP_PASSWD;
//						requirements = "machine == \"" + source_machine + "\"";
//					}
//				}
//
//				if (v4orv6.equalsIgnoreCase("ipv6")) {
//					arguments = arguments + " -6";
//				}
//				/**
//				 * According to how many times to repeat,generates submit
//				 * description file(s) for this experiment,adds each job to
//				 * jobList and database.
//				 */
//				for (int i = 1; i <= repeat; i++) {
//					Job job = new Job();
//					log_name = NumofLog + "." + num_Job + ".log";
//					dagGenFiles.genJobSub(dagFilesLocation, log_name, num_Job,
//							arguments, requirements);
//					num_Job++;
//					job.setId(id);
//					job.setExp_id(exp_id);
//					job.setRepeat_id(i);
//					job.setLog_name(log_name);
//					jobList.add(job);
//
//					dbconnector.execute("insert into " + db_table
//							+ " (id,exp_id,repeat_id,LogName,State) values("
//							+ id + "," + exp_id + "," + i + ",'" + log_name
//							+ "','Waiting');");
//				}
//			}
//			// Generate DAG input file according to the total number of jobs.
//			dagGenFiles.genDagInput(num_Job, dagFilesLocation);
//
//			dataPlacement.dataTransfer(id, sourceDataList, desDataList,
//					starttime, stoptime, dagFilesLocation, jobList);
//
//		} catch (IOException | ServiceException | ParseException
//				| DocumentException | InterruptedException e) {
//			e.printStackTrace();
//		}
//
//	}

	
	
	
}
