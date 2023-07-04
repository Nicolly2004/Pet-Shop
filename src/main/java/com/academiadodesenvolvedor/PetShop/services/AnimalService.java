package com.academiadodesenvolvedor.PetShop.services;


import com.academiadodesenvolvedor.PetShop.models.Animal;
import com.academiadodesenvolvedor.PetShop.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {


    @Autowired
    private AnimalRepository animalRepository;


    public Animal cadastraAnimal(Animal animal){
       return animalRepository.save(animal);
    }

    public Animal atualizaAnimal(Animal animal){
        return animalRepository.save(animal);
    }

    public void apagaAnimal(long id){
         animalRepository.delete(obterPorId(id));
    }

    public List<Animal> listarAnimal(){
        return animalRepository.findAll();
    }


    public Animal obterPorId(long id){
        Optional<Animal> animal = animalRepository.findById(id);

        if(animal.isPresent()){
            return animal.get();
        }
        return null;
    }

}
