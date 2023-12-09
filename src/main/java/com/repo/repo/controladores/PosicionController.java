package com.repo.repo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repo.repo.modelos.Posicion;
import com.repo.repo.servicios.impl.PosicionServiceImpl;

@RestController
@RequestMapping("/api/posicion")
public class PosicionController {

    @Autowired
    PosicionServiceImpl posicionServiceImpl;

    @GetMapping("/todos")
    public List<Posicion> obtenerTablaPosicion(){
    
        return this.posicionServiceImpl.obtenerTablaPosicion();

    }
}