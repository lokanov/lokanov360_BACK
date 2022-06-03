package com.lokanov.project_lokanov360.service;

import java.util.List;

import com.lokanov.project_lokanov360.entity.Bien;

public interface BienService {
	
	        Bien save(Bien bien);
		
			Bien findById(Long id);
			
			List<Bien> findAll();
			
			void delete(Long id);
			
			List<Bien> findByMontantAppLoc();


}
