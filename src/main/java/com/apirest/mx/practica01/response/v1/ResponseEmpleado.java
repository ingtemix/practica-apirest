package com.apirest.mx.practica01.response.v1;

import java.util.List;

import com.apirest.mx.practica01.model.EmpleadoModel;
import com.apirest.mx.practica01.response.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseEmpleado extends Response {

	private List<EmpleadoModel> empleados;
	private EmpleadoModel empleado;
	private long total;

	public ResponseEmpleado() {
		super();
	}

	public ResponseEmpleado(int httpStatus, String status, String message, String messageDetail) {
		super(httpStatus, status, message, messageDetail);
	}

	public ResponseEmpleado(int httpStatus, String status, String message, String messageDetail, List<EmpleadoModel> empleados) {
		super(httpStatus, status, message, messageDetail);
		this.empleados = empleados;
	}

	public ResponseEmpleado(int httpStatus, String status, String message, String messageDetail, EmpleadoModel empleado) {
		super(httpStatus, status, message, messageDetail);
		this.empleado = empleado;
	}

	public ResponseEmpleado(int httpStatus, String status, String message, String messageDetail, long total) {
		super(httpStatus, status, message, messageDetail);
		this.total = total;
	}

	public List<EmpleadoModel> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<EmpleadoModel> empleados) {
		this.empleados = empleados;
	}

	public EmpleadoModel getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoModel empleado) {
		this.empleado = empleado;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
