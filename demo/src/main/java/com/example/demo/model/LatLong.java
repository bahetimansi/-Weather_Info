package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Lat_Long")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LatLong {
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longitude")
    private double longitude;
}
