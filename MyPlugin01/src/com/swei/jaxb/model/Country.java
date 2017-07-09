package com.swei.jaxb.model;

import java.util.ArrayList;
import java.util.List;

public class Country implements Itree{
	private Long id;
	private String name;
	private List children = new ArrayList<>();
	
	public Country() {
	}
	
	public Country(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setChildren(List Children) {
		this.children = Children;
	}

	public List getChildren() {
		return children;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
