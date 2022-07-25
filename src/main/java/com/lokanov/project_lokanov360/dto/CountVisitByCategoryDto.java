package com.lokanov.project_lokanov360.dto;

public class CountVisitByCategoryDto {

	private Long count;
	private String name; 

	public CountVisitByCategoryDto(String name, Long count) {
	    this.name = name;
	    this.count = count;
	}

	public  Long getCount() {
		return count;
	}

	public void setCount( Long count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
