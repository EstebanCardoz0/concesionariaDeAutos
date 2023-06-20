package com.concesionaria.concesionaria.service;

import java.util.List;

import com.concesionaria.concesionaria.entity.Auto;
import com.concesionaria.concesionaria.exception.MiException;

public interface IAutoService {

        public void crearAuto(Auto auto) throws MiException;

        public List<Auto> listarAutos();


        public void cambiar(Long id, String modelo, String marca, String color,
                        String patente, Integer cantidadPuertas) throws MiException;

        public Auto getOne(Long id);

        public void validar(
                        String modelo,
                        String marca,
                        String color,
                        String patente,
                        Integer cantidadPuertas) throws MiException;
}
