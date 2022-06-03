package com.lokanov.project_lokanov360.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lokanov.project_lokanov360.entity.Etage;
import com.lokanov.project_lokanov360.repository.EtageRepository;

@Service
public class EtageServiceImpl  implements EtageService{

	@Autowired
	EtageRepository etageRepository;
	
	@Override
	public List<Etage> findAll() {
		// TODO Auto-generated method stub
		return etageRepository.findAll();
	}

}
