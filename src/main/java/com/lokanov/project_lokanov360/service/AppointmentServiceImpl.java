package com.lokanov.project_lokanov360.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lokanov.project_lokanov360.entity.Appointment;
import com.lokanov.project_lokanov360.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	
	@Autowired
	AppointmentRepository appointementRepository;
	@Override
	public Appointment save(Appointment appointement) {
		// TODO Auto-generated method stub
		return appointementRepository.save(appointement);
	}

	@Override
	public Appointment findById(Long id) {
		// TODO Auto-generated method stub
		return appointementRepository.findById(id).get();
	}

	@Override
	public List<Appointment> findAll() {
		// TODO Auto-generated method stub
		return appointementRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		appointementRepository.deleteById(id);
	}

}
