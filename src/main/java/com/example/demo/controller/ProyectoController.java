/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Proyecto;
import com.example.demo.service.ProyectoServiceImpl;

/**
 * 
 */
@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;

	/**
	 * Deveuelve todos los proyectos
	 * 
	 * @return List<Proyecto>
	 */
	@GetMapping("/all")
	public List<Proyecto> all() {
		return proyectoServiceImpl.getAll();
	}

	/**
	 * Devuelve un proyecto en especifico
	 * 
	 * @param id
	 * @return Proyecto
	 */
	@GetMapping("/show/{id}")
	public Proyecto show(@PathVariable(name = "id") String id) {

		Proyecto proyecto_xid = new Proyecto();

		proyecto_xid = proyectoServiceImpl.getId(id);

		return proyecto_xid;
	}

	/**
	 * Añade un proyecto a la base de datos
	 * 
	 * @param proyecto
	 * @return Proyecto
	 */
	@PostMapping("/new")
	public Proyecto create(@RequestBody Proyecto proyecto) {

		return proyectoServiceImpl.add(proyecto);
	}

	/**
	 * Actualiza un proyecto
	 * 
	 * @param proyecto
	 * @return Proyecto
	 */
	@PutMapping("/update/{id}")
	public Proyecto edit(@PathVariable(name = "id") String id, @RequestBody Proyecto proyecto) {

		Proyecto proyectoSeleccionado = new Proyecto();
		Proyecto proyectoActualizado = new Proyecto();

		proyectoSeleccionado = proyectoServiceImpl.getId(id);

		proyectoSeleccionado.setNombre(proyecto.getNombre());
		proyectoSeleccionado.setHoras(proyecto.getHoras());

		proyectoActualizado = proyectoServiceImpl.update(proyectoSeleccionado);

		return proyectoActualizado;
	}

	/**
	 * Elimina un proyecto
	 * 
	 * @param id
	 */
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		proyectoServiceImpl.delete(id);
	}

}
