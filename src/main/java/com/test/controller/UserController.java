package com.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.User;
import com.test.service.UserService;

@RestController
public class UserController {
@Autowired
	private UserService userService;

@PostMapping("/user")
  public User createUser(@RequestBody User user)
  {
	 return userService.saveUser(user);
  }
@GetMapping("/users")
public List<User> getAll()
{
	List<User> users = userService.getUsers();
	return users;
}
@GetMapping("/users/{id}")
public User singleUser(@PathVariable("id") int id)
{
	User singleUser = userService.getSingleUser(id);
	return singleUser;
}
@PutMapping("/user/{id}")
public User updatedUser(@PathVariable("id") int id,@RequestBody User user)
{
	User updateUser = userService.updateUser(user, id);
	return updateUser;
}
@DeleteMapping("/user")
public void deleteUser(@PathVariable("id") int id)
{
	userService.deleteUser(id);
}
@PatchMapping("/user/{id}")
public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody Map<String, Object> updates) {
    User updatedUser = userService.updateUserPartial(id, updates);
    return ResponseEntity.ok(updatedUser);
}

}
