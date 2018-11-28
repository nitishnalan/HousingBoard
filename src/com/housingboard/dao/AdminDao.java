package com.housingboard.dao;

import java.util.List;

import com.housingboard.model.Login;
import com.housingboard.model.Member;
import com.housingboard.model.UserModel;

public interface AdminDao {
	public boolean deleteUser(int usId);
	public List<UserModel> AdminlistAllUsers();
	public Member loginUser(Login loginModel);
}
