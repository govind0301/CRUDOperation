package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(initialValue = 2001, name = "addr_seq", sequenceName = "addr_sequence")
	private Integer id;
	@Column(length=100)
	private String houseNo;
	@Column(length=50)
	private String streetName;
	@NotBlank
	@Column(length=20)
	private String city;
	@NotBlank
	@Column(length=20)
	private String country;
	@NotBlank
	@Column(length=20)
	private String state;
	@NotBlank
	@Column(length=20)
	private String district;
	private Integer pincode;
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
	@ManyToOne
	@JoinColumn(name="user_id",nullable = false)
	@JsonIgnore
	private Users user;
	
	public Address(String houseNo, String streetName, String city, String country, String state, String district,
			Integer pincode,Users user) {
		super();
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
		this.country = country;
		this.state = state;
		this.district = district;
		this.pincode = pincode;
		this.user = user;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", houseNo=" + houseNo + ", streetName=" + streetName + ", city=" + city
				+ ", country=" + country + ", state=" + state + ", district=" + district + ", pincode=" + pincode + "]";
	}
	
	
	
}
