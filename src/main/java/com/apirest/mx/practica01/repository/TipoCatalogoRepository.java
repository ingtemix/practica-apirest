package com.apirest.mx.practica01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.mx.practica01.entity.TipoCatalogo;

@Repository("tipoCatalogoRepository")
public interface TipoCatalogoRepository extends JpaRepository<TipoCatalogo, Long>{
	
}
