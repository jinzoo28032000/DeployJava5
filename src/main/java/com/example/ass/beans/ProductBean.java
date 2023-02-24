package com.example.ass.beans;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.example.ass.entities.Category;

public class ProductBean {
	private int id;
	private String name;
	private MultipartFile image;
	private int price;
	private Date createdDate;
	private int available;
	private Category category;

	public ProductBean() {
		super();
	}

	public ProductBean(int id, String name, MultipartFile image, int price, Date createdDate, int available,
			Category category) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.createdDate = createdDate;
		this.available = available;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
