package com.concesionaria.concesionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.concesionaria.concesionaria.exception.MiException;
import com.concesionaria.concesionaria.service.IUsuarioService;

@Controller
@RequestMapping("/")
public class PortalController {

    @Autowired
    IUsuarioService usuarioSer;

    @GetMapping("/")
    public String index() {

        return "index.html";
    }

    @GetMapping("/registrar")
    public String registrar() {

        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email,
            @RequestParam String password, @RequestParam String password2, ModelMap modelo) {

        try {
            usuarioSer.registrar(nombre, email, password, password2);
            modelo.put("exito", "Usuario registrado correctamente");
            return "index.html";
        } catch (MiException e) {
            modelo.put("error", e.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);
            return "registro.html";
        }

    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {
        if (error != null) {
            modelo.put("error", "Usuario o clave inválidos");
        }
        return "login.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String inicio() {

        return "inicio.html";
    }
}
