package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer uid;
	@Column(length = 20)
	@NotBlank //it check string is not null and greater than zero
	private String first_Name;
	@Column(length = 20)
	@NotBlank
	private String last_Name;
	@Column(length = 50)
	private String address;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(length = 35)
	@Email
	@NotBlank
	private String email;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(Integer uid, String first_Name, String last_Name, String address, Gender gender) {
		super();
		this.uid = uid;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.address = address;
		this.gender = gender;
	}


	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [first_Name=" + first_Name + ", last_Name=" + last_Name + ", address=" + address + ", gender="
				+ gender + ", email=" + email + "]";
	}


	
	
}
