package com.academiadodesenvolvedor.PetShop.controller;

import com.academiadodesenvolvedor.PetShop.dtos.AnimalDTO;
import com.academiadodesenvolvedor.PetShop.form.AnimalForm;
import com.academiadodesenvolvedor.PetShop.models.Animal;
import com.academiadodesenvolvedor.PetShop.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @PostMapping
    public ResponseEntity<AnimalDTO> store(@RequestBody AnimalForm form){
      Animal animal = form.convert();
      this.animalRepository.save(animal);
      return new ResponseEntity<>(new AnimalDTO(animal), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> listarAnimais(){
        List<Animal> animais = this.animalRepository.findAll();
        List<AnimalDTO> animalDTOList = animais.stream().map(AnimalDTO::new ).toList();

        return new ResponseEntity<>(animalDTOList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalDTO> update(@PathVariable Long id, @RequestBody AnimalForm form){
       Optional<Animal> animal = this.animalRepository.findById(id);

       if(animal.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       Animal animalupdated = form.update(animal.get());
       this.animalRepository.save(animalupdated);
       return new ResponseEntity<>(new AnimalDTO(animalupdated),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AnimalDTO> show(@PathVariable Long id){
        Optional<Animal> animal = this.animalRepository.findById(id);

        if (animal.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.animalRepository.delete(animal.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
