package com.example.telecommicroservices.pojo;

/**
 * 
 * @author swathisanthosh
 *
 */
public class PhoneDetails {

/**
 * 
 * @param phoneNumber
 * @param countryCode
 * @param isActive
 */

	public PhoneDetails(String phoneNumber, String countryCode, Boolean isActive) {
		//super();
		this.phoneNumber = phoneNumber;
		this.countryCode = countryCode;
		this.isActive = isActive;
	}
	/**
	 * 
	 */
	private String phoneNumber;
	
	/**
	 * 
	 */
	private String countryCode;
	
	/**
	 * 
	 */
	private Boolean isActive ;
	
	/**
	 * 
	 * @return
	 */
	
    public String getPhoneNumber() {
		return phoneNumber;
	}
    
    /**
     * 
     * @param phoneNumber
     */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCountryCode() {
		return countryCode;
	}
	
	/**
	 * 
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	/**
	 * 
	 * @return
	 */
	public Boolean getIsActive() {
		return isActive;
	}
	/**
	 * 
	 * @param isActive
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneDetails other = (PhoneDetails) obj;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
}
