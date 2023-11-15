/**
 * 
 */
package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 */
@Entity
@Table(name = "cientificos")
public class Cientifico {

	@Id
	@Column(name = "DNI")
	private String dni;

	@Column(name = "nom_apels")
	private String nomApels;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "asignados_A", joinColumns = { @JoinColumn(name = "Cientifico") }, inverseJoinColumns = {
			@JoinColumn(name = "Proyecto") })

	@JsonIgnoreProperties("cientificos")
	private List<Proyecto> proyectos = new ArrayList<>();

	/**
	 * 
	 */
	public Cientifico() {
	}

	/**
	 * @param dni
	 * @param nomApels
	 * @param proyectos
	 */
	public Cientifico(String dni, String nomApels, List<Proyecto> proyectos) {
		this.dni = dni;
		this.nomApels = nomApels;
		this.proyectos = proyectos;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @return the nomApels
	 */
	public String getNomApels() {
		return nomApels;
	}

	/**
	 * @return the proyectos
	 */
	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @param nomApels the nomApels to set
	 */
	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}

	/**
	 * @param proyectos the proyectos to set
	 */
	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

}
