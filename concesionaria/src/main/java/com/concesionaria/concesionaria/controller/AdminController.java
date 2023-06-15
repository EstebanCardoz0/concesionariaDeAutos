package com.concesionaria.concesionaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.concesionaria.concesionaria.entity.Usuario;
import com.concesionaria.concesionaria.service.IUsuarioService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IUsuarioService usuarioServicio;

    @GetMapping("/dashboard")
    public String panelAdministrativo() {

        return "panel.html";
    }

    @GetMapping("/usuarios")
    public String listar(ModelMap modelo) {
        List<Usuario> usuarios = usuarioServicio.listarUsuarios();
        modelo.addAttribute("usuarios", usuarios);

        return "usuario_list";
    }

    @GetMapping("/modificarRol/{id}")
    public String cambiarRol(@PathVariable Long id) {
        usuarioServicio.cambiarRol(id);

        return "redirect:/admin/usuarios";
    }

}
