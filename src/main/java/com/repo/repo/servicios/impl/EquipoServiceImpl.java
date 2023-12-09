package com.repo.repo.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repo.repo.modelos.Equipo;
import com.repo.repo.modelos.Posicion;
import com.repo.repo.repositorios.EquipoRepository;
import com.repo.repo.repositorios.PosicionRepository;
import com.repo.repo.servicios.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;
    @Autowired
    private PosicionRepository posicionRepository;

    @Override
    public Equipo crearEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public void eliminarEquipo(int codigoEquipo) {
        // Verificar si hay un registro en la tabla de posiciones
        Posicion posicion = posicionRepository.findByEquipoCodigoEquipo(codigoEquipo);
        if (posicion != null) {
            throw new RuntimeException("No se puede eliminar el equipo. Tiene un registro en la tabla de posiciones.");
        }
        // Si no hay un registro en la tabla de posiciones, eliminar el equipo
        equipoRepository.deleteById(codigoEquipo);
    }
    
    @Override
    public Equipo buscarEquipo(int codigoEquipo) {
        return this.equipoRepository.findById(codigoEquipo).get();
    }
}
