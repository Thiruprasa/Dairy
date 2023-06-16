package com.org.diary.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.org.diary.entities.Entry;
import com.org.diary.entities.User;
@Component
public class UserInterfaceImpl implements UserDaoInterface {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional(readOnly = false)
	public void save(User user) {
		// To save the user into data base
		hibernateTemplate.save(user);

	}
	@Transactional(readOnly = false)
	public void update(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(user);
		
	}
	@Transactional(readOnly = false)
	public void delete(User user) {
		// To delete the user
		hibernateTemplate.delete(user);

	}

	public User findById(int id) {
		// To retrive the user by using their ID
		return hibernateTemplate.get(User.class, id);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		hibernateTemplate.loadAll(User.class);
		return hibernateTemplate.loadAll(User.class);
		}
   public User findByUsername(String username) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user = null;
		try {
			user = (User) hibernateTemplate.findByCriteria(criteria).get(0);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     	return user;
	}

}
	


