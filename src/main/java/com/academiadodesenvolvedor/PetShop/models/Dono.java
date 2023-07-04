package com.academiadodesenvolvedor.PetShop.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

public class Dono {
    @OneToOne
    private Animal animal;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String cpf;

    private String endereco;

}
