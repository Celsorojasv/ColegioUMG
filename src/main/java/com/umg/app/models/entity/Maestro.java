package com.umg.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name= "maestros")
public class Maestro implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_maestro")
	private Long idMa;
	
	@NotEmpty
	@Column(name = "nom_ma1")
	private String nombreMa1;
	
	@NotEmpty
	@Column(name = "nom_ma2")
	private String nombreMa2;
	

	@Column(name = "nom_ma3")
	private String nombreMa3;
	
	@NotEmpty
	@Column(name = "ape_ma1")
	private String apellidoMa1;
	
	@NotEmpty
	@Column(name = "ape_ma2")
	private String apellidoMa2;
	
	@NotEmpty
	@Column(name = "correo_ma")
	private String correoMa;
	
	@NotEmpty
	@Column(name = "sexo_ma")
	private String sexoMa;
	
	@NotEmpty
	@Column(name = "edad_ma")
	private String edadMa;
	
	@NotEmpty
	@Column(name = "dpi_ma")
	private String dpiMa;
	

	public Long getIdMa() {
		return idMa;
	}
	public void setIdMa(Long idMa) {
		this.idMa = idMa;
	}
	public String getNombreMa1() {
		return nombreMa1;
	}
	public void setNombreMa1(String nombreMa1) {
		this.nombreMa1 = nombreMa1;
	}
	public String getNombreMa2() {
		return nombreMa2;
	}
	public void setNombreMa2(String nombreMa2) {
		this.nombreMa2 = nombreMa2;
	}
	public String getNombreMa3() {
		return nombreMa3;
	}
	public void setNombreMa3(String nombreMa3) {
		this.nombreMa3 = nombreMa3;
	}
	public String getApellidoMa1() {
		return apellidoMa1;
	}
	public void setApellidoMa1(String apelldioMa1) {
		this.apellidoMa1 = apelldioMa1;
	}
	public String getApellidoMa2() {
		return apellidoMa2;
	}
	public void setApellidoMa2(String apellidoMa2) {
		this.apellidoMa2 = apellidoMa2;
	}
	public String getCorreoMa() {
		return correoMa;
	}
	public void setCorreoMa(String correoMa) {
		this.correoMa = correoMa;
	}
	public String getSexoMa() {
		return sexoMa;
	}
	public void setSexoMa(String sexoMa) {
		this.sexoMa = sexoMa;
	}
	public String getEdadMa() {
		return edadMa;
	}
	public void setEdadMa(String edadMa) {
		this.edadMa = edadMa;
	}
	public String getDpiMa() {
		return dpiMa;
	}
	public void setDpiMa(String dpiMa) {
		this.dpiMa = dpiMa;
	}
	
	
}
