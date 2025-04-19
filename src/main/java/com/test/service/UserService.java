package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.User;

public interface UserService {

	
	public List<User> getUsers();
	
	public User saveUser(User user);
	
	public User getSingleUser(int id);
	
	public void deleteUser(int id);
	
	public User updateUser(User user,int id);
	public User updateUserPartial(int id, Map<String, Object> updates); 

}
