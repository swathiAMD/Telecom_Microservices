package com.example.telecommicroservices.pojo;

import java.util.HashSet;
import java.util.List;

public class Customer {


/**
 * 
 * @param fullName
 * @param listofphonenos
 */
	public Customer(String fullName, HashSet listofphonenos) {
		super();
		this.fullName = fullName;
		this.listofphonenos = listofphonenos;
	}
	
	/**
	 * 
	 */
	
	private String fullName;
	
	/**
	 * 
	 */
	private HashSet<PhoneDetails> listofphonenos;
	
	/**
	 * 
	 * @return
	 */
	
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * 
	 * @param fullName
	 */
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public HashSet<PhoneDetails> getListofphonenos() {
		return listofphonenos;
	}
	
	/**
	 * 
	 * @param listofphonenos
	 */
	
	public void setListofphonenos(HashSet<PhoneDetails> listofphonenos) {
		this.listofphonenos = listofphonenos;
	}
	
	/**
	 * 
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((listofphonenos == null) ? 0 : listofphonenos.hashCode());
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
		Customer other = (Customer) obj;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (listofphonenos == null) {
			if (other.listofphonenos != null)
				return false;
		} else if (!listofphonenos.equals(other.listofphonenos))
			return false;
		return true;
	}
	
	
	
	
}
