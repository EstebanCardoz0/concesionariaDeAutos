package com.consesionaria.consesionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consesionaria.consesionaria.entity.Auto;

@Repository
public interface IAutoRepository extends JpaRepository <Auto, Long> {
    
}
