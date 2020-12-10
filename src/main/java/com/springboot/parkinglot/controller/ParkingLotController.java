package com.springboot.parkinglot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.springboot.parkinglot.model.Myintroduction;
import com.springboot.parkinglot.model.VehicleDTO;
import com.springboot.parkinglot.service.ParkingService;



@RestController
@RequestMapping("/parkinglot")
public class ParkingLotController {
	
	@Autowired
	ParkingService parkingService;
	
	/*
		 * @GetMapping("/aboutMe") public Myintroduction aboutMe() {
		 * 
		 * return
		 * Myintroduction.builder().name("zohra").age(28).skills("Java and Kurbenete").
		 * build(); }
		 * 
		 * @PostMapping("/addSomeinfo") public Myintroduction addSomeinfo(String
		 * name,int age, String skills) {
		 * 
		 * return Myintroduction.builder().name(name).age(age).skills(skills).build(); }
		 */
	
	@GetMapping("/parkinginfo")
	public List<VehicleDTO> getAllVahicles(){
		return parkingService.getAllVehicles();
		
	}
	@PostMapping("/park")
	public String park(VehicleDTO vehicleDTO) {
		return parkingService.park(vehicleDTO);
	}
	@DeleteMapping("/park")
	public String unpark(Long id) {
		return parkingService.unpark(id);
	}
	
}
