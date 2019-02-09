package com.app.dao;

import java.util.List;
import java.util.Set;

import com.app.model.User;

public interface IUserDao {
	public Integer saveUser(User us);
	public void updateUser(User us);
	public void deleteUser(Integer id);
	public User getUserById(Integer id);
	public List<User> getAllUsers();


}
