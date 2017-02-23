package com.idpl.dao;
import java.sql.*;

/*import org.dom4j.*;
import org.dom4j.io.*;

import cn.edu.buaa.jsi.portal.ReadXML;*/
public class DataBaseConnection {	
	
/*	private String url="jdbc:mysql://115.25.138.209:3306/cac";
	private static final String user="idpl";
	private static final String password="idpl@jsi";
*/
/*	private String url;
	private String user;
	private String password;
	public static final String XMLpath = "../webapps/config/Node.xml";
	*/

/*
	private String url="jdbc:mysql://115.25.138.209:3306/cac";
	private static final String user="idpl";
	private static final String password="idpl@jsi";
*/
	private String url="jdbc:mysql://localhost:3306/idpl";
	private static final String user="root";
	private static final String password="password";


/*	private String url="jdbc:mysql://localhost:3306/cac";
	private static final String user="root";
	private static final String password="123456";*/
	Connection conn=null;
	
	public DataBaseConnection(String TableName) throws Exception{
		 	/*
		 	 * SAXReader reader = new SAXReader();
			document = reader.read(new File(ReadXML.XMLpath));
			this.rootnode = document.getRootElement();
		 	 */
					 
		/*try {
			SAXReader sr = new SAXReader();  //��ȡ��ȡxml�Ķ���
			org.dom4j.Document doc = sr.read("/home/kwang/apache-tomcat-7.0.56/webapps/config/.xml");
			Element el_root = doc.getRootElement();// ����ȡ���ݣ���ȡxml�ĸ��ڵ㡣
			url = el_root.element("database").elementText("address");
		} catch (DocumentException e) {
			System.out.println("reading configuration failed!");
		}*/
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.conn=DriverManager.getConnection(url, user, password);
		}
		catch (Exception e){
			System.out.println("Load Driver Fail!");
		}
	}
	public Connection getConnection(){
		return this.conn;
	}
	public void close() throws Exception{
		if(this.conn!=null)
		try{
			conn.close();
		}catch(Exception e){
			System.out.println("DataBase Close Fail!");
		}
	}
}
