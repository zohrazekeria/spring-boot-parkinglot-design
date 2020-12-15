package com.springboot.parkinglot.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Entity
@Data
public class VehicleDTO {
	@Id
	private long id;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date parkedAt = new Date();
	private String vehicleNumber;
	private String ownerName;
}
