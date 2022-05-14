package com.springboot.friend.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Friends")
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonProperty("fname")
	private String firstName;
	@JsonProperty("lname")
	private String lasstName;
	private int age;
	@JsonIgnore
	private boolean gender;
	
	///
//	@Embedded
//	private Address address;
//	
//
//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//	
//	////
	@OneToMany(cascade=javax.persistence.CascadeType.ALL)
	List<Address> addresses;
	
	
	public List<Address> getAddress() {
		return addresses;
	}
	public void setAddress(List<Address> address) {
		this.addresses = address;
	}
	public Friend() {

	}
	public Friend(int id, String firstName, String lasstName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lasstName = lasstName;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasstName() {
		return lasstName;
	}
	public void setLasstName(String lasstName) {
		this.lasstName = lasstName;
	}



}
