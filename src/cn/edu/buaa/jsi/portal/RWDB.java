package cn.edu.buaa.jsi.portal;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.buaa.jsi.db.DBConnector;

public class RWDB {
	private static RWDB rwDB;
	private DBConnector dbconnector;
	private String db_table;

	private RWDB() {
		final ReadXML readxml = ReadXML.getInstance();
		this.dbconnector = DBConnector.getInstance();
		this.db_table = readxml.getDBTABLE();
	}

	public static synchronized RWDB getInstance() {
		if (rwDB == null) {
			rwDB = new RWDB();
		}
		return rwDB;
	}

	/**
	 * Writes the state of this job to database.
	 * 
	 * @param job
	 *            gets the job's id,exp_id,repeat_id from it
	 * @param state
	 *            the state of the job,which can be
	 *            "Waiting""Idle""Running""Completed""Removed"
	 */
	public void writeState(Job job, String state) {
		dbconnector.execute("UPDATE " + db_table + " SET State='" + state
				+ "' WHERE id=" + job.getId() + " and exp_id="
				+ job.getExp_id() + " and repeat_id=" + job.getRepeat_id()
				+ ";");
	}

	/**
	 * Writes the SubmitTime of this job to database.
	 * 
	 * @param job
	 *            gets the job's id,exp_id,repeat_id from it
	 * @param time
	 *            the time when submit this job
	 */
	public void writeSubmiteTime(Job job, long time) {
		dbconnector.execute("UPDATE " + db_table + " SET SubmitTime=" + time
				+ " WHERE id=" + job.getId() + " and exp_id=" + job.getExp_id()
				+ " and repeat_id=" + job.getRepeat_id() + ";");
	}

	/**
	 * Writes the RunningTime of this job to database.
	 * 
	 * @param job
	 *            gets the job's id,exp_id,repeat_id from it
	 * @param time
	 *            the time when this job started running
	 */
	public void writeRunningTime(Job job, long time) {
		dbconnector.execute("UPDATE " + db_table + " SET RunningTime=" + time
				+ " WHERE id=" + job.getId() + " and exp_id=" + job.getExp_id()
				+ " and repeat_id=" + job.getRepeat_id() + ";");
	}

	/**
	 * Writes the CompletedTime of this job to database.
	 * 
	 * @param job
	 *            gets the job's id,exp_id,repeat_id from it
	 * @param time
	 *            the time when this job is completed
	 */
	public void writeCompletedTime(Job job, long time) {
		dbconnector.execute("UPDATE " + db_table + " SET CompletedTime=" + time
				+ " WHERE id=" + job.getId() + " and exp_id=" + job.getExp_id()
				+ " and repeat_id=" + job.getRepeat_id() + ";");
	}

	/**
	 * Writes the clusterId of this job to database.
	 * 
	 * @param job
	 *            gets the job's id,exp_id,repeat_id from it
	 * @param clusterId
	 *            the clusterId of this job,which is got from log
	 */
	public void writeClusterId(Job job, int clusterId) {
		dbconnector.execute("UPDATE " + db_table + " SET clusterId="
				+ clusterId + " WHERE id=" + job.getId() + " and exp_id="
				+ job.getExp_id() + " and repeat_id=" + job.getRepeat_id()
				+ ";");
	}

	/**
	 * Writes the state of this DAG to database.Since exp_id and repeat_id of
	 * all DAG jobs are both 0,there is no need to pass them as parameters.
	 * 
	 * @param id
	 *            the id of this DAG
	 * @param state
	 *            the state of this DAG,which can be
	 *            "Waiting""Idle""Running""Completed""Removed"
	 */
	public void writeState(long id, String state) {
		dbconnector.execute("UPDATE " + db_table + " SET State='" + state
				+ "' WHERE id=" + id + " and exp_id=0 and repeat_id=0;");
	}

	/**
	 * Writes the SubmitTime of this DAG to database.Since exp_id and repeat_id
	 * of all DAG jobs are both 0,there is no need to pass them as parameters.
	 * 
	 * @param id
	 *            the id of this DAG
	 * @param time
	 *            the time when submit this DAG
	 */
	public void writeSubmiteTime(long id, long time) {
		dbconnector.execute("UPDATE " + db_table + " SET SubmitTime=" + time
				+ " WHERE id=" + id + " and exp_id=0 and repeat_id=0;");
	}

	/**
	 * Writes the RunningTime of this DAG to database.Since exp_id and repeat_id
	 * of all DAG jobs are both 0,there is no need to pass them as parameters.
	 * 
	 * @param id
	 *            the id of this DAG
	 * @param time
	 *            the time when this DAG started running
	 */
	public void writeRunningTime(long id, long time) {
		dbconnector.execute("UPDATE " + db_table + " SET RunningTime=" + time
				+ " WHERE id=" + id + " and exp_id=0 and repeat_id=0;");
	}

	/**
	 * Writes the CompletedTime of this DAG to database.Since exp_id and
	 * repeat_id of all DAG jobs are both 0,there is no need to pass them as
	 * parameters.
	 * 
	 * @param id
	 *            the id of this DAG
	 * @param time
	 *            the time when this DAG is completed
	 */
	public void writeCompletedTime(long id, long time) {
		dbconnector.execute("UPDATE " + db_table + " SET CompletedTime=" + time
				+ " WHERE id=" + id + " and exp_id=0 and repeat_id=0;");
	}

	/**
	 * Writes the clusterId of this DAG to database.Since exp_id and repeat_id
	 * of all DAG jobs are both 0,there is no need to pass them as parameters.
	 * 
	 * @param id
	 *            the id of this DAG
	 * @param clusterId
	 *            the clusterId of this DAG
	 */
	public void writeClusterId(long id, int clusterId) {
		dbconnector.execute("UPDATE " + db_table + " SET clusterId="
				+ clusterId + " WHERE id=" + id
				+ " and exp_id=0 and repeat_id=0;");
	}

	/**
	 * Returns the clusterId of job which state is "Running" according to this
	 * id.
	 * 
	 * @param id
	 *            id of this job
	 * @return the clusterId of job which is "Running" or 0
	 */
	public int readClusterId(long id) {
		ResultSet rs = null;
		rs = dbconnector.selectSQL("SELECT clusterId from " + db_table
				+ " where id=" + id + " and exp_id<>0 and State='Running';");
		try {
			if (rs.next()) {
				return rs.getInt("clusterId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
