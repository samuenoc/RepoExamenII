package com.repo.repo.controladores;

import org.springframework.web.bind.annotation.RestController;

import com.repo.repo.modelos.Equipo;
import com.repo.repo.servicios.impl.EquipoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/equipo")
public class EquipoController {
    
    @Autowired
    EquipoServiceImpl equipoServiceImpl;

    @PostMapping("/crear")
    public Equipo crearEquipo(@RequestBody Equipo nvoEquipo){
        return this.equipoServiceImpl.crearEquipo(nvoEquipo);
    }

    @GetMapping("/buscar/{codigoEquipo}")
    public Equipo buscarEquipo(@PathVariable(name = "codigoEquipo")int codigoEquipo){
        return this.equipoServiceImpl.buscarEquipo(codigoEquipo);
    }

    @DeleteMapping("/eliminar/{codigoEquipo}")
    public String eliminarEquipo(@PathVariable int codigoEquipo){
         this.equipoServiceImpl.eliminarEquipo(codigoEquipo);
         return "Equipo eliminado con éxito";
    }
}
