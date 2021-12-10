package com.apirest.mx.practica01.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.mx.practica01.component.EmpleadoConverter;
import com.apirest.mx.practica01.entity.Empleado;
import com.apirest.mx.practica01.exceptions.Practica01Exception;
import com.apirest.mx.practica01.model.EmpleadoModel;
import com.apirest.mx.practica01.repository.EmpleadoRepository;
import com.apirest.mx.practica01.service.EmpleadoService;

@Service("empleadoServiceImpl")
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private EmpleadoConverter empleadoConverter;

	@Override
	public long getTotal() throws Practica01Exception {
		try {
			return empleadoRepository.count();
		} catch (Exception ex) {
			throw new Practica01Exception(ex.getMessage());
		}
	}

	@Override
	public List<EmpleadoModel> getAll() throws Practica01Exception {
		try {
			List<Empleado> empleados = empleadoRepository.findAll();
			List<EmpleadoModel> empleadosModel = new ArrayList<>();
			empleados.forEach(empleado -> empleadosModel.add(empleadoConverter.convertEmpleadoToEmpleadoModel(empleado)));

			return empleadosModel;
		} catch (Exception ex) {
			throw new Practica01Exception(ex);
		}
	}
	
	@Override
	public List<EmpleadoModel> getByName(String nombre) throws Practica01Exception {
		try {
			List<Empleado> empleados = empleadoRepository.findByNombre(nombre);
			List<EmpleadoModel> empleadosModel = new ArrayList<>();
			empleados.forEach(empleado -> empleadosModel.add(empleadoConverter.convertEmpleadoToEmpleadoModel(empleado)));

			return empleadosModel;
		} catch (Exception ex) {
			throw new Practica01Exception(ex);
		}
	}

	@Override
	public EmpleadoModel getById(long id) throws Practica01Exception {
		try {
			Optional<Empleado> empleado = empleadoRepository.findById(id);
			if (empleado.isPresent()) {
				return empleadoConverter.convertEmpleadoToEmpleadoModel(empleado.get());
			}
		} catch (Exception ex) {
			throw new Practica01Exception(ex.getMessage());
		}
		return null;
	}

	@Override
	public EmpleadoModel save(EmpleadoModel empleado) throws Practica01Exception {
		try {
			return empleadoConverter.convertEmpleadoToEmpleadoModel(empleadoRepository.save(empleadoConverter.convertEmpleadoModelToEmpleado(empleado)));
		} catch (Exception ex) {
			throw new Practica01Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(long id) throws Practica01Exception {
		try {
			empleadoRepository.deleteById(id);
			return true;
		} catch (Exception ex) {
			throw new Practica01Exception(ex.getMessage());
		}
	}
}
