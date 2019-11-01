package com.umg.app.models.entity;

public class AsignacionEst {

	private int idAsignacion;
	private Estudiante Estudiante;
	private Curso Curso;
	
	public int getIdAsignacion() {
		return idAsignacion;
	}
	public void setIdAsignacion(int idAsignacion) {
		this.idAsignacion = idAsignacion;
	}
	public Estudiante getEstudiante() {
		return Estudiante;
	}
	public void setEstudiante(Estudiante Estudiante) {
		this.Estudiante = Estudiante;
	}
	public Curso getCurso() {
		return Curso;
	}
	public void setCurso(Curso Curso) {
		this.Curso = Curso;
	}

}
