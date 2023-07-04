package com.academiadodesenvolvedor.PetShop.repositories;

import com.academiadodesenvolvedor.PetShop.models.Dono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonoRepository extends JpaRepository<Dono, Long>{
}
