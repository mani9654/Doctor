package com.example.doctor.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.entities.Doctor;
import com.example.doctor.repositories.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository<Area, Login> drepo;
	
	@Autowired
	JavaMailSender jms;
	
	public Doctor getOneByLoginId(Login id) {
		return drepo.getOneByLoginId(id);
	}
	public Doctor saveDoctor(Doctor d) {	
		Doctor dd = drepo.save(d);
		if(dd != null) {
			SimpleMailMessage smm = new SimpleMailMessage();
			smm.setFrom("connecttoyourdoctor@gmail.com");
			smm.setTo(d.getLogin_id().getUser_name());
			System.out.println("--**$$"+d.getLogin_id().getUser_name());
			smm.setSubject("Registration Mail");
			Date day = new Date();
			smm.setText("Registration Successful "+day);
			jms.send(smm);
			return dd;
		}
		else {
			return null;
		}
	}
	
	public Doctor updateDoctor(Doctor d) {
		try {
			return drepo.save(d);
		} catch (Exception e) {
			return null;
		}
	}
	public Optional<Doctor> getOneDoctor(int id) {
		return drepo.findById(id);
	}
	public List<Doctor> allDoctors() {
		return drepo.findAll();
		
	}
	public List<Doctor> allDoctorsByArea(Area a) {
		return drepo.getDoctorByArea(a);

	}
	public Doctor getOneById(int id) {
		return drepo.findById(id).get();
	}
	public List<Object> allDoctorsSpeciality() {
		return drepo.allDoctorsSpeciality();
	}
	public List<Doctor> allDoctorsAreaAndSpeciality(Area a, String spec) {
		return drepo.allDoctorsAreaAndSpeciality(a,spec);
	}
	

		}
	
