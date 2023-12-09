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
            // Crear al menos 6 equipos si no existen
            // Aquí debes implementar la lógica para crear equipos de forma aleatoria o según tus necesidades
            // Puedes usar equipoRepository.save(new Equipo(...)) para guardar nuevos equipos
        }

        // Simular partidos
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

        int golesEquipoA = random.nextInt(4); // Número aleatorio de goles para equipoA (0-3)
        int golesEquipoB = random.nextInt(4); // Número aleatorio de goles para equipoB (0-3)

        int puntosEquipoA, puntosEquipoB;

        if (golesEquipoA == golesEquipoB) {
            // Empate
            puntosEquipoA = puntosEquipoB = 1;
        } else if (golesEquipoA > golesEquipoB) {
            // EquipoA gana
            puntosEquipoA = 3;
            puntosEquipoB = 0;
        } else {
            // EquipoB gana
            puntosEquipoA = 0;
            puntosEquipoB = 3;
        }

        // Actualizar estadísticas de Posiciones para EquipoA
        actualizarPosicion(equipoA, golesEquipoA, golesEquipoB, puntosEquipoA);

        // Actualizar estadísticas de Posiciones para EquipoB
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
 

