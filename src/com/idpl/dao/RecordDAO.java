package com.idpl.dao;
import java.util.*;
public interface RecordDAO {
	public long insert(Record record, String TableName) throws Exception;
	public void update(Record record, String TableName, long recordId, long experimentId) throws Exception;
	public void delete(long recordId, String TableName, long experimentId) throws Exception;

	/*
	public Record queryById(long id, String TableName, String username, long experimentId) throws Exception;
	 */
	public Record queryById(long experimentId, String TableName) throws Exception;
	public Record queryById1(long id,String TableName,String username,long experimentId) throws Exception;
	public List<Record> queryAll(String TableName, String username, long experimentId) throws Exception;
	public List<DirectionStatis> queryDirection(String TableName) throws Exception;
}
