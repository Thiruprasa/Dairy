package com.org.diary.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.diary.dao.EntryDaoInterface;
import com.org.diary.entities.Entry;
@Component
public class EntryBussinessInterfaceImpl implements EntryBussinessInterface {

	@Autowired
	private EntryDaoInterface  entryDaoInterface;

	public EntryDaoInterface getEntryDaoInterface() {
		return entryDaoInterface;
	}

	public void setEntryDaoInterface(EntryDaoInterface entryDaoInterface) {
		this.entryDaoInterface = entryDaoInterface;
	}

	public void save(Entry entry) {
	
		entryDaoInterface.save(entry);
		
	}

	public void delete(Entry entry) {
		entryDaoInterface.delete(entry);
	}

	public Entry findById(int id) {
		
		return entryDaoInterface.findById(id);
	}

	public List<Entry> findAll() {
		
		return entryDaoInterface.findAll();
	}

	public void update(Entry entry) {
		entryDaoInterface.update(entry);
		
	}

	public List<Entry> findByUserId(int id) {
		
		return entryDaoInterface.findByUserId(id);
	}
	
}
