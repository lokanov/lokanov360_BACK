package com.lokanov.project_lokanov360.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lokanov.project_lokanov360.entity.Bien;
import com.lokanov.project_lokanov360.service.BienService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/bien")
public class BienController {

	@Autowired
	BienService bienService;
	
	
	@GetMapping("/findByMontantAppLoc")
	public ResponseEntity<?> findByApp() {
		try {
			
			 List<Bien> biens = bienService.findByMontantAppLoc();
			 return ResponseEntity.ok(biens);
		    } 
		catch (Exception e)
		{
			return new ResponseEntity<>("missing", null, HttpStatus.NOT_FOUND);
		}	
	}
}
