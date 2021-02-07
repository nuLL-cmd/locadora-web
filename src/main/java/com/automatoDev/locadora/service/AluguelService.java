package com.automatoDev.locadora.service;

import java.util.List;

import com.automatoDev.locadora.handle.NegocioException;
import com.automatoDev.locadora.model.Aluguel;
import com.automatoDev.locadora.repository.AluguelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AluguelService {
    
    @Autowired
    private AluguelRepository aRepository;


    public List<Aluguel> getAll(){
        return aRepository.getAll();
    }

    public Aluguel getById(Long id){
        if(id >= 0){
            return aRepository.getById(id);
        }
        throw new NegocioException("Id não pode ser menor ou igual 0");
      
    }

    public Aluguel persistAluguel(Aluguel aluguel){
        return aRepository.persistAluguel(aluguel);
    }

    public Aluguel putAluguel(Aluguel aluguel){

        if(aluguel.getIdAluguel() >= 0){
            Aluguel aluguelFind = aRepository.getById(aluguel.getIdAluguel());
            if(aluguelFind != null){
                return aRepository.persistAluguel(aluguel);
            }
            throw new NegocioException("Item não encontrado pra edição");
            
        }

        throw new NegocioException("Id não pode ser menor ou igual a 0");

    }


    public void deleteAluguel(Long id){
        if(id >= 0){
            Aluguel aluguelFind  = aRepository.getById(id);
            if(aluguelFind != null)
                aRepository.deleteAlugue(aluguelFind);
            
            return;
    
        }

        throw new NegocioException("Id não pode ser menor ou igual 0");

    }


}
