package com.umg.app.models.entity;

public class AsignacionMae {
	
	private int idAsignacion;
	private Maestro Maestro;
	private Curso Curso;
	
	public int getIdAsignacion() {
		return idAsignacion;
	}
	public void setIdAsignacion(int idAsignacion) {
		this.idAsignacion = idAsignacion;
	}
	public Maestro getMaestro() {
		return Maestro;
	}
	public void setMaestro(Maestro maestro) {
		Maestro = maestro;
	}
	public Curso getCurso() {
		return Curso;
	}
	public void setCurso(Curso curso) {
		Curso = curso;
	}

}
