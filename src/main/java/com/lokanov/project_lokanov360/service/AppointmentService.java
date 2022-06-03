package com.lokanov.project_lokanov360.service;

import java.util.List;

import com.lokanov.project_lokanov360.entity.Appointment;

public interface AppointmentService {
	
    Appointment save(Appointment appointement);
	
	Appointment findById(Long id);
	
	List<Appointment> findAll();
	
	void delete(Long id);

}
