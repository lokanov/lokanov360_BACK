package com.lokanov.project_lokanov360.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lokanov.project_lokanov360.dto.CountVisitByCategoryDto;
import com.lokanov.project_lokanov360.entity.Category;
import com.lokanov.project_lokanov360.entity.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long>
{
	List<Visit> findByTitre(String titre);
	List<Visit> findByCategory(Category category);
	
	@Query("SELECT new com.lokanov.project_lokanov360.dto.CountVisitByCategoryDto(category.name, count(*)) from Visit visit"
			+ " LEFT JOIN Category  category on visit.category = category.id\r\n"
    		+ " GROUP BY category.name")
    List<CountVisitByCategoryDto> findNumberVisitByCategoryDto();
}
