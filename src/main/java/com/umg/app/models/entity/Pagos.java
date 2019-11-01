package com.umg.app.models.entity;

public class Pagos {

	private Long idPago;
	private float montoPago;
	private String fechaPago;
	private String descrPago;
	private Estudiante estudiante;
	public Long getIdPago() {
		return idPago;
	}
	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}
	public float getMontoPago() {
		return montoPago;
	}
	public void setMontoPago(float montoPago) {
		this.montoPago = montoPago;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getDescrPago() {
		return descrPago;
	}
	public void setDescrPago(String descrPago) {
		this.descrPago = descrPago;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	} 

	
}
