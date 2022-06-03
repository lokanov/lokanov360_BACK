package com.lokanov.project_lokanov360.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;

@Entity
@Table(name = "etage")
public class Etage {

 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String valeur;
	
	public Etage() {
		
	}
	
	public Etage(Long id, String valeur) 
	{
		this.id = id;
		this.valeur = valeur;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public String getvaleur() 
	{
		return valeur;
	}
	public void setvaleur(String valeur) {
		this.valeur = valeur;
	}
	
}
