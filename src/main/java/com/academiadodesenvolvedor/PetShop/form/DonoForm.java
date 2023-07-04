package com.academiadodesenvolvedor.PetShop.form;

import com.academiadodesenvolvedor.PetShop.models.Dono;
import jakarta.annotation.Nonnull;
import lombok.Data;

@Data
public class DonoForm {
    @Nonnull
    private String nome;

    @Nonnull
    private String telefone;

    @Nonnull
    private String cpf;

    @Nonnull
    private String endereco;

    public Dono convert(){
        Dono dono = new Dono();
        dono.setNome(nome);
        dono.setTelefone(telefone);
        dono.setCpf(cpf);
        dono.setEndereco(endereco);

        return dono;
    }

    public Dono update(Dono dono){
        dono.setNome(nome);
        dono.setTelefone(telefone);
        dono.setCpf(cpf);
        dono.setEndereco(endereco);

        return dono;
    }


}
