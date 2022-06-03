package com.lokanov.project_lokanov360.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lokanov.project_lokanov360.entity.Category;
import com.lokanov.project_lokanov360.entity.Surface;

public interface SurfaceService {
	List<Surface> findAll();
	//List<Surface> findByCategory(Category category);
	List<Surface> findByApp();
	List<Surface> findByMaison();

}
