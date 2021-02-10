package com.automatoDev.locadora.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.automatoDev.locadora.model.Motorista;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MotoristaRepository {
    
    @PersistenceContext 
    private EntityManager entityManager;



    public List<Motorista> getAll(){
        Query query = entityManager.createQuery("from tb_motorista");
        return query.getResultList();
    }

    public Motorista getById(long id){
        return entityManager.find(Motorista.class, id);
    }

    public Motorista getByCnh(String cnh){
        Query query = entityManager.createQuery("select m from tb_motorista m where cnh = "+cnh);
        if(query.getResultList().size() != 0)
            return (Motorista)query.getResultList().get(0);
        else
            return null;
       
    }

    public Motorista persistMotorista(Motorista motorista){
        return entityManager.merge(motorista);
    }

    public void deleteMotorista(Motorista motorista){
        entityManager.remove(motorista);
    }

}
