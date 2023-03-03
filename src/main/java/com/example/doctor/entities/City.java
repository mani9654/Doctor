package com.example.doctor.entities;





import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "city_name")
	private String cityName;
	
	@JsonIgnoreProperties("cities")
	@ManyToOne
	@JoinColumn(name="state_id")
	private State state_id;
	
	public City() {
		super();
	}
	
	public City(String cityName) {
		super();
		this.cityName =cityName;
	}
	
	public City(String cityName, State state_id) {
		super();
		this.cityName = cityName;
		this.state_id = state_id;
	}
	
	public City(int cityId, String cityName, State state_id) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.state_id = state_id;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState_id() {
		return state_id;
	}

	public void setState_id(State state_id) {
		this.state_id = state_id;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", state_id=" + state_id +"]";
	}
	

	
	

	
	}

