package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.UserModel;
import com.repository.UserModelRepository;

@Service
public class UserModelService {

	@Autowired
	private UserModelRepository userModelRepository;


	public boolean addUserModel(UserModel userModel) {
		userModel.setActive(false);
		userModel.setRole("customer");
		if(userModelRepository.findById(userModel.getEmail()).orElse(null) != null) {
			return false;
		}
		userModelRepository.save(userModel);
		return true;
	}
	
	
	public boolean checkUser(UserModel userModel) {
		UserModel user = userModelRepository.findById(userModel.getEmail()).orElse(null);
		if(user == null) {
			return false;
		}
		if(user.getPassword().equals(userModel.getPassword())) {
			return true;
		}
		return false;	
	}
	
	public UserModel getUserModel(String email) {
		UserModel user = userModelRepository.findById(email).orElse(null);
		
		return user;
	}
	
	public UserModel extractUserModel(HttpServletRequest request) {
		HttpSession session =  request.getSession();
		String email = (String)session.getAttribute("email");
        UserModel userModel = userModelRepository.findById(email).orElse(null);    
		return userModel;
	}
	
}
