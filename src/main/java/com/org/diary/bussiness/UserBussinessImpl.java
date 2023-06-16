package com.org.diary.bussiness;

import java.util.List;

import org.dom4j.util.UserDataAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.diary.dao.UserDaoInterface;
import com.org.diary.entities.User;
@Component
public class UserBussinessImpl implements UserBussinessInterface {

	@Autowired
	private UserDaoInterface daoInterface;
	
	
	public UserDaoInterface getDaoInterface() {
		return daoInterface;
	}

	public void setDaoInterface(UserDaoInterface daoInterface) {
		this.daoInterface = daoInterface;
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		daoInterface.save(user);

	}

	public void update(User user) {
		// TODO Auto-generated method stub
        daoInterface.update(user);
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
       daoInterface.delete(user);
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return daoInterface.findById(id);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return daoInterface.findAll();
	}

	public User findByUsername(String username) {
		return daoInterface.findByUsername(username);
	}
   
	

}
