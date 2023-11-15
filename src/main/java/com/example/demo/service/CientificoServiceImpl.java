/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICientificoDAO;
import com.example.demo.dto.Cientifico;

/**
 * 
 */
@Service
public class CientificoServiceImpl implements ICientificoService {

	@Autowired
	ICientificoDAO daoCientifico;

	/**
	 * Deveuelve todos los cientificos
	 * 
	 * @return List<Cientifico>
	 */
	public List<Cientifico> getAll() {
		return daoCientifico.findAll();
	}

	/**
	 * Devuelve un cientifico en especifico
	 * 
	 * @param id
	 * @return Cientifico
	 */
	public Cientifico getId(String id) {
		return daoCientifico.findById(id).get();
	}

	/**
	 * Añade un cientifico a la base de datos
	 * 
	 * @param cientifico
	 * @return Cientifico
	 */
	public Cientifico add(Cientifico cientifico) {
		return daoCientifico.save(cientifico);
	}

	/**
	 * Actualiza un cientifico
	 * 
	 * @param cientifico
	 * @return Cientifico
	 */
	public Cientifico update(Cientifico cientifico) {
		return daoCientifico.save(cientifico);
	}

	/**
	 * Elimina un cientifico
	 * 
	 * @param id
	 */
	public void delete(String id) {
		daoCientifico.deleteById(id);
	}
}
