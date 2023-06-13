package com.concesionaria.concesionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionaria.concesionaria.entity.Imagen;

@Repository
public interface IImagenRepository extends JpaRepository<Imagen,Long> {

}
