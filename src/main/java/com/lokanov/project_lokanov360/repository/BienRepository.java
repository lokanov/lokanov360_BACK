package com.lokanov.project_lokanov360.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lokanov.project_lokanov360.entity.Bien;
import com.lokanov.project_lokanov360.entity.Surface;

@Repository
public interface BienRepository  extends JpaRepository<Bien, Long>
{
 
	
	//montant par category, par surface 
		@Query(value = "SELECT bien FROM Bien bien  LEFT JOIN bien.category category WHERE bien.category.id=5")
		List<Bien> findByMontantAppLoc();
}
