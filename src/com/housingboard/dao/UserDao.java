package com.housingboard.dao;

import com.housingboard.model.LeasingOffice;
import com.housingboard.model.Login;
import com.housingboard.model.Register;
import com.housingboard.model.UserModel;

/**
 * @author nitish
 */
public interface UserDao {
	
	public UserModel loginUser(Login login);
	public boolean register(UserModel leasingOffice);
		
}
