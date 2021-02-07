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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.automatoDev.locadora.model.Modelo;
import com.automatoDev.locadora.service.ModeloService;

@RestController
@RequestMapping("modelo")
public class ModeloController {

	@Autowired
	private ModeloService mService;
	
	@PostMapping("new")
	public Modelo persistModelo(@Valid @RequestBody Modelo modelo) {
		return mService.persistModelo(modelo);
	}
	
	@GetMapping
	public List<Modelo> getAll(){
		return mService.getAll();
	}
	
	@GetMapping("{id}")
	public Modelo getById(@PathVariable Long id) {
		return mService.getById(id);
	}
	
	@GetMapping("chassi")
	public Modelo getByChassi(@RequestParam(required = true, defaultValue = "0") Integer id) {
		return mService.getById(id);
	}
	
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PutMapping("edit")
	public Modelo putModelo(@RequestBody Modelo modelo) {
		return mService.putModlModelo(modelo);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteModelo(@PathVariable("id") Long id) {
		mService.deleteModelo(id);
	}
}
