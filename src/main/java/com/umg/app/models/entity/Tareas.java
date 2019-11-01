package com.umg.app.models.entity;

public class Tareas {

	private Long idTarea;	
	private Long punteo;
	private Curso curso;
	
	public Long getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}
	public Long getPunteo() {
		return punteo;
	}
	public void setPunteo(Long punteo) {
		this.punteo = punteo;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}	

}
