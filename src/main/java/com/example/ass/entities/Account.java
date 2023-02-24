package com.example.ass.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.ass.util.EncrytedPasswordUtils;



@Entity
@Table(name = "accounts")
public class Account implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private Integer id;
	@Column(unique = true, nullable = false, length = 255)
	private String username;
	@Column(nullable = false, length = 255)
	private String password;
	@Column(nullable = false, length = 255)
	private String fullname;
	@Column(unique = true, nullable = false, length = 255)
	private String email;
	@Column(length = 255)
	private String photo;
	@Column(nullable = false, precision = 10)
	private int activated;
	@Column(nullable = false, precision = 10)
	private String admin;
	
	@OneToMany(mappedBy = "account")
	private List<Order> orders;

	public Account() {
		super();
	}

	public Account(Integer id, String username, String password, String fullname, String email, String photo,
			int activated, String admin) {
		super();
		this.id = id;
		this.username = username;
		this.password = EncrytedPasswordUtils.encrytePassword(password);
		this.fullname = fullname;
		this.email = email;
		this.photo = photo;
		this.activated = activated;
		this.admin = admin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = EncrytedPasswordUtils.encrytePassword(password);
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
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
