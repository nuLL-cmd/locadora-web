package com.automatoDev.locadora.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automatoDev.locadora.handle.NegocioException;
import com.automatoDev.locadora.model.Fabricante;
import com.automatoDev.locadora.repository.FabricanteRepository;


@Service
public class FabricanteService {

	@Autowired
	private FabricanteRepository fRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Fabricante> getAll(){
		return fRepository.getAll();
	}
	
	public Fabricante persistFabricante(Fabricante fabricante) {
			if (!fabricante.getCnpj().trim().isBlank() || !fabricante.getCnpj().trim().isEmpty()) {
				return fRepository.persistFabricante(fabricante);
			}

			throw new NegocioException("Campo cnpj não pode ser nulo ou vazio!");
	}
	
	public Fabricante putFabricante(Fabricante fabricante) {
		if(fabricante.getId() != 0 ) {
			Fabricante f = entityManager.find(Fabricante.class, fabricante.getId());
			if(f != null) {
				 fRepository.persistFabricante(fabricante);
				 return fabricante;
		}
			
			throw new NegocioException("Item não encontrado para atualização");
		}
		
		throw new NegocioException("Id não pode ser 0");
				
	}
	
	public void deleteFabricante(Long id) {
		if (id <= 0) {
			throw new NegocioException("Id não pode ser menor ou igual a 0");
		}
		fRepository.deleteFabricante(id);
	}
}
