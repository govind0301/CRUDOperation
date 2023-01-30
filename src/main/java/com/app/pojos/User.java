package com.app.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer uid;
	@Column(length = 20,name = "first_name")
	@NotBlank //it check string is not null and greater than zero
	private String firstName;
	@Column(length = 20,name = "last_name")
	@NotBlank
	private String lastName;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(length = 35)
	@Email
	@NotBlank
	private String email;
	private LocalDate dob;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Address> address;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(Integer uid, String first_Name, String last_Name, Gender gender,LocalDate dob) {
		super();
		this.uid = uid;
		this.firstName = first_Name;
		this.lastName = last_Name;
		this.gender = gender;
		this.dob = dob;
	}


	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_Name) {
		this.firstName = first_Name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last_Name) {
		this.lastName = last_Name;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
		for(Address a : address)
		{
			a.setUser(this);
		}
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

	
	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	@Override
	public String toString() {
		return "User [first_Name=" + firstName + ", last_Name=" + lastName + ", address=" + address + ", gender="
				+ gender + ", email=" + email + ",dob = "+ dob + "]";
	}


	
	
}
