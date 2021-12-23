package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.model.UserModel;
import com.repository.UserModelRepository;

@Service
public class UserModelService {

	@Autowired
	private UserModelRepository userModelRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public boolean addUserModel(UserModel userModel) {
		userModel.setActive(true);
		userModel.setRole("customer");
		if (userModelRepository.findById(userModel.getEmail()).orElse(null) != null) {
			return false;
		}
		userModelRepository.save(userModel);
		return true;
	}

	public boolean updateUserModel(UserModel userModel) {

		UserModel user = userModelRepository.findById(userModel.getEmail()).orElse(null);
		if (user == null) {
			return false;
		}
		user.setUsername(userModel.getUsername());
		user.setMobileNumber(userModel.getMobileNumber());
		user.setAddress(userModel.getAddress());
		user.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
		userModelRepository.save(user);
		return true;
	}

	public boolean checkUser(UserModel userModel) {
		UserModel user = userModelRepository.findById(userModel.getEmail()).orElse(null);
		if (user == null) {
			return false;
		}
		if (user.getPassword().equals(userModel.getPassword())) {
			return true;
		}
		return false;
	}

	public UserModel getUserModel(String email) {
		UserModel user = userModelRepository.findById(email).orElse(null);

		return user;
	}

	public UserModel extractUserModel(String email) {
		UserModel userModel = userModelRepository.findById(email).orElse(null);
		return userModel;
	}

}
