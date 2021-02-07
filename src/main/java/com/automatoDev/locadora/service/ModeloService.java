package com.automatoDev.locadora.service;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automatoDev.locadora.handle.NegocioException;
import com.automatoDev.locadora.model.Modelo;
import com.automatoDev.locadora.repository.ModeloRepository;


@Service
public class ModeloService {
	
	@Autowired
	private ModeloRepository modeloRepository;

	public Modelo persistModelo(Modelo modelo) {
		if (modelo != null) {
			return modeloRepository.persistModelo(modelo);
		}
	
		
		throw new NegocioException("Objeto não pode sernulo");
	}
	
	public Modelo putModlModelo(Modelo modelo) {
		if (modelo != null) {
			modeloRepository.persistModelo(modelo);
		}
		return null;
	}
	
	public List<Modelo> getAll(){
		return modeloRepository.getAll();
	}
	
	public Modelo getById(Long id) {
		return modeloRepository.getById(id);
	}
	
	public Modelo getById(Integer chassi) {
		return modeloRepository.getByChassi(chassi);
	}
	
	public void deleteModelo(Long id) {
		if(id <= 0) {
			throw new NegocioException("Id não pode ser menor ou igual a 0");
		}
		
		modeloRepository.deleteModelo(id);;
	}
}
