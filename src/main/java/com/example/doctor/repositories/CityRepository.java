package com.example.doctor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.doctor.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
	
	@Query("select c from City c where state_id = :s")
	
	public List<City> getCityByStateId(State s);
}

