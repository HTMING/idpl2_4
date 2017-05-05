package cn.edu.buaa.jsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.buaa.jsi.portal.ReadXML;

/**
 * 
 * @author yyq @{2014/10/23}
 *
 */
public class DBConnector {
	private static DBConnector dbconnector;
	private static String driver = "com.mysql.jdbc.Driver";
	private static Connection con = null;
	private static Statement stmt = null;
	private String db_address;
	private String db_user;
	private String db_passwd;

	/**
	 * The DBConnector class connects to database and executes sql command.
	 */
	private DBConnector() {
		try {
			ReadXML readxml = ReadXML.getInstance();
			db_address = readxml.getDBADDRESS();
			db_user = readxml.getDBUSER();
			db_passwd = readxml.getDBPASSWD();
			
			//print db addr.
			System.out.println("DBConnector.java: db:"+db_address);
			
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(db_address, db_user, db_passwd);
			stmt = con.createStatement();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Returns the unique instance of DBConnector.
	 * 
	 * @return the unique instance of DBConnector
	 */
	public static synchronized DBConnector getInstance() {
		if (dbconnector == null) {
			dbconnector = new DBConnector();
		}
		return dbconnector;
	}

	/**
	 * Executes a sql command.
	 * 
	 * @param sql
	 * 
	 */
	public void execute(String sql) {
		try {
			//print db addr.
			System.out.println("DBConnector.java: sql:"+sql);
			stmt.execute(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Executes a query SQL.
	 * 
	 * @param sql
	 * @return results
	 */
	public ResultSet selectSQL(String sql) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}