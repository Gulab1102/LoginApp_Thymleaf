package com.loginapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	

	private String fullname;
	
	private String email;
	
	private String address;
	
	private String qualification;
	
	private String password;
	
	private String role;
	
	
	

	public User(int id, String fullname, String email, String address, String qualification, String password,
			String role) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.qualification = qualification;
		this.password = password;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", email=" + email + ", address=" + address
				+ ", qualification=" + qualification + ", password=" + password + "]";
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
