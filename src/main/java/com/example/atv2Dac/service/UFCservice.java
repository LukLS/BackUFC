package com.example.atv2Dac.service;

import com.example.atv2Dac.dao.UFCDAO;
import com.example.atv2Dac.model.Lutador;
import com.example.atv2Dac.model.UFC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UFCservice {

    @Autowired
    private UFCDAO UFCdao;

    public List<UFC> getUFC() {
        List<UFC> list = UFCdao.findAll();
        return list;
    }

    public UFC busca(Long id){
       Optional<UFC> optional = UFCdao.findById(id);
       return optional.get();
    }

    public void save(Long edicao, List<Lutador> lutadoresPrincipal, List<Lutador> lutadoresPreliminar) {
        UFC ufc = new UFC();
        if (ufc != null) {
            ufc.setEdicao(edicao);
            ufc.setLutaPrincipal(lutadoresPrincipal);
            ufc.setLutaPreliminar(lutadoresPreliminar);
            UFCdao.save(ufc);
        } else {
            throw new RuntimeException("Não foi possível salvar o registro");

        }
    }

    public void update(Long id,Long edicao, List<Lutador> lutadoresPrincipal, List<Lutador> lutadoresPreliminar) {

        Optional<UFC> optional = UFCdao.findById(id);
        if (optional.isPresent()) {
            UFC db = optional.get();
            db.setEdicao(edicao);
            db.setLutaPrincipal(lutadoresPrincipal);
            db.setLutaPreliminar(lutadoresPreliminar);
            UFCdao.save(db);
        } else {
            throw new RuntimeException("Não foi possível atualizar o registro");

        }
    }

    public void delete(Long id){
       UFCdao.deleteById(id);
    }



}
