package com.housingboard.dao;

import java.util.List;

import com.housingboard.model.Ads;

/**
 * @author nitish
 */
public interface AdsDao {
	
	
	//return Ads based on the search field entered
	
	public List<Ads> getSearchResults(String searchField);

	public List<Ads> getSearchResultsByPage(String searchFieldController, int pageid, int total);

	public boolean createNewAd(Ads adModel);

}
