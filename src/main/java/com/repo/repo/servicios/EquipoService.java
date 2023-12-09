package com.repo.repo.servicios;

import com.repo.repo.modelos.Equipo;

public interface EquipoService {
    public Equipo crearEquipo(Equipo equipo);

    public void eliminarEquipo(int codigoEquipo);
    
    public Equipo buscarEquipo(int codigoEquipo );

}
