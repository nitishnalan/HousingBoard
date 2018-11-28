package com.housingboard.dao;

import java.util.List;

import com.housingboard.model.Ads;
import com.housingboard.model.LeasingOffice;
import com.housingboard.model.Login;
import com.housingboard.model.Register;
import com.housingboard.model.UserModel;

/**
 * @author nitish
 */
public  interface UserDao {
	public UserModel loginUser(Login login);
	public boolean register(UserModel leasingOffice);
	public boolean updateMember(UserModel memberReigster);
	public UserModel getRecordByName(String name);
	public List<UserModel> dataretrieve(int id);
	public boolean createPage(String description, String url,int id);
}
