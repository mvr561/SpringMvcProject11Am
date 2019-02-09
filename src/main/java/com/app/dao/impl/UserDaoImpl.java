package com.app.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private HibernateTemplate ht;

	
	public Integer saveUser(User us) {
		
		return (Integer) ht.save(us);
	}

	
	public void updateUser(User us) {
		
     ht.update(us);
	}


	public void deleteUser(Integer id) {
		
		ht.delete(new User(id));
		
	}

	
	public User getUserById(Integer id) {
		
		return ht.get(User.class, id);
	}

	
	public List<User> getAllUsers() {
		
		return  ht.loadAll(User.class);
	}


	
}
