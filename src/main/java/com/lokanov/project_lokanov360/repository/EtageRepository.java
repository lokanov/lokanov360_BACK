package com.lokanov.project_lokanov360.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lokanov.project_lokanov360.entity.Etage;

@Repository
public interface EtageRepository  extends JpaRepository<Etage, Long>{

}
