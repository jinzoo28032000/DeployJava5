package com.example.ass.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(nullable = false, length = 255)
	private String name;
	@Column(length = 255)
	private String image;
	@Column(nullable = false, precision = 10)
	private int price;
	@Column(name = "created_date", nullable = false)
	private Date createdDate;
	@Column(nullable = false, precision = 10)
	private int available;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	@OneToMany(mappedBy = "product")
	private List<OrderDetail> orderDetails;

	public Product() {
		super();
	}

	public Product(int id, String name, String image, int price, Date createdDate, int available, Category category) {
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
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
