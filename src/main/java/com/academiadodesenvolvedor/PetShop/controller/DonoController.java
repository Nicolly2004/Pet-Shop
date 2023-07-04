package com.academiadodesenvolvedor.PetShop.controller;

import com.academiadodesenvolvedor.PetShop.dtos.DonoDTO;
import com.academiadodesenvolvedor.PetShop.form.DonoForm;
import com.academiadodesenvolvedor.PetShop.models.Dono;
import com.academiadodesenvolvedor.PetShop.repositories.DonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donos")
public class DonoController {

    @Autowired
    private DonoRepository donoRepository;


    @PostMapping
    public ResponseEntity<DonoDTO> store(@RequestBody DonoForm form){
        Dono dono = form.convert();
        this.donoRepository.save(dono);
        return new ResponseEntity<>(new DonoDTO(dono), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DonoDTO>> listarDonos(){
        List<Dono> donos = this.donoRepository.findAll();
        List<DonoDTO> donoDTOList = donos.stream().map(DonoDTO::new).toList();

        return new ResponseEntity<>(donoDTOList,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonoDTO> update(@PathVariable Long id, @RequestBody DonoForm form){
        Optional<Dono> dono = this.donoRepository.findById(id);

        if (dono.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Dono donoupdated = form.update(dono.get());
        this.donoRepository.save(donoupdated);
        return  new ResponseEntity<>(new DonoDTO(donoupdated),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DonoDTO> show(@PathVariable Long id){
        Optional<Dono> dono = this.donoRepository.findById(id);

        if (dono.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.donoRepository.delete(dono.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
