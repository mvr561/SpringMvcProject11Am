package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.model.User;

public interface IUserService {
	
	public Integer saveUser(User us);
	public void updateUser(User us);
	public void deleteUser(Integer id);
	public User getUserById(Integer id);
	public List<User> getAllUsers();


}
