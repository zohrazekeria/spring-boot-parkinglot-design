package com.springboot.parkinglot.serviceimpl;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
		Long timeSpendMin = 0L;
		if (id > 0 && id <= 10) {
			Optional<VehicleDTO> vichelTobeDeleted = parkingRepository.findById(id);
			if (vichelTobeDeleted.isPresent()) {
				VehicleDTO currentVichel = vichelTobeDeleted.get();
				Date initialtime = currentVichel.getParkedAt();
			    Date currentime= new Date();
			    Long diff = currentime.getTime() - initialtime.getTime();
			    timeSpendMin = TimeUnit.MILLISECONDS.toMinutes(diff);
			   
			}
			parkingRepository.deleteById(id);
		} else {
			throw new RuntimeException("Please provide an id between 1 and 10");
		}
		return "The Vehicle has used  " + timeSpendMin + "   Minutes ";
	}
	
	

}
