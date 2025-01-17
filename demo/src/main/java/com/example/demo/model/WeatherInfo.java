package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="weather_info")
@Getter
@Setter
@NoArgsConstructor
public class WeatherInfo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "temperature")
    private Double temperature;
    
    @Column(name = "humidity")
    private Double humidity;
    
    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "pincode_info_id")
    private PincodeInfo pincodeInfo; 

    public WeatherInfo(double temp, double humidity2, String description2, PincodeInfo pincodeInfo2) {
    	this.temperature = temp;
    	this.humidity=humidity2;
    	this.description=description2;
    	this.pincodeInfo=pincodeInfo2;
    	
    }
   
}
