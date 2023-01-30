package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "THEATRE")
public class Theatre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;

	@Column(name = "THEATRENAME")

	private String theatrename;

	
	
	@Column(name = "NUMBER_OF_ROWS")
	private long numberofrows;
	
	@Column(name = "NUMBER_OF_SEATS")
	private long numberofseats;
	
	@OneToMany(mappedBy = "theatrename", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ShowDetails> listOfShow;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "address_id")

	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

//	public Theatre(String theatrename, Address address, List<ShowDetails> listOfShow) {
//		super();
//
//		this.theatrename = theatrename;
//		this.address = address;
//		this.listOfShow = listOfShow;
//	}

	public Theatre() {
		super();
		
	}

	public long getNumberofrows() {
		return numberofrows;
	}

	public void setNumberofrows(long numberofrows) {
		this.numberofrows = numberofrows;
	}

	public long getNumberofseats() {
		return numberofseats;
	}

	public void setNumberofseats(long numberofseats) {
		this.numberofseats = numberofseats;
	}

	

	

	

}
