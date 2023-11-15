/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cientifico;

/**
 * 
 */
public interface ICientificoService {
	/**
	 * Deveuelve todos los cientificos
	 * 
	 * @return List<Cientifico>
	 */
	public List<Cientifico> getAll();

	/**
	 * Devuelve un cientifico en especifico
	 * 
	 * @param id
	 * @return Cientifico
	 */
	public Cientifico getId(String id);

	/**
	 * Añade un cientifico a la base de datos
	 * 
	 * @param cientifico
	 * @return Cientifico
	 */
	public Cientifico add(Cientifico cientifico);

	/**
	 * Actualiza un cientifico
	 * 
	 * @param cientifico
	 * @return Cientifico
	 */
	public Cientifico update(Cientifico cientifico);

	/**
	 * Elimina un cientifico
	 * 
	 * @param id
	 */
	public void delete(String id);
}
