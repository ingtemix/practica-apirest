package com.apirest.mx.practica01.exceptions;

public class Practica01Exception extends Exception {

	private static final long serialVersionUID = 1L;
	
	public Practica01Exception() {
		
	}

	public Practica01Exception(String mensaje) {
		super(mensaje);
	}
	
	public Practica01Exception(Throwable causa) {
		super(causa);
	}
	
	public Practica01Exception(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}
