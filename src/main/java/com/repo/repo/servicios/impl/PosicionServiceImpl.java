package com.repo.repo.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.repo.repo.modelos.Posicion;
import com.repo.repo.repositorios.PosicionRepository;
import com.repo.repo.servicios.PosicionService;

public class PosicionServiceImpl implements PosicionService {
    @Autowired PosicionRepository posicionRepository;
    @Override
    public Posicion obtenerTablaPosicion(int codigoEquipo) {
        Posicion posicion = this.posicionRepository.findById(codigoEquipo).get();
        return posicion;
    }
}