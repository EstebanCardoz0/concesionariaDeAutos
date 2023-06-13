package com.concesionaria.concesionaria.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import com.concesionaria.concesionaria.entity.Usuario;
import com.concesionaria.concesionaria.exception.MiException;


public interface IUsuarioService {

    public void registrar(MultipartFile archivo, String nombre, String email, String password, String password2) throws MiException;

    public void actualizar(MultipartFile archivo, Long idUsuario, String nombre, String email, String password, String password2) throws MiException;

    public void validar(String nombre, String email, String password, String password2) throws MiException;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    public Usuario getOne(Long id);

    public void cambiarRol(Long id);

    public List <Usuario> listarUsuarios();
}
