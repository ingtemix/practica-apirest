package com.apirest.mx.practica01.response.v1;

import java.util.List;

import com.apirest.mx.practica01.model.TipoCatalogoModel;
import com.apirest.mx.practica01.response.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseTipoCatalogo extends Response {

	private List<TipoCatalogoModel> tiposCatalogo;
	private TipoCatalogoModel tipoCatalogo;
	private long total;
	
	public ResponseTipoCatalogo() {
		super();
	}
	
	public ResponseTipoCatalogo(int httpStatus, String status, String message, String messageDetail) {
		super(httpStatus, status, message, messageDetail);
	}

	public ResponseTipoCatalogo(int httpStatus, String status, String message, String messageDetail, List<TipoCatalogoModel> tiposCatalogo) {
		super(httpStatus, status, message, messageDetail);
		this.tiposCatalogo = tiposCatalogo;
	}
	
	public ResponseTipoCatalogo(int httpStatus, String status, String message, String messageDetail, TipoCatalogoModel tipoCatalogo) {
		super(httpStatus, status, message, messageDetail);
		this.tipoCatalogo = tipoCatalogo;
	}

	public ResponseTipoCatalogo(int httpStatus, String status, String message, String messageDetail, long total) {
		super(httpStatus, status, message, messageDetail);
		this.total = total;
	}
	
	public List<TipoCatalogoModel> getTiposCatalogo() {
		return tiposCatalogo;
	}

	public void setTiposCatalogo(List<TipoCatalogoModel> tiposCatalogo) {
		this.tiposCatalogo = tiposCatalogo;
	}

	public TipoCatalogoModel getTipoCatalogo() {
		return tipoCatalogo;
	}

	public void setTipoCatalogo(TipoCatalogoModel tipoCatalogo) {
		this.tipoCatalogo = tipoCatalogo;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
