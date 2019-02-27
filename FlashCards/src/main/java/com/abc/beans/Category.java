package com.abc.beans;

public class Category {
	
	private int categoryId;
	private String name;
	
	
	public Category() {
		super();
	}
	
	public Category(int categoryId, String name) {
		this.categoryId = categoryId;
		this.name = name;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryid(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
