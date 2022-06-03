package com.lokanov.project_lokanov360.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "surface")
public class Surface {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String valeur;
	private String nameCat;
	
	/*@ManyToOne
	@JoinColumn(name = "category")
	private Category category;
	*/
	
	public Surface() {
		
	}
	
	public Surface(Long id, String valeur, String nameCat) 
	{
		this.id = id;
		this.valeur = valeur;
		this.nameCat = nameCat;
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

	public String getNameCat() {
		return nameCat;
	}

	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	
/*
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	*/

}
