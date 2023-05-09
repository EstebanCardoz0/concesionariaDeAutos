package com.concesionaria.concesionaria.service;

import java.util.List;

import com.concesionaria.concesionaria.entity.Auto;
import com.concesionaria.concesionaria.exception.MiException;

public interface IAutoService {
    
public void crearAuto(Auto auto) ;

public List <Auto> listarAutos ();

public Auto modificarAuto(Auto auto);

public void borrarAuto(Long id);

public Auto traerAuto (Long id);


}
