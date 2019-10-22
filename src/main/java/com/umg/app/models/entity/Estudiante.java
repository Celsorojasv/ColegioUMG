package com.umg.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "estudiantes")
public class Estudiante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estudiante")
	private Long idEstu;
	
	@NotEmpty
	@Column(name = "nom_es1")
	private String  nombreEstu1;

	@NotEmpty
	@Column(name = "nom_es2")
	private String  nombreEstu2;
	

	@Column(name = "nom_es3")
	private String  nombreEstu3;
	
	@NotEmpty
	@Column(name = "ape_es1")
	private String  apeEstu1;
	
	@NotEmpty
	@Column(name = "ape_es2")
	private String  apeEstu2;
	
	@NotEmpty
	@Column(name = "correo_es")
	private String  correoEstu;
	
	@NotEmpty
	@Column(name = "sexo_es")
	private String  sexoEstu;
	
	@NotEmpty
	@Column(name = "edad_es")
	private String  edadEstu;

	public Long getIdEstu() {
		return idEstu;
	}

	public void setIdEstu(Long idEstu) {
		this.idEstu = idEstu;
	}

	public String getNombreEstu1() {
		return nombreEstu1;
	}

	public void setNombreEstu1(String nombreEstu1) {
		this.nombreEstu1 = nombreEstu1;
	}

	public String getNombreEstu2() {
		return nombreEstu2;
	}

	public void setNombreEstu2(String nombreEstu2) {
		this.nombreEstu2 = nombreEstu2;
	}

	public String getNombreEstu3() {
		return nombreEstu3;
	}

	public void setNombreEstu3(String nombreEstu3) {
		this.nombreEstu3 = nombreEstu3;
	}

	public String getApeEstu1() {
		return apeEstu1;
	}

	public void setApeEstu1(String apeEstu1) {
		this.apeEstu1 = apeEstu1;
	}

	public String getApeEstu2() {
		return apeEstu2;
	}

	public void setApeEstu2(String apeEstu2) {
		this.apeEstu2 = apeEstu2;
	}

	public String getCorreoEstu() {
		return correoEstu;
	}

	public void setCorreoEstu(String correoEstu) {
		this.correoEstu = correoEstu;
	}

	public String getSexoEstu() {
		return sexoEstu;
	}

	public void setSexoEstu(String sexoEstu) {
		this.sexoEstu = sexoEstu;
	}

	public String getEdadEstu() {
		return edadEstu;
	}

	public void setEdadEstu(String edadEstu) {
		this.edadEstu = edadEstu;
	}
}
