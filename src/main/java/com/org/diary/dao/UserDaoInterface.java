package com.org.diary.dao;

import java.util.List;

import com.org.diary.entities.Entry;
import com.org.diary.entities.User;

public interface UserDaoInterface {

	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public User findById(int id);
	public List<User> findAll();
	public User findByUsername(String username);
	
}
