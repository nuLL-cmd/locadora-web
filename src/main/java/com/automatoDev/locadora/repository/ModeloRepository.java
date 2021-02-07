package com.automatoDev.locadora.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.From;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.automatoDev.locadora.handle.NegocioException;
import com.automatoDev.locadora.model.Modelo;

@SuppressWarnings("unchecked")
@Transactional
@Repository
public class ModeloRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Modelo persistModelo(Modelo modelo) {
		return entityManager.merge(modelo);
	}
	

	public List<Modelo> getAll(){
		Query query = entityManager.createQuery("from tb_modelo", Modelo.class);
		return query.getResultList();
	}
	
	public Modelo getByChassi(Integer chassi) {
		Query query = entityManager.createQuery("from tb_modelo where chassi_modelo ="+chassi, Modelo.class);
		if(query.getResultList().size() != 0)
			return  (Modelo)query.getResultList().get(0);
		else
			return null ;
	}
	
	public Modelo getById(Long id) {
		return entityManager.find(Modelo.class, id);
	}
	
	
	public void deleteModelo(Long id) {
		Modelo modeloTemp = entityManager.find(Modelo.class, id);
		if(modeloTemp != null) {
			entityManager.remove(modeloTemp);
			return;
		}
		throw new NegocioException("Item não encontrado");
		
	}
	
	
}
