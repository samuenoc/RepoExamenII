package com.repo.repo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repo.repo.modelos.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Integer > {
    
}
