package com.aneesha.io.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aneesha.io.dao.UserRepository;
import com.aneesha.io.pojo.User;
import com.aneesha.io.pojo.UserRequest;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	private final ModelMapper modelMapper;
	
	public UserService(ModelMapper modelMapper) {
		this.modelMapper=modelMapper;
	}
	
	//	get all users
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//	Create user
	public User createUser(UserRequest userRequest) {
		User user=modelMapper.map(userRequest, User.class);
		return userRepository.save(user);
	}
	
	//get user by id
	
	 public User getUserById(Long id) {
	     return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
	 }
	 
	 //update user
	 public User updateUser(Long id, User userDetails) {
		 User user = getUserById(id);
		 user.setName(userDetails.getName());
		 user.setEmail(userDetails.getEmail());
		 return userRepository.save(user);
	 }
	 
	 //delete
	 public void deleteUser(Long id) {
		 userRepository.deleteById(id);
	 }
}
