/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Cientifico;
import com.example.demo.dto.Proyecto;
import com.example.demo.service.CientificoServiceImpl;
import com.example.demo.service.ProyectoServiceImpl;

/**
 * 
 */
@RestController
@RequestMapping("/api/cientificos")
public class CientificoController {

	@Autowired
	CientificoServiceImpl cientificoServiceImpl;

	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;

	@Autowired
	private EntityManager entityManager;

	/**
	 * Deveuelve todos los cientificos
	 * 
	 * @return List<Cientifico>
	 */
	@GetMapping("/all")
	public List<Cientifico> all() {
		return cientificoServiceImpl.getAll();
	}

	/**
	 * Devuelve un cientifico en especifico
	 * 
	 * @param id
	 * @return Cientifico
	 */
	@GetMapping("/show/{id}")
	public Cientifico show(@PathVariable(name = "id") String id) {

		Cientifico cientifico_xid = new Cientifico();

		cientifico_xid = cientificoServiceImpl.getId(id);

		return cientifico_xid;
	}

	/**
	 * Añade un cientifico a la base de datos
	 * 
	 * @param cientifico
	 * @return Cientifico
	 */
	@PostMapping("/new")
	public Cientifico create(@RequestBody Cientifico cientifico) {

		return cientificoServiceImpl.add(cientifico);
	}

	/**
	 * Actualiza un cientifico
	 * 
	 * @param cientifico
	 * @return Cientifico
	 */
	@PutMapping("/update/{id}")
	public Cientifico edit(@PathVariable(name = "id") String id, @RequestBody Cientifico cientifico) {

		Cientifico cientificoSeleccionado = new Cientifico();
		Cientifico cientificoActualizado = new Cientifico();

		cientificoSeleccionado = cientificoServiceImpl.getId(id);

		cientificoSeleccionado.setNomApels(cientifico.getNomApels());

		cientificoActualizado = cientificoServiceImpl.update(cientificoSeleccionado);

		return cientificoActualizado;
	}

	/**
	 * Elimina un cientifico
	 * 
	 * @param id
	 */
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		cientificoServiceImpl.delete(id);
	}

	@PostMapping("/cientifico-proyecto/{id}")
	@Transactional
	public ResponseEntity<String> addCientificoProyecto(@RequestBody Cientifico cientifico,
			@PathVariable(name = "id") String id) {

		Cientifico cientificoGuardado = cientificoServiceImpl.add(cientifico);

		Proyecto proyecto = proyectoServiceImpl.getId(id);

		// Asocia el estudiante con el curso
		if (proyecto != null) {
			cientificoGuardado.getProyectos().add(proyecto);
			proyecto.getCientificos().add(cientificoGuardado);
			entityManager.persist(cientificoGuardado);
			entityManager.persist(proyecto);
		}

		return ResponseEntity.ok("Estudiante asociado con Ã©xito al curso");

	}

}
