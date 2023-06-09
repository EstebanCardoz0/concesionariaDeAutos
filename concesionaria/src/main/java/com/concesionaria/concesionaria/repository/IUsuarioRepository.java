package com.concesionaria.concesionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.concesionaria.concesionaria.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("Select u from Usuario u Where u.email= :email")
    public Usuario buscarPorEmail(@Param("email") String email);

}
