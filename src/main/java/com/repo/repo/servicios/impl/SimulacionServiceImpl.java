package com.repo.repo.servicios.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repo.repo.modelos.Equipo;
import com.repo.repo.modelos.Posicion;
import com.repo.repo.repositorios.EquipoRepository;
import com.repo.repo.repositorios.PosicionRepository;
import com.repo.repo.servicios.SimulacionService;

@Service
public class SimulacionServiceImpl implements SimulacionService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private PosicionRepository posicionRepository;

    @Override
    public void simularPartidos() {
          List<Equipo> equipos = equipoRepository.findAll();

        if (equipos.size() < 6) {
           
        }


        for (Equipo equipoA : equipos) {
            for (Equipo equipoB : equipos) {
                if (!equipoA.equals(equipoB)) {
                    simularEncuentro(equipoA, equipoB);
                }
            }
        }
        }
        private void simularEncuentro(Equipo equipoA, Equipo equipoB) {
        Random random = new Random();

        int golesEquipoA = random.nextInt(4); 
        int golesEquipoB = random.nextInt(4); 

        int puntosEquipoA, puntosEquipoB;

        if (golesEquipoA == golesEquipoB) {
           
            puntosEquipoA = puntosEquipoB = 1;
        } else if (golesEquipoA > golesEquipoB) {
          
            puntosEquipoA = 3;
            puntosEquipoB = 0;
        } else {
           
            puntosEquipoA = 0;
            puntosEquipoB = 3;
        }

     
        actualizarPosicion(equipoA, golesEquipoA, golesEquipoB, puntosEquipoA);

      
        actualizarPosicion(equipoB, golesEquipoB, golesEquipoA, puntosEquipoB);
        
    }

    private void actualizarPosicion(Equipo equipo, int golesFavor, int golesContra, int puntos) {
        Posicion posicion = posicionRepository.findByEquipoCodigoEquipo(equipo.getCodigoEquipo());

        if (posicion == null) {
            posicion = new Posicion();
            posicion.setEquipo(equipo);
        }

        posicion.setGolesFavor(posicion.getGolesFavor() + golesFavor);
        posicion.setGolesContra(posicion.getGolesContra() + golesContra);
        posicion.setPuntos(posicion.getPuntos() + puntos);

        posicionRepository.save(posicion);
    }
    
}
 

