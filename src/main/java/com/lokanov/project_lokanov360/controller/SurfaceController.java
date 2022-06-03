package com.lokanov.project_lokanov360.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lokanov.project_lokanov360.entity.Category;
import com.lokanov.project_lokanov360.entity.Surface;
import com.lokanov.project_lokanov360.service.CategoryService;
import com.lokanov.project_lokanov360.service.SurfaceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/surface")
public class SurfaceController {
	
	@Autowired
    SurfaceService surfaceService;
	CategoryService categoryService;
	
	/*
	@PostMapping("/add")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Surface> add(@RequestBody Surface surface)
	{
		
		Surface surfaces = surfaceService.save(surface);
		return ResponseEntity.status(HttpStatus.OK).body(surfaces);
	}*/
	
	@GetMapping("/findAll")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<Surface>>  findAllSurface()
	{
	  List<Surface> surfaces = surfaceService.findAll();
	  return ResponseEntity.status(HttpStatus.OK).body(surfaces);
	}
	/*
	@GetMapping("/findByCategory")
	public ResponseEntity<?> findByCategory(@RequestParam String name) {
		try {
			 Category category = categoryService.findByName(name);
			 List<Surface> surfaces = surfaceService.findByCategory(category);
			 return ResponseEntity.ok(surfaces);
		    } 
		catch (Exception e)
		{
			return new ResponseEntity<>("missing", null, HttpStatus.NOT_FOUND);
		}	
	}
*/
	
	@GetMapping("/findByApp")
	public ResponseEntity<?> findByApp() {
		try {
			
			 List<Surface> surfaces = surfaceService.findByApp();
			 return ResponseEntity.ok(surfaces);
		    } 
		catch (Exception e)
		{
			return new ResponseEntity<>("missing", null, HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping("/findByMaison")
	public ResponseEntity<?> findByMaison() {
		try {
			 List<Surface> surfaces = surfaceService.findByMaison();
			 return ResponseEntity.ok(surfaces);
		    } 
		catch (Exception e)
		{
			return new ResponseEntity<>("missing", null, HttpStatus.NOT_FOUND);
		}	
	}
}
