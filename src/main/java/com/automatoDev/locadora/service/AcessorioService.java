package com.automatoDev.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automatoDev.locadora.handle.NegocioException;
import com.automatoDev.locadora.model.Acessorio;
import com.automatoDev.locadora.repository.AcessorioRepository;

@Service
public class AcessorioService {
	
	@Autowired
	private AcessorioRepository aRepository;
	
	
	public List<Acessorio> getAll(){
		return aRepository.getAll();
	}
	
	public Acessorio getByid(Long id) {
		if(id <= 0) {
			throw new NegocioException("Id não pode ser menor ou igual a zero");
		}
		return aRepository.getById(id);
	}
	
	public Acessorio putAcessorio(Acessorio acessorio) {
		if (acessorio.getIdAcessorio() <= 0) {
			throw new NegocioException("Id não pode ser menor ou igual a 0");
		}
		return aRepository.postAcessorio(acessorio);
	}
	
	public Acessorio postAcessorio(Acessorio acessorio) {
		return aRepository.postAcessorio(acessorio);
	}
	
	public void deleteAcessorio(Long id) {
		if (id <= 0) {
			throw new NegocioException("Id não pode ser menor ou igual a 0");
		}
		aRepository.deleteAcessorio(id);
	}

}
