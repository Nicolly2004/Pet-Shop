package com.academiadodesenvolvedor.PetShop.dtos;

import com.academiadodesenvolvedor.PetShop.models.Dono;
import lombok.Data;

@Data
public class DonoDTO {

    private Long id;

    private String nome;

    private String telefone;

    private String cpf;

    private String endereco;

    public DonoDTO(Dono dono){
        this.id = dono.getId();
        this.nome = dono.getNome();
        this.telefone = dono.getTelefone();
        this.cpf = dono.getCpf();
        this.endereco = dono.getEndereco();
    }
}
