package com.lokanov.project_lokanov360.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lokanov.project_lokanov360.entity.Category;
import com.lokanov.project_lokanov360.entity.Surface;
import com.lokanov.project_lokanov360.repository.SurfaceRepository;

@Service
public class SurfaceServiceImpl implements SurfaceService{

	
	@Autowired
	SurfaceRepository surfaceRepository;
	@Override
	public List<Surface> findAll() {
		// TODO Auto-generated method stub
		return surfaceRepository.findAll();
	}
	/*
	@Override
	public List<Surface> findByCategory(Category category) {
		// TODO Auto-generated method stub
		return  surfaceRepository.findByCategory(category);
	}*/
	@Override
	public List<Surface> findByApp() {
		// TODO Auto-generated method stub
		return surfaceRepository.findByApp();
	}
	@Override
	public List<Surface> findByMaison() {
		// TODO Auto-generated method stub
		return surfaceRepository.findByMaison();
	}

}
