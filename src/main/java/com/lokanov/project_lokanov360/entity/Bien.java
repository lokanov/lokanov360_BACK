package com.lokanov.project_lokanov360.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bien")
public class Bien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "category")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "surface")
	private Surface surface;
	
	@ManyToOne
	@JoinColumn(name = "etage")
	private Etage etage;
	
	
	
	private Long montantTotal;

	public Bien(Long id, Category category, Surface surface, Etage etage, Long montantTotal) {
		super();
		this.id = id;
		this.category = category;
		this.surface = surface;
		this.etage = etage;
		this.montantTotal = montantTotal;
	}
	
	public Bien()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Surface getSurface() {
		return surface;
	}

	public void setSurface(Surface surface) {
		this.surface = surface;
	}

	public Etage getEtage() {
		return etage;
	}

	public void setEtage(Etage etage) {
		this.etage = etage;
	}

	public Long getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(Long montantTotal) {
		this.montantTotal = montantTotal;
	}
	

}
