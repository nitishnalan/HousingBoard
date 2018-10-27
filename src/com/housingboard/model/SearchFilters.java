package com.housingboard.model;
/**
 * @author nitish
 */
public class SearchFilters {
	
	private String adsLeasingType;
	private String[] adsApartmentType;
	private String[] adsPreferences;
	private boolean adsSharing;
	
	public SearchFilters(String adsLeasingType, String[] adsApartmentType, String[] adsPreferences,
			boolean adsSharing) {
		//super();
		this.adsLeasingType = adsLeasingType;
		this.adsApartmentType = adsApartmentType;
		this.adsPreferences = adsPreferences;
		this.adsSharing = adsSharing;
	}

	public String getAdsLeasingType() {
		return adsLeasingType;
	}

	public void setAdsLeasingType(String adsLeasingType) {
		this.adsLeasingType = adsLeasingType;
	}

	public String[] getAdsApartmentType() {
		return adsApartmentType;
	}

	public void setAdsApartmentType(String[] adsApartmentType) {
		this.adsApartmentType = adsApartmentType;
	}

	public String[] getAdsPreferences() {
		return adsPreferences;
	}

	public void setAdsPreferences(String[] adsPreferences) {
		this.adsPreferences = adsPreferences;
	}

	public boolean isAdsSharing() {
		return adsSharing;
	}

	public void setAdsSharing(boolean adsSharing) {
		this.adsSharing = adsSharing;
	}
	
	
	
}
