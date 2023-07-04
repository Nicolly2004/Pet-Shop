package com.academiadodesenvolvedor.PetShop.dtos;

import com.academiadodesenvolvedor.PetShop.models.Animal;
import lombok.Data;

import java.util.Date;

@Data
public class AnimalDTO {
    private Long id;

    private String nome;

    private String raca;

    private String cor;

    private int idade;

    private Double tamanho;

    private  Double peso;




    public AnimalDTO(Animal animal){
        this.id = animal.getId();
        this.nome = animal.getNome();
        this.raca = animal.getRaca();
        this.cor = animal.getCor();
        this.idade = animal.getIdade();
        this.tamanho = animal.getTamanho();
        this.peso = animal.getPeso();
    }

}
