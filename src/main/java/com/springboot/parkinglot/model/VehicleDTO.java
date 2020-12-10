package com.springboot.parkinglot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class VehicleDTO {
	
	@Id
	private long id;
	private String vehicleNumber;
	private String ownerName;
	
	

}
