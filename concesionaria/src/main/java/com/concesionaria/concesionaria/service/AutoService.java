package com.concesionaria.concesionaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concesionaria.concesionaria.entity.Auto;
import com.concesionaria.concesionaria.exception.MiException;
import com.concesionaria.concesionaria.repository.IAutoRepository;

@Service
public class AutoService implements IAutoService {

    @Autowired
    IAutoRepository autoRepo;

    @Override
    @Transactional
    public void crearAuto(Auto auto) throws MiException {

        validar(auto.getModelo(), auto.getMarca(), auto.getColor(),
                auto.getPatente(), auto.getCantidadPuertas());
        autoRepo.save(auto);

    }

    @Override
    public List<Auto> listarAutos() {

        return autoRepo.findAll();
    }

    @Override
    @Transactional
    public Auto modificarAuto(Auto aut) throws MiException {

        validar(aut.getModelo(), aut.getMarca(), aut.getColor(),
                aut.getPatente(), aut.getCantidadPuertas());

        autoRepo.save(aut);

        return traerAuto(aut.getId());
    }

    @Override
    @Transactional
    public void borrarAuto(Long id) {

        autoRepo.deleteById(id);

    }

    @Override
    public Auto traerAuto(Long id) {

        return autoRepo.findById(id).orElse(null);

    }

    public void validar(
            String modelo,
            String marca,
            String color,
            String patente,
            Integer cantidadPuertas) throws MiException {

        // if (id == null) {
        // throw new MiException("El id no puede ser nulo");

        if (modelo.isEmpty() || modelo == null) {
            throw new MiException("El modelo no puede ser nulo o estar vacío");
        }
        if (marca.isEmpty() || marca == null) {
            throw new MiException("La marca no puede ser nula o estar vacía");
        }
        if (color.isEmpty() || color == null) {
            throw new MiException("El color no puede ser nulo o estar vacía");
        }
        if (patente.isEmpty() || patente == null) {
            throw new MiException("La patente no puede ser nula o estar vacía");
        }
        if (cantidadPuertas == null) {
            throw new MiException("La cantidad de puertas no puede ser nula");
        }

    }

    @Override
    public Auto getOne(Long id) {
        return autoRepo.getOne(id);
    }

    @Override
    @Transactional
    public void cambiar(Long id, String modelo, String marca, String color,
            String patente, Integer cantidadPuertas) throws MiException {

        validar(modelo, marca, color, patente, cantidadPuertas);

        Optional<Auto> respuesta = autoRepo.findById(id);

        if (respuesta.isPresent()) {
            Auto auto = respuesta.get();
            auto.setModelo(modelo);
            auto.setMarca(marca);
            auto.setColor(color);
            auto.setPatente(patente);
            auto.setCantidadPuertas(cantidadPuertas);

            autoRepo.save(auto);
        }

    }
}
