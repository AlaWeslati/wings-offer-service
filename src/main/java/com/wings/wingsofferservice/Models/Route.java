package com.wings.wingsofferservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
public class Route {
	private long id;
	private String depar_gov;
	private String adr_departure;
	private String arri_gov;
	private String adr_arrival;
	private double longitude;
	private double latitude;
	private String description;

	public Route() {
	}

	public Route(String depar_gov, String adr_departure, String arri_gov, String adr_arrival) {
		this.depar_gov = depar_gov;
		this.adr_departure = adr_departure;
		this.arri_gov = arri_gov;
		this.adr_arrival = adr_arrival;
	}
}
