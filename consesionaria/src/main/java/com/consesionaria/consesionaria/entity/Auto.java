package com.consesionaria.consesionaria.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auto {

    @Id     
    private Long id;
    private String modelo;
    private String marca;
    private String color;
    private String patente;
    private int cantidadPuertas;

}
