package com.org.diary.bussiness;

import java.util.List;

import com.org.diary.entities.Entry;

public interface EntryBussinessInterface {

	public void save(Entry entry);
	public void update(Entry entry);
	public void delete(Entry entry);
	public Entry findById(int id);
	public List<Entry> findAll();
	public List<Entry> findByUserId(int id);
}
