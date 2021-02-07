package com.automatoDev.locadora.controller;

import java.util.List;

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

import com.automatoDev.locadora.model.Acessorio;
import com.automatoDev.locadora.service.AcessorioService;

@RestController
@RequestMapping("acessorio")
public class AcessorioController {

	@Autowired 
	private AcessorioService aService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Acessorio> getAll(){
		return aService.getAll();
	}
	
	@GetMapping("byId")
	public Acessorio getById(@RequestParam(name = "id",required = true, defaultValue = "0")Long id) {
		return aService.getByid(id);
	}
	
	@PostMapping("new")
	public Acessorio postAcessorio(@RequestBody Acessorio acessorio) {
		return aService.postAcessorio(acessorio);
	}
	
	@PutMapping("edit")
	public Acessorio putAcessorio(@RequestBody Acessorio acessorio) {
		return aService.putAcessorio(acessorio);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteAcessorio(@PathVariable("id")Long id) {
		aService.deleteAcessorio(id);
	}
	
}
