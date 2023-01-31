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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"})
})
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(initialValue = 10001, name = "usr_seq", sequenceName = "usr_sequence")
	private Integer uid;
	
	@Column(length = 20,name = "first_name")
	@NotBlank(message = "first name can't be blank") //it check string is not null and greater than zero
	private String firstName;
	
	@Column(length = 20,name = "last_name")
	@NotBlank(message = "last name  can't be blank")
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(length = 35)
	@Email(message = "Please provide a valid email id")
	@NotBlank(message = "email id  can't be blank")
	private String email;
	
	private LocalDate dob;
	@NotBlank(message = "password can't be blank")
	private String password;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Address> address;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Users(Integer uid, String first_Name, String last_Name, Gender gender,LocalDate dob,String password) {
		super();
		this.uid = uid;
		this.firstName = first_Name;
		this.lastName = last_Name;
		this.gender = gender;
		this.dob = dob;
		this.password = password;
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
	
	

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [first_Name=" + firstName + ", last_Name=" + lastName + ", address=" + address + ", gender="
				+ gender + ", email=" + email + ",dob = "+ dob + ", password ="+ password +"]";
	}


	
	
}
