package com.concesionaria.concesionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionaria.concesionaria.entity.Auto;

@Repository
public interface IAutoRepository extends JpaRepository <Auto, Long> {
    
}
