package com.apirest.mx.practica01.service;

import java.util.List;

import com.apirest.mx.practica01.exceptions.Practica01Exception;
import com.apirest.mx.practica01.model.EmpleadoModel;

public interface EmpleadoService {

	public abstract long getTotal() throws Practica01Exception;
	
	public abstract List<EmpleadoModel> getAll() throws Practica01Exception;
	
	public abstract List<EmpleadoModel> getByName(String nombre) throws Practica01Exception;
	
	public abstract EmpleadoModel getById(long id) throws Practica01Exception;
	
	public abstract EmpleadoModel save(EmpleadoModel empleado) throws Practica01Exception;
	
	public abstract boolean delete(long id) throws Practica01Exception;
}
