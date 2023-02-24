package com.example.ass.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "orders")
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Account account;
	@Column(name = "create_date", nullable = false)
	private Date createDate;
	@Column(nullable = false, length = 255)
	private String address;
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;

	public Order() {
		super();
		this.orderDetails = new ArrayList<>();
	}

	public Order(int id, Account account, Date createDate, String address) {
		super();
		this.id = id;
		this.account = account;
		this.createDate = createDate;
		this.address = address;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getQuantity() {
		int quantity = 0;
		for (OrderDetail line : this.orderDetails) {
			quantity += 1;
		}
		return quantity;
	}

	public float getTotal() {
		float total = 0;
		for (OrderDetail line : this.orderDetails) {
			if (line != null) {
				total += line.getProduct().getPrice() * line.getQuantity();
			}
		}
		return total;
	}

	private OrderDetail findOrderDetailByProduct(int id) {
		for (OrderDetail line : this.orderDetails) {
			if (line.getProduct().getId() == id) {
				return line;
			}
		}
		return null;
	}

	public void addProduct(Product product, int quantity) {
		OrderDetail line = this.findOrderDetailByProduct(product.getId());

		if (line == null) {
			line = new OrderDetail();
			line.setQuantity(0);
			line.setProduct(product);
			this.orderDetails.add(line);
		}
		int newQuantity = line.getQuantity() + quantity;
		if (newQuantity <= 0) {
			this.orderDetails.remove(line);
		} else {
			line.setQuantity(newQuantity);
		}
	}

	public void removeProduct(Product product) {
		OrderDetail line = this.findOrderDetailByProduct(product.getId());
		if (line != null) {
			this.orderDetails.remove(line);
		}
	}
}
