package com.repo.repo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repo.repo.servicios.impl.SimulacionServiceImpl;

@RestController
@RequestMapping("/api/simulacion")
public class SimulacionController {
    @Autowired
    private SimulacionServiceImpl simulacionPartidosServiceImpl;

    @PostMapping("/simular")
    public String simularPartidos() {
        simulacionPartidosServiceImpl.simularPartidos();
        return "Partidos simulados con éxito";
    }
}
