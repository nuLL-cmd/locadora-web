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
import com.automatoDev.locadora.model.Carro;
import com.automatoDev.locadora.service.AcessorioService;
import com.automatoDev.locadora.service.CarroService;
@RestController
@RequestMapping("carro")
public class CarroController {

		@Autowired 
		private CarroService cService;
		
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		public List<Carro> getAll(){
			return cService.getAll();
		}
		
		@GetMapping("byId")
		public Carro getById(@RequestParam(name = "id",required = true, defaultValue = "0")Long id) {
			return cService.getByid(id);
		}
		
		@PostMapping("new")
		public Carro postCarro(@RequestBody Carro carro) {
			return cService.persisCarro(carro);
		}
		
		@PutMapping("edit")
		public Carro putCarro(@RequestBody Carro carro) {
			return cService.putCarro(carro);
		}
		
		@DeleteMapping("delete/{id}")
		public void deleteCarro(@PathVariable("id")Long id) {
			cService.deleteCarro(id);
		}
}
