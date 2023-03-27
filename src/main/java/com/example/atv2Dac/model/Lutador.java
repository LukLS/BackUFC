package com.example.atv2Dac.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Lutador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cartel;

    public Lutador( String nome, String cartel) {
        this.nome = nome;
        this.cartel = cartel;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCartel() {
		return cartel;
	}

	public void setCartel(String cartel) {
		this.cartel = cartel;
	}

	public Lutador() {
		
	}
    
    

}
