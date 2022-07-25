package com.lokanov.project_lokanov360.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lokanov.project_lokanov360.dto.CountVisitByCategoryDto;
import com.lokanov.project_lokanov360.entity.Abonnement;
import com.lokanov.project_lokanov360.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
         Company findByName(String name);
         
         @Query("SELECT abonnement FROM Company company LEFT JOIN Abonnement abonnement ON company.abonnement = abonnement.id\r\n"
         		+ " GROUP BY abonnement.name")
        Abonnement findAbonnement();
         
     
}
