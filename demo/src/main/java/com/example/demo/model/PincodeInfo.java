package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pin_code")
@Getter
@Setter
@NoArgsConstructor
public class PincodeInfo {
   

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "pincode")
    private String pincode;
    
    @Column(name = "latitude")
    private Double latitude;
    
    @Column(name = "longitude")
    private Double longitude;
    
    @Column(name = "date")
    private LocalDate date;
    
    public PincodeInfo(String pincode2, double latitude2, double longitude2, LocalDate forDate) {
    	this.pincode=pincode2;
		this.latitude=latitude2;
		this.longitude=longitude2;
		this.date=forDate;
	}

}
