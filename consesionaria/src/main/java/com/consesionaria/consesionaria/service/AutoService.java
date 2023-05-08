package com.consesionaria.consesionaria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consesionaria.consesionaria.entity.Auto;
import com.consesionaria.consesionaria.repository.IAutoRepository;

@Service
public class AutoService implements IAutoService {

    @Autowired
    IAutoRepository autoRepo;

    @Override @Transactional
    public void crearAuto(Auto auto)  {



        autoRepo.save(auto);

    }

    @Override
    public List<Auto> listarAutos() {

        return autoRepo.findAll();
    }

    @Override @Transactional
    public Auto modificarAuto(Auto aut) {
       
        autoRepo.save(aut);

        return traerAuto(aut.getId());
    }

    @Override @Transactional
    public void borrarAuto(Long id) {

        autoRepo.deleteById(id);

    }

    @Override
    public Auto traerAuto(Long id) {

        return autoRepo.findById(id).orElse(null);

}
}
