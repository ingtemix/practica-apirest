package com.apirest.mx.practica01.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apirest.mx.practica01.entity.Empleado;
import com.apirest.mx.practica01.model.EmpleadoModel;


@Component
public class EmpleadoConverter {
	
	@Autowired
	private TipoCatalogoConverter tipoCatalogoConverter;

	public Empleado convertEmpleadoModelToEmpleado(EmpleadoModel empleadoModel) {
		Empleado empleado = new Empleado();
		empleado.setId(empleadoModel.getId());
		empleado.setNombre(empleadoModel.getNombre());
		empleado.setPuesto(empleadoModel.getPuesto());
		if (empleadoModel.getTipoCatalogo() != null) {
			empleado.setTipoCatalogo(tipoCatalogoConverter.convertTipoCatalogoModelToTipoCatalogo(empleadoModel.getTipoCatalogo()));
		}

		return empleado;
	}

	public EmpleadoModel convertEmpleadoToEmpleadoModel(Empleado empleado) {
		EmpleadoModel empleadoModel = new EmpleadoModel();
		empleadoModel.setId(empleado.getId());
		empleadoModel.setNombre(empleado.getNombre());
		empleadoModel.setPuesto(empleado.getPuesto());
		if (empleado.getTipoCatalogo() != null) {
			empleadoModel.setTipoCatalogo(tipoCatalogoConverter.convertTipoCatalogoToTipoCatalogoModel(empleado.getTipoCatalogo()));
		}
		
		return empleadoModel;
	}
}
