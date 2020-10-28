package com.fishingspots.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Zip codes by radius.
 * @author JeevaG
 */
public class ZipCodesByRadius{

	@JsonProperty("zip_codes")
	private List<ZipCodesItem> zipCodes;

	/**
	 * Set zip codes.
	 *
	 * @param zipCodes the zip codes
	 */
	public void setZipCodes(List<ZipCodesItem> zipCodes){
		this.zipCodes = zipCodes;
	}

	/**
	 * Get zip codes list.
	 *
	 * @return zipcodes list
	 */
	public List<ZipCodesItem> getZipCodes(){
		return zipCodes;
	}

	@Override
 	public String toString(){
		return 
			"ZipCodesByRadius{" + 
			"zip_codes = '" + zipCodes + '\'' + 
			"}";
		}
}