package com.example.doctor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.entities.City;
import com.example.doctor.repositories.CityRepository;

@Service
public class CityService {
	@Autowired
	CityRepository crepo;
	
	public List<City> getCityByStateId(State s){
		return crepo.getCityByStateId(s);
	}
	
	public City getCityById(int id) {
		return crepo.findById(id).get();
	}
	
	public City saveCity(City c ) {
		
		try {
			return crepo.save(c);
		}catch(Exception e) {
			return null;
		}
	}
    
	public List<City> allcities() {
		return crepo.findAll();
	}
}
