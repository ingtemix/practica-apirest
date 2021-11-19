package com.apirest.mx.practica01.component;

import org.springframework.stereotype.Component;

import com.apirest.mx.practica01.entity.TipoCatalogo;
import com.apirest.mx.practica01.model.TipoCatalogoModel;

@Component
public class TipoCatalogoConverter {

	public TipoCatalogo convertTipoCatalogoModelToTipoCatalogo(TipoCatalogoModel tipoCatalogoModel) {
		TipoCatalogo tipoCatalogo = new TipoCatalogo();
		tipoCatalogo.setId(tipoCatalogoModel.getId());
		tipoCatalogo.setNombre(tipoCatalogoModel.getNombre());
		tipoCatalogo.setDescripcion(tipoCatalogoModel.getDescripcion());

		return tipoCatalogo;
	}

	public TipoCatalogoModel convertTipoCatalogoToTipoCatalogoModel(TipoCatalogo tipoCatalogo) {
		TipoCatalogoModel tipoCatalogoModel = new TipoCatalogoModel();
		tipoCatalogoModel.setId(tipoCatalogo.getId());
		tipoCatalogoModel.setNombre(tipoCatalogo.getNombre());
		tipoCatalogoModel.setDescripcion(tipoCatalogo.getDescripcion());

		return tipoCatalogoModel;
	}
}
