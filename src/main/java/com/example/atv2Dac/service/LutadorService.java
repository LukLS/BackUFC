package com.example.atv2Dac.service;

import com.example.atv2Dac.dao.LutadorDAO;
import com.example.atv2Dac.model.Lutador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LutadorService {

    @Autowired
    private LutadorDAO lutadorDAO;

    public List<Lutador> getLutadores() {
        List<Lutador> list = lutadorDAO.findAll();
        return list;
    }

    public Lutador getLutador(Long id){
      Optional<Lutador> optional = lutadorDAO.findById(id);
      return optional.get();
    }

    public Lutador save(String nome, String cartel) {
        Lutador lutador = new Lutador(nome, cartel);
        return lutadorDAO.save(lutador);
    }

    public void update(Long id,String nome, String cartel) {

        Optional<Lutador> optional = lutadorDAO.findById(id);
        if (optional.isPresent()) {
            Lutador db = optional.get();
            db.setCartel(cartel);
            db.setNome(nome);
            lutadorDAO.save(db);
        } else {
            throw new RuntimeException("Não foi possível atualizar o registro");

        }
    }

    public void delete(Long id){
        lutadorDAO.deleteById(id);
    }

}