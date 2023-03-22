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

	public Long getEdicao() {
		return edicao;
	}

	public void setEdicao(Long edicao) {
		this.edicao = edicao;
	}

	public List<Lutador> getLutaPrincipal() {
		return lutaPrincipal;
	}

	public void setLutaPrincipal(List<Lutador> lutaPrincipal) {
		this.lutaPrincipal = lutaPrincipal;
	}

	public List<Lutador> getLutaPreliminar() {
		return lutaPreliminar;
	}

	public void setLutaPreliminar(List<Lutador> lutaPreliminar) {
		this.lutaPreliminar = lutaPreliminar;
	}

    public UFC() {
    	
    }
    
}
