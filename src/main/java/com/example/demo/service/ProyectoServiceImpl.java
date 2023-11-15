/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProyectoDAO;
import com.example.demo.dto.Proyecto;

/**
 * 
 */
@Service
public class ProyectoServiceImpl implements IProyectoService {

	@Autowired
	IProyectoDAO daoProyecto;

	/**
	 * Deveuelve todos los proyectos
	 * 
	 * @return List<Proyecto>
	 */
	public List<Proyecto> getAll() {
		return daoProyecto.findAll();
	}

	/**
	 * Devuelve un proyecto en especifico
	 * 
	 * @param id
	 * @return Proyecto
	 */
	public Proyecto getId(String id) {
		return daoProyecto.findById(id).get();
	}

	/**
	 * Añade un proyecto a la base de datos
	 * 
	 * @param proyecto
	 * @return Proyecto
	 */
	public Proyecto add(Proyecto proyecto) {
		return daoProyecto.save(proyecto);
	}

	/**
	 * Actualiza un proyecto
	 * 
	 * @param proyecto
	 * @return Proyecto
	 */
	public Proyecto update(Proyecto proyecto) {
		return daoProyecto.save(proyecto);
	}

	/**
	 * Elimina un proyecto
	 * 
	 * @param id
	 */
	public void delete(String id) {
		daoProyecto.deleteById(id);
	}
}
