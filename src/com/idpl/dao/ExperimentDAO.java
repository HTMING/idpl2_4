package com.idpl.dao;
import java.util.*;
public interface ExperimentDAO {
	public long insert(Experiment experiment, String TableName) throws Exception;
	public void update(Experiment experiment, String TableName) throws Exception;
	public void submit(String TableName, Long experimentId) throws Exception;
	public void delete(long experimentId, String TableName) throws Exception;
	public Experiment queryById(long id, String TableName, String username) throws Exception;
	public List<Experiment> queryAll(String TableName, String username) throws Exception;
}
