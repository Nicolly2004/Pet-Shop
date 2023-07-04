package com.academiadodesenvolvedor.PetShop.services;

import com.academiadodesenvolvedor.PetShop.models.Dono;
import com.academiadodesenvolvedor.PetShop.repositories.DonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonoService {

    @Autowired
    private DonoRepository donoRepository;

    public Dono cadastraDono(Dono dono){
        return donoRepository.save(dono);
    }

    public Dono atualizaDono(Dono dono){
        return donoRepository.save(dono);
    }

    public void apagaDono(long id){
        donoRepository.delete(obterPorId(id));
    }

    public List<Dono> listarDono(){
        return donoRepository.findAll();
    }

    public Dono obterPorId(long id){
        Optional<Dono> dono = donoRepository.findById(id);

        if(dono.isPresent()){
            return dono.get();
        }
        return null;
    }

}
