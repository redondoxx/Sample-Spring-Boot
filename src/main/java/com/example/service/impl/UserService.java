package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UserModel;
import com.example.repository.UserRepository;
import com.example.service.IUser;

@Service
public class UserService implements IUser {
	@Autowired
	UserRepository userRepo;

	@Override
	public UserModel saveUser(UserModel user) {
		return userRepo.save(user);
	}

	@Override
	public UserModel getOne(Long id) {
		return userRepo.findOne(id);
	}

	@Override
	public List<UserModel> getList() {
		return (List<UserModel>) userRepo.findAll();
	}

	@Override
	public boolean deleteUser(Long id) {
		if(userRepo.findOne(id) != null){
			userRepo.delete(id);
			return true;
		}
		return false;
	}

	@Override
	public UserModel updateUser(Long id, UserModel updateUser) {
		if(userRepo.findOne(id) != null){
			updateUser.setId(id);
			return userRepo.save(updateUser);
		}		
		return null;
	}
}
