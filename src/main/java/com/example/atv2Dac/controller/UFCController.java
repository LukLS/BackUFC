package com.example.atv2Dac.controller;

import com.example.atv2Dac.model.Lutador;
import com.example.atv2Dac.model.UFC;
import com.example.atv2Dac.service.UFCservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UFCController {

    @Autowired
    private UFCservice ufcservice;

    public void save(Long edicao, List<Lutador> lutadoresPrincipal, List<Lutador> lutadoresPreliminar){
        ufcservice.save(edicao, lutadoresPrincipal, lutadoresPreliminar);
    }

    public List<UFC> getUFC(){
       return ufcservice.getUFC();
    }
    public UFC busca(Long id){
        return ufcservice.busca(id);
    }

    public void update(Long id,Long edicao, List<Lutador> lutadoresPrincipal, List<Lutador> lutadoresPreliminar){
        ufcservice.update(id, edicao,lutadoresPrincipal, lutadoresPreliminar);
    }

    public void delete(Long id){
        ufcservice.delete(id);
    }


}
