/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proyecto;

/**
 * 
 */
public interface IProyectoService {
	/**
	 * Deveuelve todos los proyectos
	 * 
	 * @return List<Proyecto>
	 */
	public List<Proyecto> getAll();

	/**
	 * Devuelve un proyecto en especifico
	 * 
	 * @param id
	 * @return Proyecto
	 */
	public Proyecto getId(String id);

	/**
	 * Añade un proyecto a la base de datos
	 * 
	 * @param proyecto
	 * @return Proyecto
	 */
	public Proyecto add(Proyecto proyecto);

	/**
	 * Actualiza un proyecto
	 * 
	 * @param proyecto
	 * @return Proyecto
	 */
	public Proyecto update(Proyecto proyecto);

	/**
	 * Elimina un proyecto
	 * 
	 * @param id
	 */
	public void delete(String id);
}
