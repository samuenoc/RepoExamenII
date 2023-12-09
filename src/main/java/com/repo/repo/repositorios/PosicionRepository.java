package com.repo.repo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repo.repo.modelos.Posicion;

public interface PosicionRepository extends JpaRepository<Posicion, Integer>{

    Posicion findByEquipoCodigoEquipo(int codigoEquipo);

    
    
}
