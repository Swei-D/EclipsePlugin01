package com.swei.jaxb.model;

import java.util.ArrayList;
import java.util.List;

public class City implements Itree{
	private Long id;
	private String name;
	
	public City() {
	}
	
	public City(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List getChildren() {
		return children;
	}
	public void setChildren(List children) {
		this.children = children;
	}
	private List children = new ArrayList<>();
	
	
	
}
