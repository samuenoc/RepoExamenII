package com.repo.repo.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posiciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Posicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "empates")
    private int empates;
    
    @Column(name = "ganados")
    private int ganados;

    @Column(name = "perdidos")
    private int perdidos;     

    @Column(name = "golesfavor")
    private int golesFavor;

    @Column(name = "golescontra")
    private int golesContra;
    
    @Column(name = "puntos")   
    private int puntos;

    @OneToOne
    @JoinColumn(name = "codidoequipo")
    private Equipo equipo;
}
