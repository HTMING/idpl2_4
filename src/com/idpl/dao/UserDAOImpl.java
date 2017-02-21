package com.idpl.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class UserDAOImpl implements UserDAO{
	public void insert(User user,String TableName) throws Exception{
		String sql="INSERT INTO "+TableName+"(username,password) VALUES (?,?)";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		try{
			dbc=new DataBaseConnection(TableName);
		}catch(Exception e){
			throw new Exception("Connection Error!");
		}
		try{
			
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch (Exception e){
			throw new Exception("Insert Error!");
		}
		finally{
			dbc.close();
		}
	}
	public void update(User user,String TableName) throws Exception{
		
	}
	public void delete(User user,String TableName) throws Exception{
		
	}
	public User queryByName(String username,String TableName) throws Exception{
		User user=null;
		/*
		String sql="SELECT * FROM "+TableName+" WHERE id=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		if(TableName.equals("test"))
		{
			try{
				dbc=new DataBaseConnection(TableName);
				pstmt=dbc.getConnection().prepareStatement(sql);
				pstmt.setLong(1, id);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()){
					record=new Record();
					record.setRecordId(rs.getLong(1));
					record.setTestName(rs.getString(2));
					record.setWay(rs.getString(3));
					record.setFileSender(rs.getString(4));
					record.setDataSize(rs.getString(5));
					record.setFileReceiver(rs.getString(6));
					record.setFrequency(rs.getString(7));
					record.setTime_Start(rs.getString(8));
					record.setTime_End(rs.getString(9));
					record.setDate(rs.getString(10));
					record.setMethod(rs.getString(11));
					record.setProtocol(rs.getString(12));
				}
				rs.close();
				pstmt.close();
			}catch(Exception e){
				throw new Exception("Query By Id Fail!");
			}
			finally{
				dbc.close();
			}
		}
		else if(TableName.equals("condorjob"))
		{
			try{
				dbc=new DataBaseConnection(TableName);
				pstmt=dbc.getConnection().prepareStatement(sql);
				pstmt.setLong(1, id);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()){
					record=new Record();
					record.setRecordId(rs.getLong(1));
					record.setClusterId(rs.getInt(3));
					record.setJobId(rs.getInt(4));
					record.setState(rs.getString(5));
					record.setStartRunning(rs.getString(6));
					record.setCompletedTime(rs.getString(7));
				}
				rs.close();
				pstmt.close();
			}catch(Exception e){
				throw new Exception("Query By Id Fail!");
			}
			finally{
				dbc.close();
			}
		}
		*/
		return user;
	}
	public List<User> queryAll(String TableName) throws Exception{
		List<User> all= new ArrayList<User>();
		/*
		String sql="SELECT * FROM "+TableName;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		try{
			dbc=new DataBaseConnection(TableName);
			pstmt=dbc.getConnection().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Record record=new Record();
				record.setRecordId(rs.getLong(1));
				record.setTestName(rs.getString(2));
				record.setWay(rs.getString(3));
				record.setFileSender(rs.getString(4));
				record.setDataSize(rs.getString(5));
				record.setFileReceiver(rs.getString(6));
				record.setFrequency(rs.getString(7));
				record.setTime_Start(rs.getString(8));
				record.setTime_End(rs.getString(9));
				record.setDate(rs.getString(10));
				record.setMethod(rs.getString(11));
				record.setProtocol(rs.getString(12));
				all.add(record);
			}
			rs.close();
			pstmt.close();
		}
		catch(Exception e){
			throw new Exception("QueryAll Error!");
		}
		finally{
			dbc.close();
		}
		*/
		return all;
	}
	@Override
	public String isUser(String username, String password, String TableName)
			throws Exception {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM "+TableName+" WHERE username=? AND password=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		String result="false";
		try{
			dbc=new DataBaseConnection(TableName);
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				result="true";
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			throw new Exception("Query By Id Fail!");
		}
		finally{
			dbc.close();
		}
		return result;
	}
	public String hasExisted(String username,String TableName) throws Exception{
		String sql="SELECT * FROM "+TableName+" WHERE username=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		String result="false";
		try{
			dbc=new DataBaseConnection(TableName);
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				result="true";
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			throw new Exception("Query By Id Fail!");
		}
		finally{
			dbc.close();
		}
		return result;
	}
}
