package com.concesionaria.concesionaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return "alta.html";
    }

    @PostMapping("/crear")
    public String crearAuto(@RequestParam String modelo,
            @RequestParam String marca, @RequestParam String color, @RequestParam String patente,
            @RequestParam Integer cantidadPuertas, ModelMap model) {
        Auto auto = new Auto();

        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantidadPuertas(cantidadPuertas);
        try {
            autoSer.crearAuto(auto);
            model.put("exito", "El auto fue cargado correctamente");

        } catch (MiException e) {

            model.put("error", e.getMessage());
            return "alta.html";
        }
        return "index.html";
    }

    @GetMapping("/listas")
    public String listas(ModelMap modelo) {

        List<Auto> autos = autoSer.listarAutos();

        modelo.addAttribute("autos", autos);

        return "lista.html";
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

    @GetMapping("/cambiar/{id}")
    public String cambiar(@PathVariable Long id, ModelMap model) {

        model.put("auto", autoSer.getOne(id));
        return "auto_modificar.html";
    }

    @PostMapping("/cambiar/{id}")
    public String cambiar(@PathVariable Long id, String modelo, String marca, String color,
            String patente, Integer cantidadPuertas, ModelMap model) {

        try {
            autoSer.cambiar(id, modelo, marca, color, patente, cantidadPuertas);
            return "redirect:../listas";
        } catch (MiException e) {
            model.put("error", e.getMessage());
            return "auto_modificar.html";
        }

    }

    @PutMapping("/modificar")
    public Auto modificarAuto(@RequestBody Auto auto) throws MiException {

        return autoSer.modificarAuto(auto);
    }

}
