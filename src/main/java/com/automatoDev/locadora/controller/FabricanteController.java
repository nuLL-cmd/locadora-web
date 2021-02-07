package com.automatoDev.locadora.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.automatoDev.locadora.model.Fabricante;
import com.automatoDev.locadora.service.FabricanteService;


@RestController
@RequestMapping("fabricante")
public class FabricanteController {

	@Autowired
	private FabricanteService fService;
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	public List<Fabricante> getAll(){
		return fService.getAll();
	}
	
	@PostMapping("new")
	public Fabricante persistFabricante(@Valid @RequestBody Fabricante fabricante) {
		return fService.persistFabricante(fabricante);
	}
	
	@PutMapping("edit")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Fabricante putFariFabricante(@RequestBody Fabricante fabricante) {
		return fService.putFabricante(fabricante);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("delete/{id}")
	public void deleteFabricante(@PathVariable("id") Long id) {
		fService.deleteFabricante(id);
	}

	
}
