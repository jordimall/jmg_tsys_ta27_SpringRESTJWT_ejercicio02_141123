/**
 * 
 */
package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 */
@Entity
@Table(name = "proyectos")
public class Proyecto {

	@Id
	@Column(name = "Id")
	private String id;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Horas")
	private int horas;

	@ManyToMany(mappedBy = "proyectos")
	@JsonIgnoreProperties("proyectos")
	private List<Cientifico> cientificos;

	/**
	 * 
	 */
	public Proyecto() {
	}

	/**
	 * @param id
	 * @param nombre
	 * @param horas
	 */
	public Proyecto(String id, String nombre, int horas) {
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * @return the cientificos
	 */
	public List<Cientifico> getCientificos() {
		return cientificos;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param horas the horas to set
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * @param cientificos the cientificos to set
	 */
	public void setCientificos(List<Cientifico> cientificos) {
		this.cientificos = cientificos;
	}

}
