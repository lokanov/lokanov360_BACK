package com.lokanov.project_lokanov360.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lokanov.project_lokanov360.entity.Bien;
import com.lokanov.project_lokanov360.repository.BienRepository;

@Service
public class BienServiceImpl implements BienService {

	
	@Autowired
	BienRepository bienRepository;
	@Override
	public Bien save(Bien bien) {
		// TODO Auto-generated method stub
		return bienRepository.save(bien);
	}

	@Override
	public Bien findById(Long id) {
		// TODO Auto-generated method stub
		return bienRepository.findById(id).get();
	}

	@Override
	public List<Bien> findAll() {
		// TODO Auto-generated method stub
		return bienRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		bienRepository.deleteById(id);
	}

	@Override
	public List<Bien> findByMontantAppLoc() {
		// TODO Auto-generated method stub
		return bienRepository.findAll();
	}

}
