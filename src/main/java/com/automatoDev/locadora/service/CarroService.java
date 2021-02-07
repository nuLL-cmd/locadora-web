package com.automatoDev.locadora.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automatoDev.locadora.handle.NegocioException;
import com.automatoDev.locadora.model.Acessorio;
import com.automatoDev.locadora.model.Carro;
import com.automatoDev.locadora.model.Fabricante;
import com.automatoDev.locadora.repository.CarroRepository;
import com.automatoDev.locadora.repository.FabricanteRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository cRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Carro> getAll(){
		return cRepository.getAll();
	}
	
	
	public Carro getByid(Long id) {
		if(id <= 0) {
			throw new NegocioException("Id não pode ser menor ou igual a zero");
		}
		return cRepository.getById(id);
	}
	
	public Carro persisCarro(Carro carro) {
		return cRepository.postCarro(carro);
	}
	
	public Carro putCarro(Carro carro) {
		if(carro.getIdCarro() != 0) {
			Carro c = entityManager.find(Carro.class, carro.getIdCarro());
			if(c != null) {
				c.setAcessorios(carro.getAcessorios());
				 return cRepository.postCarro(c);
		}
			
			throw new NegocioException("Item não encontrado para atualização");
		}
		
		throw new NegocioException("Id não pode ser 0");
				
	}
	
	public void deleteCarro(Long id) {
		if (id <= 0) {
			throw new NegocioException("Id não pode ser menor ou igual a 0");
		}
		cRepository.deleteCarro(id);
	}

}
