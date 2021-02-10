package com.automatoDev.locadora.controller;

import java.util.List;

import com.automatoDev.locadora.model.Motorista;
import com.automatoDev.locadora.service.MotoristaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("motorista")
public class MotoristaController {
    
    @Autowired 
    private MotoristaService mService;

    @GetMapping
    public ResponseEntity<List<Motorista>> getAll(){
        return mService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Motorista> getById(@PathVariable("id") Long id){
        return mService.getById(id);
    }

    @PostMapping("new")
    public ResponseEntity<Motorista> persistMotorista(@RequestBody Motorista motorista){
        return mService.persistMotorista(motorista);
    }

    @PutMapping("edit")
    public ResponseEntity<Motorista> putMotorista(@RequestBody Motorista motorista){
        return mService.updateMotorista(motorista);
    }


    @DeleteMapping("delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteMotorista(@PathVariable("id") Long id){
        mService.deleteMotorista(id);
    }

    
}
