package com.yash.rest.webservices.restfulwebservices.filter;

import com.fasterxml.jackson.annotation.JsonFilter;

//List of valid filters must be define on the bean
@JsonFilter("SomeBeanFilter")
public class SomeSampleBean {
	private String field1;
	private String field2;
	private String field3;

	public SomeSampleBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3;
	}

}
