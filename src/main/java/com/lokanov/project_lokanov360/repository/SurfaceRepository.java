package com.lokanov.project_lokanov360.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lokanov.project_lokanov360.entity.Category;
import com.lokanov.project_lokanov360.entity.Surface;

@Repository
public interface SurfaceRepository extends JpaRepository<Surface, Long> {
	//List<Surface> findByCategory(Category category);	
	
	//surface par appartement
	@Query(value = "SELECT s FROM Surface s  WHERE s.nameCat LIKE 'App%'")
	List<Surface> findByApp();
	//surface par maison
		@Query(value = "SELECT s FROM Surface s WHERE  s.nameCat LIKE 'Mai%'")
		List<Surface> findByMaison();

}
