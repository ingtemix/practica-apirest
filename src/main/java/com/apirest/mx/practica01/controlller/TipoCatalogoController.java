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
import com.apirest.mx.practica01.model.TipoCatalogoModel;
import com.apirest.mx.practica01.response.v1.ResponseTipoCatalogo;
import com.apirest.mx.practica01.service.TipoCatalogoService;

@RestController
@RequestMapping("/v1/tipos-catalogo")
public class TipoCatalogoController {
	
	@Autowired
	private TipoCatalogoService tipoCatalogoService;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<ResponseTipoCatalogo> getTotal() {
		HttpHeaders headers = new HttpHeaders();
		ResponseTipoCatalogo response = null;
		try {
			long totalTiposCatalogo = tipoCatalogoService.getTotal();
			response = new ResponseTipoCatalogo(HttpStatus.OK.value(), HttpStatus.OK.name(), "TRANSACCION_EXITOSA", "Total de tipos catalogo obtenidos correctamente", totalTiposCatalogo);
		} catch (Practica01Exception ex) {
			response = new ResponseTipoCatalogo(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al consultar el total de tipos catalogos: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/all")
	public ResponseEntity<ResponseTipoCatalogo> getAll() {
		HttpHeaders headers = new HttpHeaders();
		ResponseTipoCatalogo response = null;
		try {
			List<TipoCatalogoModel> tiposCatalogo = tipoCatalogoService.getAll();
			response = new ResponseTipoCatalogo(HttpStatus.OK.value(), HttpStatus.OK.name(), "TRANSACCION_EXITOSA", "Tipos de catalogo obtenidos correctamente", tiposCatalogo);
		} catch (Practica01Exception ex) {
			response = new ResponseTipoCatalogo(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al consultar los tipos catalogos: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/name/{nombre}")
	public ResponseEntity<ResponseTipoCatalogo> getByName(@PathVariable("nombre") String nombre) {
		HttpHeaders headers = new HttpHeaders();
		ResponseTipoCatalogo response = null;
		try {
			List<TipoCatalogoModel> tiposCatalogo = tipoCatalogoService.getByName(nombre);
			response = new ResponseTipoCatalogo(HttpStatus.OK.value(), HttpStatus.OK.name(), "TRANSACCION_EXITOSA", "Tipos de catalogo obtenido por nombre correctamente", tiposCatalogo);
		} catch (Practica01Exception ex) {
			response = new ResponseTipoCatalogo(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al consultar el tipo de catalogo por nombre: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseTipoCatalogo> getById(@PathVariable("id") long idTipoCatalogo) {
		HttpHeaders headers = new HttpHeaders();
		ResponseTipoCatalogo response = null;
		try {
			TipoCatalogoModel tipoCatalogo = tipoCatalogoService.getById(idTipoCatalogo);
			response = new ResponseTipoCatalogo(HttpStatus.OK.value(), HttpStatus.OK.name(), "TRANSACCION_EXITOSA", "Tipo de catalogo obtenido correctamente", tipoCatalogo);
		} catch (Practica01Exception ex) {
			response = new ResponseTipoCatalogo(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al consultar el tipo catalogo: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<ResponseTipoCatalogo> add(@RequestBody TipoCatalogoModel tipoCatalogo) {
		HttpHeaders headers = new HttpHeaders();
		ResponseTipoCatalogo response = null;
		try {
			TipoCatalogoModel tipoCatalogoModel = tipoCatalogoService.save(tipoCatalogo);
			headers.add("Location", "/tipos-catalogos" + tipoCatalogoModel.getId());
			response = new ResponseTipoCatalogo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), "TRANSACCION_EXITOSA", "Tipo de catalogo creado correctamente", tipoCatalogoModel);
		} catch (Practica01Exception ex) {
			response = new ResponseTipoCatalogo(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al crear el tipo catalogo: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping
	public ResponseEntity<ResponseTipoCatalogo> update(@RequestBody TipoCatalogoModel tipoCatalogo) {
		HttpHeaders headers = new HttpHeaders();
		ResponseTipoCatalogo response = null;
		try {
			TipoCatalogoModel tipoCatalogoModel = tipoCatalogoService.save(tipoCatalogo);
			response = new ResponseTipoCatalogo(HttpStatus.OK.value(), HttpStatus.OK.name(), "TRANSACCION_EXITOSA", "Tipo de catalogo actualizado correctamente", tipoCatalogoModel);
		} catch (Practica01Exception ex) {
			response = new ResponseTipoCatalogo(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al actualizar el tipo catalogo: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseTipoCatalogo> delete(@PathVariable("id") long idTipoCatalogo) {
		HttpHeaders headers = new HttpHeaders();
		ResponseTipoCatalogo response = null;
		try {
			tipoCatalogoService.delete(idTipoCatalogo);
			response = new ResponseTipoCatalogo(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.name(), "TRANSACCION_EXITOSA", "Tipo de catalogo eliminado correctamente: " + idTipoCatalogo);
		} catch (Practica01Exception ex) {
			response = new ResponseTipoCatalogo(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), "TRANSACCION_INCORRECTA", "Error al eliminar el tipo catalogo: " + ex.getMessage());
		}
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
}
