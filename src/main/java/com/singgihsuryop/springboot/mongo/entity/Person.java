package com.singgihsuryop.springboot.mongo.entity;

import java.io.Serializable;

import javax.persistence.Id;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\"=\"");
		builder.append(id);
		builder.append("\", \"name\"=\"");
		builder.append(name);
		builder.append("\", \"age\"=\"");
		builder.append(age);
		builder.append("\"}");
		return builder.toString();
	}
	

}
