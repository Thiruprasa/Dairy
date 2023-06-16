package com.org.diary.dao;

import java.util.List;

import com.org.diary.entities.Entry;
import com.org.diary.entities.User;

public interface EntryDaoInterface {

	public void save(Entry entry);
	public void update(Entry entry);
	public void delete(Entry entry);
	public Entry findById(int id);
	public List<Entry> findAll();
	public List<Entry> findByUserId(int id);
}
