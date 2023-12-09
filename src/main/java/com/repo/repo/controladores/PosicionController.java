package com.repo.repo.controladores;

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

    @GetMapping("/buscar/{codigoEquipo}")
    public Posicion buscarEquipo(@PathVariable(name = "codigoEquipo")int codigoEquipo){
        return this.posicionServiceImpl.obtenerTablaPosicion(codigoEquipo);
    }
}