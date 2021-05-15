package com.example.demo.model;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class TestModel implements Serializable {

	private int id;
	private String name;

	public TestModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
