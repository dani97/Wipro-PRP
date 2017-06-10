package com.wipro.hms.bean;

public class RentalPropertyBean {
	private int numbedrooms;
	private float rentalAmount;
	private String location;
	private String city;
	private String propertyId;
	public int getNumbedrooms() {
		return numbedrooms;
	}
	public void setNumbedrooms(int numbedrooms) {
		this.numbedrooms = numbedrooms;
	}
	public float getRentalAmount() {
		return rentalAmount;
	}
	public void setRentalAmount(float rentalAmount) {
		this.rentalAmount = rentalAmount;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	
}
