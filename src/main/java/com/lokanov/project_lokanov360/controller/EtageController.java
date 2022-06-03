package com.lokanov.project_lokanov360.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lokanov.project_lokanov360.entity.Etage;
import com.lokanov.project_lokanov360.service.EtageService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/etage")
public class EtageController {
	

	@Autowired
    EtageService etageService;
	
	/*
	@PostMapping("/add")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Etage> add(@RequestBody Etage Etage)
	{
		
		Etage Etages = EtageService.save(Etage);
		return ResponseEntity.status(HttpStatus.OK).body(Etages);
	}*/
	
	@GetMapping("/findAll")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<Etage>>  findAllEtage()
	{
	  List<Etage> etages = etageService.findAll();
	  return ResponseEntity.status(HttpStatus.OK).body(etages);
	}


}
