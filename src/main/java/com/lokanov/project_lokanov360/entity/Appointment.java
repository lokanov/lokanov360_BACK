package com.lokanov.project_lokanov360.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;


@Entity
@Table(name = "appointement")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String numberReference;
	private String name;
	private String phone;
	private String email;
	private String personContact;

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
	
    private String autres;

	public Appointment(Long id, String name, String phone, String email, String personContact,
			String autres) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.personContact = personContact;
		this.autres = autres;
	}
	public Appointment() 
	{
		 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPersonContact() {
		return personContact;
	}

	public void setPersonContact(String personContact) {
		this.personContact = personContact;
	}


	public String getAutres() {
		return autres;
	}

	public void setAutres(String autres) {
		this.autres = autres;
	}

	public String getNumberReference() {
		return numberReference;
	}

	public void setNumberReference(String numberReference) {
		this.numberReference = numberReference;
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
	
	
