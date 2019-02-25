package com.revature.beans;

public class Category {
	private int c_id;
	private String name;
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [c_id=" + c_id + ", name=" + name + "]";
	}
	public Category() {
		super();
	}
	public Category(int c_id, String name) {
		super();
		this.c_id = c_id;
		this.name = name;
	}
	public Category(String name) {
		super();
		this.name = name;
	}
	
	
}
