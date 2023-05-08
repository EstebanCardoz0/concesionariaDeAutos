package com.consesionaria.consesionaria.service;

import java.util.List;

import com.consesionaria.consesionaria.entity.Auto;
import com.consesionaria.consesionaria.exception.MiException;

public interface IAutoService {
    
public void crearAuto(Auto auto) ;

public List <Auto> listarAutos ();

public Auto modificarAuto(Auto auto);

public void borrarAuto(Long id);

public Auto traerAuto (Long id);


}
