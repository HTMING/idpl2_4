package cn.edu.buaa.jsi.portal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.rpc.ServiceException;

import birdbath.Schedd;
import birdbath.Transaction;
import cn.edu.buaa.jsi.db.DBConnector;
import condor.ClassAdAttrType;
import condor.ClassAdStructAttr;
import condor.UniverseType;
import cn.edu.buaa.jsi.portal.TimeMan;

;
/**
 * 
 * @author yyq @ {2014/10/23}
 *
 */
public class DataPlacement {
	private int size;
	private char unit;
	private int number;
	private String directory;
	private String user;
	private static final ReadXML readxml = ReadXML.getInstance();
	private static final String ws_ipandport = readxml.getWS();
	private URL ws_url;
	private static final DateFormat df = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private final DBConnector dbconnector = DBConnector.getInstance();
	private int failCounter = 0;

	/**
	 * <p>
	 * Consists of 4 methods:dataGenerate,dataTransfer,dataRemove and submitJob.
	 * <p>
	 * "dataGenerate" submits a job to generate source data according to the
	 * given experiment."dataTransfer" submits a DAG job to transfer data for
	 * each single job."dataRemove" gets information of all data from 2
	 * lists:sourceDataList and desDataList,then submits jobs to remove them.As
	 * mentioned above,"submitJob" was called by the other 3 methods.
	 */
	public DataPlacement() {
		try {
			this.ws_url = new URL(ws_ipandport);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets information of the experiment from parameter
	 * "Experiment exp",analyze it and generates parameters needed.Then uses
	 * these parameters to submit a job to generate source data,returns
	 * information about the data using class SourceData.
	 * 
	 * @param exp
	 *            An instance of class Experiment,from which this method gets
	 *            attributes about the experiment.Like where to generate
	 *            data,size of the data and so on.
	 * @param user
	 *            User name,which will be used to create directory for source
	 *            data.
	 * @return An instance of class SourceData,which has these records about
	 *         source data:node name,directory name and file(s) name.
	 * @throws ServiceException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public SourceData dataGenerate(SExperiment exp, String user)
			throws FileNotFoundException, ServiceException, IOException,
			ParseException {

//		final String protocol = exp.getProtocol();
//		final String source = exp.getSource();
//		final String fileSize = exp.getFilesSize();
//		final String script_home = readxml.getSCRIPTHOME();
//		final String script_generate = readxml.getSCRIPT_GENERATOR();
//		final String machine = readxml.getMACHINE(source);
//
//		this.number = exp.getFilesNumber();
		this.user = user;
//		this.size = Integer.parseInt(fileSize.substring(0,
//				fileSize.length() - 1));
//		this.unit = fileSize.charAt(fileSize.length() - 1);

		long time = new Date().getTime();
		String user_time = user + "_" + time;

//		if (protocol.equalsIgnoreCase("http")) {
//			this.directory = readxml.getHTTPHOME(source) + user_time + "/";
//		} else {
//			this.directory = readxml.getFTPHOME(source) + "download/"
//					+ user_time + "/";
//
//		}

//		String command = script_home + script_generate;
		String arguments = null;
//		String requirements = "machine == \"" + machine + "\"";
		UniverseType universe = UniverseType.VANILLA;

//		int ddClusterID = submitJob(command, arguments, requirements, universe,
//				0, null);

		SourceData sourceData = new SourceData();
//		sourceData.setDdClusterID(ddClusterID);
		sourceData.setUser_time(user_time);
//		sourceData.setNode_name(source);
		return sourceData;
	}

	/**
	 * Queries whether all source data have been generated.If yes,submit DAG job
	 * by calling method "submitJob",one of the parameters is files needed by
	 * DAG job.These files will be transfered from web server to condor web
	 * service node.
	 * 
	 * @param id
	 * @param sourceDataList
	 *            list of source data,used to make sure all source data are
	 *            generated
	 * @param desDataList
	 *            list of data on destination node,consists of node name and
	 *            arguments to remove these data
	 * @param starttime
	 *            when to start transfer,specified by user
	 * @param stoptime
	 *            when to stop transfer,specified by user
	 * @param dagFilesLocation
	 *            directory of DAG input file and submit description files
	 * @throws FileNotFoundException
	 * @throws ServiceException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public int dataTransfer(long id, List<SourceData> sourceDataList,
			List<DesData> desDataList, long starttime, final long stoptime,
			String dagFilesLocation, List<Job> jobList)
			throws FileNotFoundException, ServiceException, IOException,
			InterruptedException, ParseException {
		final ReadXML readxml = ReadXML.getInstance();
		final RWDB writeDB = RWDB.getInstance();
		
		String machine = readxml.getMACHINE("BUAA");
		
		int clusterID;
		File file = new File(dagFilesLocation);
		File[] dagFiles = file.listFiles();
		String command = "/usr/bin/condor_dagman";
		String arguments = "-f -l . -Lockfile diamond.dag.lock -AutoRescue 1 -DoRescueFrom 0 -Dag input.dag -CsdVersion $CondorVersion:' '7.6.3' 'Oct' '14' '2011' '$ -Dagman /usr/local/bin/condor_dagman";
//		String arguments = "-f -l . -Lockfile diamond.dag.lock -AutoRescue 1 -DoRescueFrom 0 -Dag input.dag -CsdVersion $CondorVersion:' 8.4.1' 'Oct' '26' '2015' '$ -Dagman /usr/local/bin/condor_dagman";
//		String requirements = "machine == \"" + machine + "\"";
		String requirements = "Target.machine == \"mickey.buaa.edu.cn\"";
//		String requirements = null;	
		
		// UniverseType universe = UniverseType.SCHEDULER;
		UniverseType universe = UniverseType.VANILLA;
//		UniverseType universe = UniverseType.PARALLEL;

		for (SourceData sourceData : sourceDataList) {
			failCounter = 0;
			clusterID = sourceData.getDdClusterID();
			while (!querysuc(clusterID, 0).equals("Completed")) {
				if (failCounter >= 5)
					return 0;
				else {
					Thread.sleep(2000);
					continue;
				}
			}
		}

		final long SubmitTime = df.parse(df.format(new Date())).getTime() / 1000;

		writeDB.writeSubmiteTime(id, SubmitTime);
		
		final int dagClusterID = submitJob(command, arguments, requirements,
				universe, starttime, dagFiles);

//		dbconnector.execute("UPDATE " + readxml.getDBTABLE() + " SET LogName='"
//				+ dagClusterID + ".log" + "' WHERE id=" + id
//				+ " and exp_id=0 ;");
		
		dbconnector.execute("UPDATE " + readxml.getDBTABLE() + " SET LogName='"
				+ dagClusterID + ".log" + "' WHERE id=" + id	);
		
		
		writeDB.writeClusterId(id, dagClusterID);
		writeDB.writeState(id, "Idle");

		TimeMan tm = new TimeMan(id, dagClusterID, sourceDataList, desDataList,
				jobList);
		Thread th = new Thread(tm);
		th.start();

		if (stoptime != 0) {
			final String date = df.format(new Date(stoptime * 1000));
			final Date StopDate = df.parse(date);
			TimerTask timetask = new TimerTask() {

				public void run() {
					try {
						String status = querysuc(dagClusterID, 0);
						while (status.equals("fail")) {
							status = querysuc(dagClusterID, 0);
						}
						if (!status.equals("Completed")) {
							JobMan.holdJob(ws_url, dagClusterID, 0,
									"Time's up.");
						}
					} catch (Exception e) {

					}
				}
			};
			Timer timer = new Timer();
			timer.schedule(timetask, StopDate);
		}
		return 1;
	}

	/**
	 * Removes source data and destination data.
	 * 
	 * @param sourceDataList
	 *            list of source data
	 * @param desDataList
	 *            list of destination data
	 * @throws FileNotFoundException
	 * @throws ServiceException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void dataRemove(List<SourceData> sourceDataList,
			List<DesData> desDataList) throws FileNotFoundException,
			ServiceException, IOException, ParseException {
		String script_home = readxml.getSCRIPTHOME();
		String script_remove = readxml.getSCRIPT_REMOVE();
		String command = script_home + script_remove;
		String arguments;
		String requirements;
		String machine;
		UniverseType universe = UniverseType.VANILLA;

		for (SourceData sourceData : sourceDataList) {
			machine = readxml.getMACHINE(sourceData.getNode_name());
			requirements = "machine == \"" + machine + "\"";
			arguments = "-d " + sourceData.getSource_dataDirectory();
			submitJob(command, arguments, requirements, universe, 0, null);
		}

		for (DesData desData : desDataList) {
			machine = readxml.getMACHINE(desData.getNode_name());
			requirements = "machine == \"" + machine + "\"";
			arguments = desData.getRm_arguments();
			submitJob(command, arguments, requirements, universe, 0, null);
		}

	}

	/**
	 * Submits a job to HTCondor.
	 * 
	 * @param command
	 * @param arguments
	 * @param requirements
	 *            which machine to execute this job
	 * @param universe
	 * @param starttime
	 * @param dagFiles
	 * @return the clusterId of this job
	 * @throws ServiceException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	private int submitJob(String command, String arguments,	String requirements, UniverseType universe, long starttime,	File[] dagFiles)
			throws ServiceException, FileNotFoundException,	IOException, ParseException {

		System.out.println("sumitJob:command="+command+",arguments:"+arguments+"dagFiles:"+dagFiles);
		
		Schedd schedd = new Schedd(ws_url);
		Transaction xact = schedd.createTransaction();
		xact.begin(30);
		int clusterID = xact.createCluster();
		int jobID = xact.createJob(clusterID);
//		final String BUAA_httphome = readxml.getHTTPHOME("BUAA");
		
		final String BUAA_httphome = readxml.rootnode.element("ws").elementText("loghome");
//		final String BUAA_httphome = "/home/idpl/test/"; //���Ŀ¼��Attributes�а������ó�dag����־��error���ļ������Ŀ¼

		if (arguments == null) {
			arguments = "-d " + directory + " -n " + clusterID + " -s " + size
					+ " -u " + unit + " -N " + number;
		}

		ClassAdStructAttr[] Attributes=null;
//
		if (starttime != 0) {

			ClassAdStructAttr[] extraAttributes = {
					new ClassAdStructAttr("DeferralTime",
							ClassAdAttrType.value4, String.valueOf(starttime)),
					new ClassAdStructAttr("UserLog", ClassAdAttrType.value3,
							BUAA_httphome + clusterID + ".log"),
					new ClassAdStructAttr("should_transfer_files",
							ClassAdAttrType.value3, "YES"),
					new ClassAdStructAttr("when_to_transfer_output",
							ClassAdAttrType.value3, "ON_EXIT"),
					new ClassAdStructAttr("transfer_output_files",
							ClassAdAttrType.value3, "\"\"")

			};
			Attributes = extraAttributes;

		} else {

			ClassAdStructAttr[] extraAttributes = {
					new ClassAdStructAttr("UserLog", ClassAdAttrType.value3,
							BUAA_httphome + clusterID + ".log"),
					new ClassAdStructAttr("Err", ClassAdAttrType.value3,
							BUAA_httphome + clusterID + ".err.log"),
					new ClassAdStructAttr("Out", ClassAdAttrType.value3,
							BUAA_httphome + clusterID + ".Out.log"),				
					new ClassAdStructAttr("should_transfer_files",
							ClassAdAttrType.value3, "YES"),
					new ClassAdStructAttr("when_to_transfer_output",
							ClassAdAttrType.value3, "ON_EXIT"),
					new ClassAdStructAttr("transfer_output_files",
							ClassAdAttrType.value3, "\"\"")
//					new ClassAdStructAttr("transfer_output_files",
//							ClassAdAttrType.value3, BUAA_httphome)

			};
			Attributes = extraAttributes;
		}
		
//		xact.submit(clusterID, jobID, user, universe, command, arguments,
//				requirements, Attributes, dagFiles);

//		user="yyq";
		user="nobody";
//		arguments=null;
//		arguments = "-p 0 -f -l .  -DoRescueFrom 0 -Dag buaa2ucsd6.dag -Suppress_notification -CsdVersion $CondorVersion:' '8.4.1' 'Oct' '26' '2015' 'BuildID:' '346648' '$ -Dagman /usr/bin/condor_dagman";
		requirements=null;
//		Attributes=null;
		xact.submit(clusterID, jobID, user, universe, command, arguments,
				requirements, Attributes, dagFiles);
		xact.commit();
		schedd.requestReschedule();
		return clusterID;
	}

	/**
	 * Query the state of a job.
	 * 
	 * @param url
	 *            The web service URL of condor.
	 * @param clusterID
	 *            The clusterID of the job.
	 * @param jobID
	 *            The jobID of the job.
	 * @return The state or "fail"(if the query failed).
	 */
	private String querysuc(int clusterID, int jobID) {
		try {
			String state = QueryJob.queryJob(ws_url, clusterID, jobID);
			return state;
		} catch (Exception e) {
			failCounter += 1;
			System.out.println("DataPlacement failed to query.");
			return "fail";
		}
	}
}
