package com.concesionaria.concesionaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.concesionaria.concesionaria.entity.Auto;
import com.concesionaria.concesionaria.exception.MiException;
import com.concesionaria.concesionaria.service.IAutoService;

@Controller
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    IAutoService autoSer;

    @GetMapping("/index")
    public String index() {

        return "index.html";
    }

    // @GetMapping("/index")
    // public ModelAndView index() {
    // ModelAndView modelAndView = new ModelAndView();
    // modelAndView.setViewName("index.html");
    // return modelAndView;
    // }

    @GetMapping("/registrar")
    public String crearAuto() {
        return "index.html";
    }

    @PostMapping("/crear")
    public String crearAuto(@RequestParam String modelo) throws MiException {
        System.out.println(modelo);
        // autoSer.crearAuto(auto);
        return "index.html";
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
    public Auto modificarAuto(@RequestBody Auto auto) throws MiException {

        return autoSer.modificarAuto(auto);
    }

}
