package com.automatoDev.locadora.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.automatoDev.locadora.handle.NegocioException;
import com.automatoDev.locadora.model.Motorista;
import com.automatoDev.locadora.repository.MotoristaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository mRepository;


    public ResponseEntity<List<Motorista>> getAll(){
        return ResponseEntity.ok(mRepository.getAll());
    }

    public ResponseEntity<Motorista> getById(Long id){
        if(id >= 0){
            return ResponseEntity.ok(mRepository.getById(id));
        }

        throw new NegocioException("Id não pode ser menor ou igual a 0");
    }

    public ResponseEntity<Motorista> persistMotorista(Motorista motorista){
        Motorista m = mRepository.getByCnh(motorista.getCnh());
        if(m == null){
            return ResponseEntity.ok(mRepository.persistMotorista(motorista));
        }
        throw new NegocioException("Já existe um motorista com esta mesma cnh");
    }


    public ResponseEntity<Motorista> updateMotorista(Motorista motorista){
        Motorista m =getById(motorista.getIdMotorista()).getBody();

        if(m !=  null){
            return ResponseEntity.ok(mRepository.persistMotorista(motorista));
        }
       
        throw new NegocioException("Registro não encontrado para edição!");
    }

    public void deleteMotorista(Long id){
        if(id >=0){
            Motorista m = getById(id).getBody();
            if(m != null){
                mRepository.deleteMotorista(m);
                return;
            }

            throw new NegocioException("Item não encontrado para deleção");
        }

        throw new NegocioException("Id não pode ser menor ou igual a 0");
     
    }
    
}
