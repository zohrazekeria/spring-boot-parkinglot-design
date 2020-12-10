package com.springboot.parkinglot.service;

import java.util.List;
import com.springboot.parkinglot.model.VehicleDTO;

public interface ParkingService {
	
	List<VehicleDTO> getAllVehicles();
	String park(VehicleDTO vehicledto);
	String unpark(Long id);

}
