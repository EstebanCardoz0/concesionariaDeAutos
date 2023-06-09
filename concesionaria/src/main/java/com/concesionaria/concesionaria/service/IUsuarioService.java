package com.concesionaria.concesionaria.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.concesionaria.concesionaria.exception.MiException;

public interface IUsuarioService {

    public void registrar(String nombre, String email, String password, String password2) throws MiException;

    public void validar(String nombre, String email, String password, String password2) throws MiException;

public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
