package com.housingboard.dao;

import java.util.List;

import com.housingboard.model.Ads;

/**
 * @author nitish
 */
public interface AdsDao {
	
	
	//return Ads based on the search field entered
	
	public List<Ads> getSearchResults(String searchField);

}
