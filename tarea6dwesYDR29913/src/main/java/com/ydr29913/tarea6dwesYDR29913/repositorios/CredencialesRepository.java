package com.ydr29913.tarea6dwesYDR29913.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ydr29913.tarea6dwesYDR29913.modelo.Credenciales;

@Repository
public interface CredencialesRepository extends JpaRepository<Credenciales, Long>{

}