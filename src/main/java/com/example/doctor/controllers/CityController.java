package com.example.doctor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctor.entities.City;
import com.example.doctor.services.CityService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CityController {
	
	@Autowired
	CityService cservice;
	
	@Autowired
	StateService sservice;
	
	@GetMapping("/getcitybystate/{id}")
	public List<City> getCityByStateId(@PathVariable int id) {
		State s = sservice.getById(id);
		return cservice.getCityByStateId(s);
	}
	
	@GetMapping("/allcities")
	public List<City> getAllCity(){
		return cservice.allcities();
	}
	
	@GetMapping("getcitybyid/{id}")
	public City getCityById(@PathVariable int id) {
		return cservice.getCityById(id);
	}
	
	@PostMapping("/savecity")
	public City saveCity(@RequestBody City c) {
		return cservice.saveCity(c);
	}
}
