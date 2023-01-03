package com.example.demo.model;

public class FileResponse {
	
	
	private String id;

	private String type;

	private String name;
	
	private String data;
	
	
	public String getdata() {
		return data;
	}

	public void setdata(String data) {
		this.data = data;
	}

	public FileResponse() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public FileResponse(String id, String type, String name, String data) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
