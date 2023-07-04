package com.academiadodesenvolvedor.PetShop.form;

import com.academiadodesenvolvedor.PetShop.models.Animal;
import jakarta.annotation.Nonnull;
import lombok.Data;

@Data
public class AnimalForm {
    @Nonnull
    private String nome;
    @Nonnull
    private String raca;
    @Nonnull
    private String cor;
    @Nonnull
    private int idade;
    @Nonnull
    private Double tamanho;
    @Nonnull
    private  Double peso;

    public Animal convert(){
        Animal animal = new Animal();
        animal.setNome(nome);
        animal.setRaca(raca);
        animal.setCor(cor);
        animal.setIdade(idade);
        animal.setTamanho(tamanho);
        animal.setPeso(peso);

        return animal;

    }

    public Animal update(Animal animal){
        animal.setNome(nome);
        animal.setRaca(raca);
        animal.setCor(cor);
        animal.setIdade(idade);
        animal.setTamanho(tamanho);
        animal.setPeso(peso);

        return  animal;
    }

}

