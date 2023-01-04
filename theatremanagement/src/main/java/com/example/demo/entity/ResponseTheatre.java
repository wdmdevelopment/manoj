package com.example.demo.entity;

import java.util.List;

import com.example.demo.model.Address;
import com.example.demo.model.ShowDetails;

public class ResponseTheatre {

	private String theatrename;

	private Address address;

	private List<ShowDetails> listOfShow;

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

	public List<ShowDetails> getListOfShow() {
		return listOfShow;
	}

	public void setListOfShow(List<ShowDetails> listOfShow) {
		this.listOfShow = listOfShow;
	}

}
