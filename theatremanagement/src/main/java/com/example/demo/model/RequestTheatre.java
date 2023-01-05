package com.example.demo.model;





import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.entity.Address;


public class RequestTheatre {
	
	@NotBlank(message = "Theatrename is mandatory")
	@Size(min = 4, max = 15)
	private String theatrename;
	
	@NotBlank
	@NotBlank(message = "Address is mandatory")
	private Address address;
	
	@NotBlank(message = "ShowDetails is mandatory")
	private String listOfShow;

	public String getTheatrename() {
		return theatrename;
	}

	public void setTheatrename(String theatrename) {
		this.theatrename = theatrename;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getListOfShow() {
		return listOfShow;
	}

	public void setListOfShow(String listOfShow) {
		this.listOfShow = listOfShow;
	}

}
