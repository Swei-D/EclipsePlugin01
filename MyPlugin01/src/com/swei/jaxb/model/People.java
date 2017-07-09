package com.swei.jaxb.model;

import java.util.List;

public class People implements Itree {
	private Long id;
	private String name;

	public People() {
	}
	
	public People(String name) {
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

	public void setChildren(List Children) {
	}

	public List getChildren() {
		return null;
	}

}
