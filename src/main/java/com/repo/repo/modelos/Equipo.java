package com.repo.repo.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipo {
    @Id
    @Column(name = "codigoequipo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoEquipo;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "ataque")
    private Double ataque;
    
    @Column(name = "defensa")
    private double defensa;


    
}
