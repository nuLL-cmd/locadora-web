package com.automatoDev.locadora.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.automatoDev.locadora.handle.NegocioException;
import com.automatoDev.locadora.model.Acessorio;
import com.automatoDev.locadora.model.Carro;

@Repository
@Transactional
public class CarroRepository {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Carro> getAll(){
		Query query = entityManager.createQuery("from tb_carro");
		return query.getResultList();
	}
	
	public Carro getById(Long id) {
		return entityManager.find(Carro.class, id);
	}
	
	public Carro postCarro(Carro carro) {
		return entityManager.merge(carro);
	}
	
	public void deleteCarro(Long id) {
		Carro c = entityManager.find(Carro.class, id);
			entityManager.remove(c);
			Query queryOne = entityManager.createNativeQuery("delete from tb_carro_acessorio where id_carro ="+id);
			Query queryTwo = entityManager.createNativeQuery("delete from tb_aluguel where id_carro ="+id);
			Query queryTree = entityManager.createNativeQuery("delete from tb_carro where id_carro ="+id);
	

			queryOne.executeUpdate();
			queryTwo.executeUpdate();
			queryTree.executeUpdate();

		//throw new NegocioException("Item não encontrado para deleção");
	}
	
}
