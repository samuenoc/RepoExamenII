package com.repo.repo.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repo.repo.modelos.Posicion;
import com.repo.repo.repositorios.PosicionRepository;
import com.repo.repo.servicios.PosicionService;
@Service
public class PosicionServiceImpl implements PosicionService {

    @Autowired
    private PosicionRepository posicionRepository;
    @Override
    public List<Posicion> obtenerTablaPosicion() {
        return this.posicionRepository.findAll();
    }
    
}
