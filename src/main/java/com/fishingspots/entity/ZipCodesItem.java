package com.fishingspots.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Zip codes item.
 * @author JeevaG
 */
public class ZipCodesItem{

	@JsonProperty("distance")
	private double distance;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	@JsonProperty("zip_code")
	private String zipCode;

	/**
	 * Set distance.
	 *
	 * @param distance the distance
	 */
	public void setDistance(double distance){
		this.distance = distance;
	}

	/**
	 * Get distance double.
	 *
	 * @return distance
	 */
	public double getDistance(){
		return distance;
	}

	/**
	 * Set city.
	 *
	 * @param city the city
	 */
	public void setCity(String city){
		this.city = city;
	}

	/**
	 * Get city string.
	 *
	 * @return city
	 */
	public String getCity(){
		return city;
	}

	/**
	 * Set state.
	 *
	 * @param state the state
	 */
	public void setState(String state){
		this.state = state;
	}

	/**
	 * Get state string.
	 *
	 * @return state
	 */
	public String getState(){
		return state;
	}

	/**
	 * Set zip code.
	 *
	 * @param zipCode the zip code
	 */
	public void setZipCode(String zipCode){
		this.zipCode = zipCode;
	}

	/**
	 * Get zip code string.
	 *
	 * @return zipcode
	 */
	public String getZipCode(){
		return zipCode;
	}

	@Override
 	public String toString(){
		return 
			"ZipCodesItem{" + 
			"distance = '" + distance + '\'' + 
			",city = '" + city + '\'' + 
			",state = '" + state + '\'' + 
			",zip_code = '" + zipCode + '\'' + 
			"}";
		}
}