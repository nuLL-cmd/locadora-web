package com.automatoDev.locadora.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.automatoDev.locadora.handle.NegocioException;
import com.automatoDev.locadora.model.Fabricante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public class FabricanteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Fabricante> getAll(){
	Query query =  entityManager.createQuery("from tb_fabricante", Fabricante.class);
	return (List<Fabricante>) query.getResultList();
	}
	
	public Fabricante persistFabricante(Fabricante fabricante) {
		return entityManager.merge(fabricante);
	
	}
	
	public void deleteFabricante(Long id) {
		Fabricante fabricante = entityManager.find(Fabricante.class, id);
	if (fabricante != null) {
		entityManager.remove(fabricante);
		return;
	}
	
		throw new NegocioException("Item não encontrado!");
	}
	
}
