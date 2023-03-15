package com.example.atv2Dac.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class UFC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long edicao;

    @ManyToMany
    @JoinTable(name = "LutaPrincipal",
                joinColumns = @JoinColumn(name = "ufc"),
                inverseJoinColumns = @JoinColumn(name = "lutador"))
    private List<Lutador> lutaPrincipal;

    @ManyToMany
    @JoinTable(name = "LutaPreliminar",
            joinColumns = @JoinColumn(name = "ufc"),
            inverseJoinColumns = @JoinColumn(name = "lutador"))
    private List<Lutador> lutaPreliminar;

    public UFC(Long edicao, List<Lutador> lutaPrincipal, List<Lutador> lutaPreliminar) {
        this.edicao = edicao;
        this.lutaPrincipal = lutaPrincipal;
        this.lutaPreliminar = lutaPreliminar;
    }

}
