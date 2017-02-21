package com.idpl.dao;
import java.util.*;
public interface UserDAO {
	public void insert(User user, String TableName) throws Exception;
	public void update(User user, String TableName) throws Exception;
	public void delete(User user, String TableName) throws Exception;
	public User queryByName(String username, String TableName) throws Exception;
	public List<User> queryAll(String TableName) throws Exception;
	public String isUser(String username, String password, String TableName) throws Exception;
	public String hasExisted(String username, String TableName) throws Exception;
}

