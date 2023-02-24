package com.example.ass.beans;

public class CategoryBean {
	private int id;
	private String name;
	public CategoryBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public CategoryBean() {
		super();
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
	
	
}
