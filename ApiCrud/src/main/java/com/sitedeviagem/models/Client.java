package com.sitedeviagem.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;


	private LocalDate vooDate;
	
	
	
	@Transient
	@OneToMany(mappedBy = "viagems")
	@JsonIgnore
	private Set<Viagem> viagems = new HashSet<>();
	
	
	
	
	
	
	
	

	public LocalDate getVooDate() {
		return vooDate;
	}

	public void setVooDate(LocalDate voo_Date) {
		this.vooDate = voo_Date;
	}

	public Set<Viagem> getViagems() {
		return viagems;
	}

	public void setViagems(Set<Viagem> viagems) {
		this.viagems = viagems;
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



}
