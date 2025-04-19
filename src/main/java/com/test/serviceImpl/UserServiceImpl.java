package com.test.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.User;
import com.test.exceptions.ResourceNotFoundException;
import com.test.repository.UserRepository;
import com.test.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
              Iterable<User> list = userRepository.findAll();
			return (List<User>) list;
             
              
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getSingleUser(int id) {
	    return userRepository.findById(id)
	                         .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
	}


	@Override
	public void deleteUser(int id) {
		  
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User user, int id) {
		 User existUser =  userRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
		 if(existUser!=null)
		 {
			 // Update the existing user's fields with the new data
			    existUser.setName(user.getName());
			    existUser.setDescription(user.getDescription());
			    existUser.setPrice(user.getPrice());
			    existUser.setQuantity(user.getQuantity());

			    // Save the updated user back to the database
			    return userRepository.save(existUser);
		 }
		 return null;
	}
	
	public User updateUserPartial(int id, Map<String, Object> updates) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check and update fields manually
        if (updates.containsKey("name")) {
            user.setName((String) updates.get("name"));
        }
        if (updates.containsKey("description")) {
            user.setDescription((String) updates.get("description"));
        }
        if (updates.containsKey("price")) {
            user.setPrice((Double) updates.get("price"));
        }
        if (updates.containsKey("quantity")) {
            user.setQuantity((Integer) updates.get("quantity"));
        }

        return userRepository.save(user);
    }

}
