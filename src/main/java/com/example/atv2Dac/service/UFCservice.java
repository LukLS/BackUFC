package com.example.atv2Dac.service;

import com.example.atv2Dac.dao.UFCDAO;
import com.example.atv2Dac.dto.LutadorDTO;
import com.example.atv2Dac.dto.UFCDTO;
import com.example.atv2Dac.model.UFC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UFCservice {

    @Autowired
    private UFCDAO UFCdao;

    public List<UFCDTO> getUFC() {
        List<UFCDTO> list = UFCdao.findAll().stream().map(UFCDTO::create).collect(Collectors.toList());
        return list;
    }

    public UFCDTO busca(Long id){
       Optional<UFC> ufc = UFCdao.findById(id);
        return ufc.map(UFCDTO::create).orElseThrow(() -> new IllegalArgumentException());
    }

    public UFCDTO save(UFC ufc) {
        Assert.isNull(ufc.getId(),"Não foi possível inserir o registro");

        return UFCDTO.create(UFCdao.save(ufc));
    }

    public UFCDTO update(Long id,UFC ufc) {

        Optional<UFC> optional = UFCdao.findById(id);
        if (optional.isPresent()) {
            UFC db = optional.get();
            db.setEdicao(ufc.getEdicao());
            db.setLutaPrincipal(ufc.getLutaPrincipal());
            UFCdao.save(db);
            return UFCDTO.create(db);

        } else {
            throw new RuntimeException("Não foi possível atualizar o registro");
        }

    }

    public void delete(Long id){
       UFCdao.deleteById(id);
    }



}
