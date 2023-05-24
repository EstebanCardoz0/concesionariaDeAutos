package com.concesionaria.concesionaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concesionaria.concesionaria.entity.Auto;
import com.concesionaria.concesionaria.exception.MiException;
import com.concesionaria.concesionaria.service.IAutoService;

@RestController
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    IAutoService autoSer;

    @PostMapping("/crear")
    public String crearAuto(@RequestBody Auto auto) throws MiException {
        validar(auto.getId(), auto.getModelo(), auto.getMarca(),
                auto.getColor(), auto.getPatente(), auto.getCantidadPuertas());

        autoSer.crearAuto(auto);
        return "Auto creado exitosamente";
    }

    @GetMapping("/listar")
    public List<Auto> listarAutos() {

        return autoSer.listarAutos();
    }

    @GetMapping("/traer/{id}")
    public Auto traerAuto(@PathVariable Long id) {

        return autoSer.traerAuto(id);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarAuto(@PathVariable Long id) {

        autoSer.borrarAuto(id);
        return "Auto borrado exitosamente";
    }

    @PutMapping("/modificar")
    public Auto modificarAuto(@RequestBody Auto auto) {

        return autoSer.modificarAuto(auto);
    }

    public void validar(Long id,
            String modelo,
            String marca,
            String color,
            String patente,
            int cantidadPuertas) throws MiException {

        if (id == null) {
            throw new MiException("El id no puede ser nulo");
        }
        if (modelo.isEmpty()) {
            throw new MiException("El modelo no puede ser nulo o estar vacío");
        }
        if (marca.isEmpty()) {
            throw new MiException("La marca no puede ser nula o estar vacía");
        }
        if (color.isEmpty()) {
            throw new MiException("El color no puede ser nulo o estar vacía");
        }
        if (patente.isEmpty()) {
            throw new MiException("La patente no puede ser nula o estar vacía");
        }

    }

}
