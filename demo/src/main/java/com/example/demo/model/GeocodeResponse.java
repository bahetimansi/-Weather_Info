package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "geocode_response")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeocodeResponse {

	@Column(name = "zip")
	private String zip;

	@Column(name = "name")
	private String name;

	@Column(name = "lat")
	private double lat;

	@Column(name = "lon")
	private double lon;

	@Column(name = "country")
	private String country;

}
