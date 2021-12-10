package com.apirest.mx.practica01.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.mx.practica01.exceptions.Practica01Exception;
import com.apirest.mx.practica01.model.EmpleadoModel;
import com.apirest.mx.practica01.response.v1.ResponseEmpleado;
import com.apirest.mx.practica01.service.EmpleadoService;

@RestController
@RequestMapping("/v1/empleados")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<ResponseEmpleado> getTotal() {
		HttpHeaders headers = new HttpHeaders();
		ResponseEmpleado response = null;
		try {
			long totalEmpleados = empleadoService.getTotal();
			response = new ResponseEmpleado(HttpStatus.OK.value(), HttpStatus.OK.name(), "TRANSACCION_EXITOSA", "Total de empleados obtenidos correctamente", totalEmpleados);
		} catch (Practica01Exception ex) {
			response = new ResponseEmpleado(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al consultar el total de empleados: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/all")
	public ResponseEntity<ResponseEmpleado> getAll() {
		HttpHeaders headers = new HttpHeaders();
		ResponseEmpleado response = null;
		try {
			List<EmpleadoModel> empleados = empleadoService.getAll();
			response = new ResponseEmpleado(HttpStatus.OK.value(), HttpStatus.OK.name(), "TRANSACCION_EXITOSA", "Empleados obtenidos correctamente", empleados);
		} catch (Practica01Exception ex) {
			response = new ResponseEmpleado(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al consultar los empleados: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/name/{nombre}")
	public ResponseEntity<ResponseEmpleado> getByName(@PathVariable("nombre") String nombre) {
		HttpHeaders headers = new HttpHeaders();
		ResponseEmpleado response = null;
		try {
			List<EmpleadoModel> empleados = empleadoService.getByName(nombre);
			response = new ResponseEmpleado(HttpStatus.OK.value(), HttpStatus.OK.name(), "TRANSACCION_EXITOSA", "Empleados obtenidos por nombre correctamente", empleados);
		} catch (Practica01Exception ex) {
			response = new ResponseEmpleado(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al consultar el empleado por nombre: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseEmpleado> getById(@PathVariable("id") long idEmpleado) {
		HttpHeaders headers = new HttpHeaders();
		ResponseEmpleado response = null;
		try {
			EmpleadoModel empleado = empleadoService.getById(idEmpleado);
			response = new ResponseEmpleado(HttpStatus.OK.value(), HttpStatus.OK.name(), "TRANSACCION_EXITOSA", "Empleado obtenido correctamente", empleado);
		} catch (Practica01Exception ex) {
			response = new ResponseEmpleado(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al consultar el empleado: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<ResponseEmpleado> add(@RequestBody EmpleadoModel empleado) {
		HttpHeaders headers = new HttpHeaders();
		ResponseEmpleado response = null;
		try {
			EmpleadoModel empleadoModel = empleadoService.save(empleado);
			headers.add("Location", "/empleado" + empleadoModel.getId());
			response = new ResponseEmpleado(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), "TRANSACCION_EXITOSA", "Empleado creado correctamente", empleadoModel);
		} catch (Practica01Exception ex) {
			response = new ResponseEmpleado(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al crear el empleado: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping
	public ResponseEntity<ResponseEmpleado> update(@RequestBody EmpleadoModel empleado) {
		HttpHeaders headers = new HttpHeaders();
		ResponseEmpleado response = null;
		try {
			EmpleadoModel empleadoModel = empleadoService.save(empleado);
			response = new ResponseEmpleado(HttpStatus.OK.value(), HttpStatus.OK.name(), "TRANSACCION_EXITOSA", "Empleado actualizado correctamente", empleadoModel);
		} catch (Practica01Exception ex) {
			response = new ResponseEmpleado(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al actualizar el empleado: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseEmpleado> delete(@PathVariable("id") long idEmpleado) {
		HttpHeaders headers = new HttpHeaders();
		ResponseEmpleado response = null;
		try {
			empleadoService.delete(idEmpleado);
			response = new ResponseEmpleado(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.name(), "TRANSACCION_EXITOSA", "Empleado eliminado correctamente: " + idEmpleado);
		} catch (Practica01Exception ex) {
			response = new ResponseEmpleado(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al eliminar el empleado: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
}
