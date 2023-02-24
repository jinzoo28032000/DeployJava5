package com.example.ass.beans;

public class OrderDetailBean {
	private OrderBean order;
	private ProductBean product;
	private float price;
	private int quantity;

	public OrderDetailBean(OrderBean order, ProductBean product, float price, int quantity) {
		super();
		this.order = order;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public OrderDetailBean() {
		super();
	}

	public OrderBean getOrder() {
		return order;
	}

	public void setOrder(OrderBean order) {
		this.order = order;
	}

	public ProductBean getProduct() {
		return product;
	}

	public void setProduct(ProductBean product) {
		this.product = product;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
