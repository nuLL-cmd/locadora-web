package com.automatoDev.locadora.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.automatoDev.locadora.model.Aluguel;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class AluguelRepository {
    

    @PersistenceContext
    private EntityManager entityManager;


    public List<Aluguel> getAll(){
        Query query = entityManager.createQuery("from tb_aluguel");
        return query.getResultList();
    }

    public Aluguel getById(long id){
        return entityManager.find(Aluguel.class,id);
    }

    public Aluguel persistAluguel(Aluguel aluguel){
        return entityManager.merge(aluguel);
    }

    public void deleteAlugue(Aluguel aluguel){
        entityManager.remove(aluguel);
    }



}
