package com.example.doctor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.doctor.entities.Doctor;




@Repository
public interface DoctorRepository<Area, Login> extends JpaRepository<Doctor, Integer> {
	@Query("select d from Doctor d where login_id = :id")
	public Doctor getOneByLoginId(Login id);
	
	@Query("select d from Doctor d where area_id = :a")
	public List<Doctor> getDoctorByArea(Area a);
	
	@Query("select DISTINCT(d.speciality) from Doctor d")
	public List<Object> allDoctorsSpeciality();

	@Query("select d from Doctor d where area_id = :a and speciality = :spec")
	public List<Doctor> allDoctorsAreaAndSpeciality(Area a, String spec);
}