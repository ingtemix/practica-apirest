package com.apirest.mx.practica01.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.mx.practica01.component.TipoCatalogoConverter;
import com.apirest.mx.practica01.entity.TipoCatalogo;
import com.apirest.mx.practica01.exceptions.Practica01Exception;
import com.apirest.mx.practica01.model.TipoCatalogoModel;
import com.apirest.mx.practica01.repository.TipoCatalogoRepository;
import com.apirest.mx.practica01.service.TipoCatalogoService;

@Service("tipoCatalogoServiceImpl")
public class TipoCatalogoServiceImpl implements TipoCatalogoService {

	@Autowired
	private TipoCatalogoRepository tipoCatalogoRepository;

	@Autowired
	private TipoCatalogoConverter tipoCatalogoConverter;

	@Override
	public long getTotal() throws Practica01Exception {
		try {
			return tipoCatalogoRepository.count();
		} catch (Exception ex) {
			throw new Practica01Exception(ex.getMessage());
		}
	}

	@Override
	public List<TipoCatalogoModel> getAll() throws Practica01Exception {
		try {
			List<TipoCatalogo> tiposCatalogo = tipoCatalogoRepository.findAll();
			List<TipoCatalogoModel> tiposCatalogoModel = new ArrayList<>();
			tiposCatalogo.forEach(tipoCatalogo -> tiposCatalogoModel.add(tipoCatalogoConverter.convertTipoCatalogoToTipoCatalogoModel(tipoCatalogo)));

			return tiposCatalogoModel;
		} catch (Exception ex) {
			throw new Practica01Exception(ex);
		}
	}
	
	@Override
	public List<TipoCatalogoModel> getByName(String nombre) throws Practica01Exception {
		try {
			List<TipoCatalogo> tiposCatalogo = tipoCatalogoRepository.findByNombre(nombre);
			List<TipoCatalogoModel> tiposCatalogoModel = new ArrayList<>();
			tiposCatalogo.forEach(tipoCatalogo -> tiposCatalogoModel.add(tipoCatalogoConverter.convertTipoCatalogoToTipoCatalogoModel(tipoCatalogo)));

			return tiposCatalogoModel;
		} catch (Exception ex) {
			throw new Practica01Exception(ex);
		}
	}

	@Override
	public TipoCatalogoModel getById(long id) throws Practica01Exception {
		try {
			Optional<TipoCatalogo> tipoCatalogo = tipoCatalogoRepository.findById(id);
			if (tipoCatalogo.isPresent()) {
				return tipoCatalogoConverter.convertTipoCatalogoToTipoCatalogoModel(tipoCatalogo.get());
			}
		} catch (Exception ex) {
			throw new Practica01Exception(ex.getMessage());
		}
		return null;
	}

	@Override
	public TipoCatalogoModel save(TipoCatalogoModel tipoCatalogo) throws Practica01Exception {
		try {
			return tipoCatalogoConverter.convertTipoCatalogoToTipoCatalogoModel(tipoCatalogoRepository.save(tipoCatalogoConverter.convertTipoCatalogoModelToTipoCatalogo(tipoCatalogo)));
		} catch (Exception ex) {
			throw new Practica01Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(long id) throws Practica01Exception {
		try {
			tipoCatalogoRepository.deleteById(id);
			return true;
		} catch (Exception ex) {
			throw new Practica01Exception(ex.getMessage());
		}
	}
}
