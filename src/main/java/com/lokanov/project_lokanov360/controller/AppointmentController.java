package com.lokanov.project_lokanov360.controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lokanov.project_lokanov360.entity.Appointment;
import com.lokanov.project_lokanov360.service.AppointmentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	

	@PostMapping("/add")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Appointment> add(@RequestBody Appointment appointment)
	{
		Random obj = new Random();
		int nb;
		   nb = 1+obj.nextInt(100-1);
		appointment.setNumberReference("R00"+nb+appointment.getName());
		
		if(appointment.getCategory().getId() == 2 || appointment.getCategory().getId() == 5)
		{
			appointment.setEtage(null);
		}
	
		Appointment appointments = appointmentService.save(appointment);
		return ResponseEntity.status(HttpStatus.OK).body(appointments);
		
	}
	
	@GetMapping("/findAll")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<Appointment>>  findAllAppointment()
	{
	  List<Appointment> appointments = appointmentService.findAll();
	  return ResponseEntity.status(HttpStatus.OK).body(appointments);
	}
	
	@PutMapping("/update/{id}")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Appointment> update(@RequestBody Appointment appointment)
	{
		Appointment appointmentUpdate = appointmentService.save(appointment);
		return ResponseEntity.ok().body(appointmentUpdate);
	}
	
	@DeleteMapping("/delete/{id}")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) 
	{	
	  appointmentService.delete(id);
	  return ResponseEntity.noContent().build();
	}
	
	
	//facture pdf
	/*
	@GetMapping("/export/pdf")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<InputStreamResource>  exportTermsPdf()
	{
		List<Appointment> appointments = appointmentService.findAll();
		ByteArrayInputStream byte = appointmentService.;
	  return null;
	}
	*/

}
