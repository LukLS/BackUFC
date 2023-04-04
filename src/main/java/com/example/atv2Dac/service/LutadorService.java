package com.example.atv2Dac.service;

import com.example.atv2Dac.dao.LutadorDAO;
import com.example.atv2Dac.dto.LutadorDTO;
import com.example.atv2Dac.model.Lutador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LutadorService {

    @Autowired
    private LutadorDAO lutadorDAO;

    public List<LutadorDTO> getLutadores() {
        List<LutadorDTO> list = lutadorDAO.findAll().stream().map(LutadorDTO::create).collect(Collectors.toList());
        return list;
    }

    public LutadorDTO getLutador(Long id){
        Optional<Lutador> lutador = lutadorDAO.findById(id);
        return lutador.map(LutadorDTO::create).orElseThrow(() -> new IllegalArgumentException());
    }

    public LutadorDTO save(Lutador lutador) {
        Assert.isNull(lutador.getId(),"Não foi possível inserir o registro");
        return LutadorDTO.create(lutadorDAO.save(lutador));
    }

    public LutadorDTO update(Long id,Lutador lutador) {

        Optional<Lutador> optional = lutadorDAO.findById(id);
        if (optional.isPresent()) {
            Lutador db = optional.get();
            db.setCartel(lutador.getCartel());
            db.setNome(lutador.getNome());
            lutadorDAO.save(db);
            return LutadorDTO.create(db);
        } else {
            throw new RuntimeException("Não foi possível atualizar o registro");

        }
    }

    public void delete(Long id){
        Optional<Lutador> lutador = lutadorDAO.findById(id);
        lutadorDAO.deleteById(id);
    }

}