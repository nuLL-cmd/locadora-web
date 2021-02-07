package com.automatoDev.locadora.controller;

import java.util.List;

import javax.validation.Valid;

import com.automatoDev.locadora.model.Aluguel;
import com.automatoDev.locadora.service.AluguelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aluguel")
public class AluguelController {

    @Autowired
    private AluguelService aService;



    @GetMapping
    public List<Aluguel> getAll(){
        return aService.getAll();
    }

    @PostMapping("new")
    public Aluguel persistAluguel(@Valid @RequestBody Aluguel aluguel){
        return aService.persistAluguel(aluguel);
    }

    @GetMapping("{id}")
    public Aluguel getById(@PathVariable("id") Long id){
        return aService.getById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteAluguel(@PathVariable("id") Long id){
        aService.deleteAluguel(id);
    }

    @PutMapping("edit")
    public Aluguel putAluguel(@RequestBody Aluguel aluguel){
        return aService.putAluguel(aluguel);
    }

    
}
