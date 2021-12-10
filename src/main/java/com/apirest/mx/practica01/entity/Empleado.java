package com.apirest.mx.practica01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleados", schema = "practica")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "puesto")
	private String puesto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_catalogo_id")
	public TipoCatalogo tipoCatalogo;

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

	public TipoCatalogo getTipoCatalogo() {
		return tipoCatalogo;
	}

	public void setTipoCatalogo(TipoCatalogo tipoCatalogo) {
		this.tipoCatalogo = tipoCatalogo;
	}
}
