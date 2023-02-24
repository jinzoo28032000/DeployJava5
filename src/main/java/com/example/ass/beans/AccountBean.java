package com.example.ass.beans;

import org.springframework.web.multipart.MultipartFile;

public class AccountBean {
	private String username;
	private String fullname;
	private String password;
	private String email;
	private MultipartFile photo;
	private int activated;
	private String admin;

	public AccountBean(String username, String fullname, String password, String email, MultipartFile photo,
			int activated, String admin) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.email = email;
		this.photo = photo;
		this.activated = activated;
		this.admin = admin;
	}

	public AccountBean() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public int getActivated() {
		return activated;
	}

	public void setActivated(int activated) {
		this.activated = activated;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

}
