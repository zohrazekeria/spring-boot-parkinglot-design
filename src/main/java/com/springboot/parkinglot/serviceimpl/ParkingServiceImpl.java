package com.springboot.parkinglot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.parkinglot.model.VehicleDTO;
import com.springboot.parkinglot.repository.ParkingRepository;
import com.springboot.parkinglot.service.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {
	@Autowired
	ParkingRepository parkingRepository;

	@Override
	public List<VehicleDTO> getAllVehicles() {
		// TODO Auto-generated method stub
		return parkingRepository.findAll();
	}

	@Override
	public String park(VehicleDTO vehicleDTO) {
		if (vehicleDTO.getId() > 0 && vehicleDTO.getId() <= 10) {
			List<VehicleDTO> dtos = parkingRepository.findAll();
			if (dtos.isEmpty()) {
				parkingRepository.save(vehicleDTO);
			}
			for (VehicleDTO dto : dtos) {
				if (dto.getId() != vehicleDTO.getId()){
					parkingRepository.save(vehicleDTO);
				} else
					throw new RuntimeException(vehicleDTO.getId() + "this slot is not Empty");
			}

		} else {
			throw new RuntimeException("Please provide an id between 1 to 10!");
		}

		return "Parked";
	}

	@Override
	public String unpark(Long id) {
		if (id > 0 && id <= 10) {
			parkingRepository.deleteById(id);
		} else {
			throw new RuntimeException("Please provide an id between 1 and 10");
		}
		return "Unparked the Vehcle with id" + id;
	}

}
