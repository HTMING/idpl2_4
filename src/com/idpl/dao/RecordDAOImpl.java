package com.idpl.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class RecordDAOImpl implements RecordDAO{
	public long insert(Record record,String TableName) throws Exception{
		String sql="INSERT INTO "+TableName+"(id,testName,way,source,dataSize,destination,frequency,Date,method,protocol,number,parallel,username,experimentId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		
		long NewId=System.currentTimeMillis()/1000;
		try{
			dbc=new DataBaseConnection(TableName);
		}catch(Exception e){
			throw new Exception("Connection Error!");
		}
		try{
			
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setLong(1, NewId);
			pstmt.setString(2, record.getTestName());
			pstmt.setString(3, record.getWay());
			pstmt.setString(4, record.getDataSource());
			pstmt.setString(5, record.getDataSize());
			pstmt.setString(6, record.getDataDestination());
			pstmt.setString(7, record.getRepeat());
			pstmt.setString(8, record.getDate());
			pstmt.setString(9, record.getMethod());
			pstmt.setString(10, record.getProtocol());
			pstmt.setString(11, record.getNumber());
			pstmt.setString(12, record.getParallel());
			pstmt.setString(13, record.getUsername());
			pstmt.setLong(14, record.getExperimentId());
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch (Exception e){
			throw new Exception("Insert Error!");
		}
		finally{
			dbc.close();
		}
		return NewId;
	}
	public void update(Record record,String TableName,long recordId,long experimentId) throws Exception{
		String sql="UPDATE "+TableName+" SET testName=?, way=?,  source=?, dataSize=?, destination=?, frequency=?," +
				" method=?, protocol=?, number=? ,parallel=? WHERE id="+recordId+" AND experimentId="+experimentId;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		try{
			dbc=new DataBaseConnection(TableName);
		}catch(Exception e){
			throw new Exception("Connection Error!");
		}
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
//			System.out.println(pstmt);
			pstmt.setString(1, record.getTestName());
			pstmt.setString(2, record.getWay());
			pstmt.setString(3, record.getDataSource());
			pstmt.setString(4, record.getDataSize());
			pstmt.setString(5, record.getDataDestination());
			pstmt.setString(6, record.getRepeat());
			pstmt.setString(7, record.getMethod());
			pstmt.setString(8, record.getProtocol());
			pstmt.setString(9, record.getNumber());
			pstmt.setString(10, record.getParallel());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch(Exception e){
			throw new Exception("Update Error!");
		}
		finally{
			dbc.close();
		}
	}
	public void delete(long recordId,String TableName,long experimentId) throws Exception{
		String sql="DELETE FROM "+TableName+" WHERE id="+recordId+" AND experimentId="+experimentId;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		try{
			dbc=new DataBaseConnection(TableName);
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e){
			throw new Exception("Delete Stage ERROR!");
		}
		finally{
			dbc.close();
		}
	}
	public Record queryById(long id,String TableName,String username,long experimentId) throws Exception{
		Record record=null;
		long recordId;
		String sql="SELECT * FROM "+TableName+" WHERE id=? AND username='"+username+"' AND experimentId="+experimentId;		
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
					recordId=rs.getLong(1);
					record.setRecordId(recordId);
					record.setTestName(rs.getString(2));
					record.setWay(rs.getString(3));
					record.setDataSource(rs.getString(4));
					record.setDataSize(rs.getString(5));
					record.setDataDestination(rs.getString(6));
				//	record.setTime_Start(rs.getString(7));
				//	record.setTime_End(rs.getString(8));
					record.setDate(rs.getString(9));
					record.setMethod(rs.getString(10));
					record.setProtocol(rs.getString(11));
					record.setNumber(rs.getString(12));
					record.setParallel(rs.getString(13));
					record.setRepeat(rs.getString(14));
					record.setUsername(rs.getString(15));
					record.setExperimentId(rs.getLong(16));
					record.setRepeatPart(getCompleteNumber(recordId,"idplExperiment",username,experimentId));
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
		return record;
	}
	public List<Record> queryAll(String TableName,String username,long experimentId) throws Exception{
		List<Record> all= new ArrayList<Record>();
		String sql="SELECT * FROM "+TableName+" WHERE username='"+username+"' AND experimentId="+experimentId;
//		System.out.println(sql);
		if(username.equals("manager"))
			sql="SELECT * FROM "+TableName+" WHERE experimentId="+experimentId;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		try{
			long recordId;
			int completeNumber;
			int percentage;
			int repeat;	
			long[] StartRunningAndCompleteTimeAndState;
			dbc=new DataBaseConnection(TableName);
			pstmt=dbc.getConnection().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Record record=new Record();
				recordId=rs.getLong(1);
//				System.out.println(recordId);
				record.setRecordId(recordId);
				record.setTestName(rs.getString(2));
				record.setWay(rs.getString(3));
				record.setDataSource(rs.getString(4));
				record.setDataSize(rs.getString(5));
				record.setDataDestination(rs.getString(6));
			//	record.setTime_Start(rs.getString(7));
			//	record.setTime_End(rs.getString(8));
				record.setDate(rs.getString(9));
				record.setMethod(rs.getString(10));
				record.setProtocol(rs.getString(11));
				record.setNumber(rs.getString(12));
				record.setParallel(rs.getString(13));
				record.setRepeat(rs.getString(14));
				record.setUsername(rs.getString(15));
				record.setExperimentId(rs.getLong(16));
				
				completeNumber=getCompleteNumber(recordId,"idplExperiment",username,experimentId);
//				System.out.println(completeNumber);
				record.setRepeatPart(completeNumber);
				
				repeat=Integer.parseInt(rs.getString(14));
				percentage=completeNumber*100/repeat;
//				System.out.println(percentage);
				StartRunningAndCompleteTimeAndState=getStartRunningAndCompleteTime(recordId,experimentId,repeat);
				if(StartRunningAndCompleteTimeAndState[2]==-1)
					record.setState("Waiting");
				else if(StartRunningAndCompleteTimeAndState[2]==0)
					record.setState("Idle");
				else if(StartRunningAndCompleteTimeAndState[3]==2)
				{
					record.setState("Completed");
					record.setStartRunning(StartRunningAndCompleteTimeAndState[0]+"");
					record.setCompletedTime(StartRunningAndCompleteTimeAndState[1]+"");
				}
				else if(StartRunningAndCompleteTimeAndState[2]==-3)
					record.setState("IdleOrWaitingRemoved");
				else if(StartRunningAndCompleteTimeAndState[3]==-2)
				{
					record.setState("Removed");
					record.setStartRunning(StartRunningAndCompleteTimeAndState[0]+"");
					record.setCompletedTime(StartRunningAndCompleteTimeAndState[1]+"");
				}
				else if(StartRunningAndCompleteTimeAndState[2]==1)
				{
					record.setState("Running ");
					record.setStartRunning(StartRunningAndCompleteTimeAndState[0]+"");
					long currentTime=System.currentTimeMillis()/1000;
					record.setCompletedTime(currentTime+"");
				}
				else
				{
					record.setState("Running");
					record.setStartRunning(StartRunningAndCompleteTimeAndState[0]+"");
					long currentTime=System.currentTimeMillis()/1000;
					record.setCompletedTime(currentTime+"");
				}
//				System.out.println("0:"+StartRunningAndCompleteTimeAndState[0]);
//				System.out.println("1:"+StartRunningAndCompleteTimeAndState[0]);
//				System.out.println("2:"+StartRunningAndCompleteTimeAndState[0]);
//				System.out.println("3:"+StartRunningAndCompleteTimeAndState[0]);
//				System.out.println(record.getStartRunning());
//				System.out.println(record.getCompletedTime());
				record.setPercentage(percentage);
	
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
		return all;
	}
	public List<DirectionStatis> queryDirection(String TableName) throws Exception{
		List<DirectionStatis> all= new ArrayList<DirectionStatis>();
		String sql="SELECT * FROM "+TableName;
//		System.out.println(sql);
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		try{
			dbc=new DataBaseConnection(TableName);
			pstmt=dbc.getConnection().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			Map<String, Integer> putMap = new HashMap<String, Integer>();
			Map<String, Integer> getMap = new HashMap<String, Integer>();
			String[] sourceToDirectionArray ={
					"BUAAtoCNIC",
					"BUAAtoUCSD", 
					"BUAAtoWISC", 
					"CNICtoBUAA",
					"CNICtoUCSD",
					"CNICtoWISC",
					"UCSDtoBUAA",
					"UCSDtoCNIC",
					"UCSDtoWISC",
					"WISCtoBUAA",
					"WISCtoCNIC",
					"WISCtoUCSD"};
			for(int i=0; i<sourceToDirectionArray.length; i++){
				putMap.put(sourceToDirectionArray[i], 0);
				getMap.put(sourceToDirectionArray[i], 0);
			}
			while(rs.next()){
				String source = rs.getString(4);
				String destination = rs.getString(6);
				String direction = rs.getString(3);
				//System.out.println(rs.getString(2));
				if(direction.equals("PUT")){
					String sourceToDestination = source + "to" + destination;
					putMap.put(sourceToDestination, putMap.get(sourceToDestination)+1);
//					System.out.println(sourceToDestination);
				}
				else{
					String sourceToDestination = source + "to" + destination;
					getMap.put(sourceToDestination, getMap.get(sourceToDestination)+1);
//					System.out.println(sourceToDestination);
				}
			}
			for(int i=0; i<12; i++){
				DirectionStatis directionStatis = new DirectionStatis();
				directionStatis.setSourceToDestination(sourceToDirectionArray[i]);
				directionStatis.setPutNumber(putMap.get(sourceToDirectionArray[i]));
				directionStatis.setGetNumber(getMap.get(sourceToDirectionArray[i]));
				all.add(directionStatis);
			}
			/*
			for(int i=0; i<putNumberArray.length; i++){
				System.out.println(putNumberArray[i]);
				System.out.println(getNumberArray[i]);	
			}
			*/
			rs.close();
			pstmt.close();
			System.out.println("Query Direction");
		}
		catch(Exception e){
			throw new Exception("queryDirection Error!");
		}
		finally{
			dbc.close();
		}
		return all;
	}
	public int getCompleteNumber(long id,String TableName,String username,long experimentId) throws Exception{
		int result=0;
		String sql="SELECT * FROM "+TableName+" WHERE id="+experimentId+" AND exp_id="+id;
//		System.out.println(sql);
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		try{
			dbc=new DataBaseConnection(TableName);
			pstmt=dbc.getConnection().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
//				System.out.println(id);
				if(rs.getInt(3)!=0)
				{
//					System.out.println(result);
					if(rs.getString(5).equals("Completed"))
						result++;
				}
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
	
	public long[] getStartRunningAndCompleteTime(long id,long experimentId,int repeat) throws Exception{
		String sql="SELECT * FROM idplExperiment WHERE id="+experimentId+" AND exp_id="+id;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		long[] StartRunningAndCompleteTimeAndState = {0,0,0,0};
		try{
			
			dbc=new DataBaseConnection("idplExperiment");
			pstmt=dbc.getConnection().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				if(rs.getInt(3)==1)
				{
//					System.out.println("Get Repeat1");
					if(rs.getString(5).equals("Completed"))
					{
//						System.out.println("Get Repeat1 Complete");
						StartRunningAndCompleteTimeAndState[0]=rs.getLong(7);
						StartRunningAndCompleteTimeAndState[2]=2;
					}
					else if(rs.getString(5).equals("Running"))
					{
						StartRunningAndCompleteTimeAndState[0]=rs.getLong(7);
						StartRunningAndCompleteTimeAndState[2]=1;
					}
					else if(rs.getString(5).equals("Idle"))
						StartRunningAndCompleteTimeAndState[2]=0;
					else if(rs.getString(5).equals("Waiting"))
						StartRunningAndCompleteTimeAndState[2]=-1;
					else if(rs.getString(5).equals("Removed"))
					{
//						System.out.println("equal");
						if(rs.getString(7)==null)
							StartRunningAndCompleteTimeAndState[2]=-3;   
						else if(!rs.getString(7).equals("0"))
						{
							StartRunningAndCompleteTimeAndState[0]=rs.getLong(7);
							StartRunningAndCompleteTimeAndState[2]=-2;
//							System.out.println("if");
						}
						else
						{
//							System.out.println("else");
							StartRunningAndCompleteTimeAndState[2]=-3;       //when Idle or Waiting, remove 
						}
					}
				}
				if(rs.getInt(3)==repeat)
				{
//					System.out.println("Get Repeat"+repeat);
					if(rs.getString(5).equals("Completed"))
					{
//						System.out.println("Get Repeat"+repeat+" Complete");
						StartRunningAndCompleteTimeAndState[1]=rs.getLong(8);
						StartRunningAndCompleteTimeAndState[3]=2;
					}
					if(rs.getString(5).equals("Running"))
						StartRunningAndCompleteTimeAndState[3]=1;
					else if(rs.getString(5).equals("Idle"))
						StartRunningAndCompleteTimeAndState[3]=0;
					else if(rs.getString(5).equals("Waiting"))
						StartRunningAndCompleteTimeAndState[3]=-1;
					else if(rs.getString(5).equals("Removed"))
					{
						StartRunningAndCompleteTimeAndState[1]=rs.getLong(8);
						StartRunningAndCompleteTimeAndState[3]=-2;
					}
				}
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			throw new Exception("Query By Id Fail!");
		}
		finally{
			dbc.close();
		}
//		System.out.println("0:"+StartRunningAndCompleteTimeAndState[0]);
//		System.out.println("1:"+StartRunningAndCompleteTimeAndState[0]);
//		System.out.println("2:"+StartRunningAndCompleteTimeAndState[0]);
//		System.out.println("3:"+StartRunningAndCompleteTimeAndState[0]);
		return StartRunningAndCompleteTimeAndState;
	}
}
