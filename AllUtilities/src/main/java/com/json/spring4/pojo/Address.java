package com.json.spring4.pojo;

import com.fasterxml.jackson.annotation.JsonView;
import com.json.spring4.service.Profile;

public class Address {
	//Updae
	@JsonView(Profile.FamilyView.class)
	private String houseNo;
	@JsonView(Profile.FriendsView.class)
	private String city;
	@JsonView(Profile.PublicView.class)
	private String country;
	public Address(String houseNo, String city, String country) {
		this.houseNo = houseNo;
		this.city = city;
		this.country = country;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
