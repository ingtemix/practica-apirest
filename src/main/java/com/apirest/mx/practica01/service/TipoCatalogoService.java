package com.apirest.mx.practica01.service;

import java.util.List;

import com.apirest.mx.practica01.exceptions.Practica01Exception;
import com.apirest.mx.practica01.model.TipoCatalogoModel;

public interface TipoCatalogoService {

	public abstract long getTotal() throws Practica01Exception;
	
	public abstract List<TipoCatalogoModel> getAll() throws Practica01Exception;
	
	public abstract TipoCatalogoModel getById(long id) throws Practica01Exception;
	
	public abstract TipoCatalogoModel save(TipoCatalogoModel tipoCatalogo) throws Practica01Exception;
	
	public abstract boolean delete(long id) throws Practica01Exception;
}
