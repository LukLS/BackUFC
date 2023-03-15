package com.example.atv2Dac.controller;

import com.example.atv2Dac.model.Lutador;
import com.example.atv2Dac.service.LutadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class LutadorController {
    @Autowired
    private LutadorService lutadorService;

    public void save(String nome, String cartel){
        lutadorService.save(nome, cartel);
    }

    public List<Lutador> getLutadores(){
       return lutadorService.getLutadores();
    }

    public Lutador getLutador(Long id){
        Lutador lutador= lutadorService.getLutador(id);
        return lutador;
    }

    public void update(Long id, String nome, String cartel){
        lutadorService.update(id, nome, cartel);
    }

    public void delete(Long id){
        lutadorService.delete(id);
    }
}
