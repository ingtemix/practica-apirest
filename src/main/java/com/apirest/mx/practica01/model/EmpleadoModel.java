package com.apirest.mx.practica01.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class EmpleadoModel {

	private Long id;
	private String nombre;
	private String puesto;
	private TipoCatalogoModel tipoCatalogo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public TipoCatalogoModel getTipoCatalogo() {
		return tipoCatalogo;
	}

	public void setTipoCatalogo(TipoCatalogoModel tipoCatalogo) {
		this.tipoCatalogo = tipoCatalogo;
	}
}
