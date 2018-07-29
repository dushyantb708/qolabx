package com.qolabx.beans;

public class Company {

	private Long companyId;
	private String companyName;
	private String aboutUs;
	private String address;
	private String city;
	private String state;
	private String country;

	public Company(Long companyId, String companyName, String aboutUs, String address, String city, String state,
			String country) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.aboutUs = aboutUs;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAboutUs() {
		return aboutUs;
	}

	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", aboutUs=" + aboutUs
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
}
