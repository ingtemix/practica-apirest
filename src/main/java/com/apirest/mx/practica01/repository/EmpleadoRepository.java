package com.apirest.mx.practica01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.mx.practica01.entity.Empleado;

@Repository("empleadoRepository")
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	
	public abstract List<Empleado> findByNombre(String nombre);
	
	public abstract List<Empleado> findByTipoCatalogoNombre(String nombreTipoCatalogo);
	
	public abstract List<Empleado> findByTipoCatalogoId(Long idTipoCatalogo);
}
