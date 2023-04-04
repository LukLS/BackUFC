package com.example.atv2Dac.model;


import javax.persistence.*;
import java.util.List;


@Entity
public class UFC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long edicao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "LutaPrincipal",
                joinColumns = @JoinColumn(name = "ufc"),
                inverseJoinColumns = @JoinColumn(name = "lutador"))
    private List<Lutador> lutaPrincipal;


    public UFC(Long edicao, List<Lutador> lutaPrincipal, List<Lutador> lutaPreliminar) {
        this.edicao = edicao;
        this.lutaPrincipal = lutaPrincipal;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

    public UFC() {
    	
    }

	@Override
	public String toString() {
		return "UFC{" +
				"id=" + id +
				", edicao=" + edicao +
				", lutaPrincipal=" + lutaPrincipal +
				'}';
	}
}
