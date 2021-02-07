package com.automatoDev.locadora.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.automatoDev.locadora.handle.NegocioException;
import com.automatoDev.locadora.model.Acessorio;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class AcessorioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Acessorio> getAll(){
		Query query = entityManager.createQuery("from tb_acessorio");
		return query.getResultList();
	}
	
	public Acessorio getById(Long id) {
		return entityManager.find(Acessorio.class, id);
	}
	
	public Acessorio postAcessorio(Acessorio acessorio) {
		return entityManager.merge(acessorio);
	}
	
	public void deleteAcessorio(Long id) {
		Acessorio a = entityManager.find(Acessorio.class, id);
		if(a != null) {
			entityManager.remove(a);
			return;
		}
		
		throw new NegocioException("Item não encontrado para deleção");
	}
}
