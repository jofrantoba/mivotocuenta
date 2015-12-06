package org.mivotocuenta.server.beans;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class Candidato implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8021978362564027650L;
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long idCandidato;
	@Persistent
	private String nombrePartido;
	@Persistent
	private String candidato;
	@Persistent
	private String linkFotoCandidato;
	@Persistent
	private String linkFotoPartido;
	@Persistent
	private String linkPlanGobierno;
	@NotPersistent
	private String operacion;
	@NotPersistent
	private Long version;
	
	public Long getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(Long idCandidato) {
		this.idCandidato = idCandidato;
	}
	public String getNombrePartido() {
		return nombrePartido;
	}
	public void setNombrePartido(String nombrePartido) {
		this.nombrePartido = nombrePartido;
	}
	public String getCandidato() {
		return candidato;
	}
	public void setCandidato(String candidato) {
		this.candidato = candidato;
	}
	public String getLinkFotoCandidato() {
		return linkFotoCandidato;
	}
	public void setLinkFotoCandidato(String linkFotoCandidato) {
		this.linkFotoCandidato = linkFotoCandidato;
	}
	public String getLinkFotoPartido() {
		return linkFotoPartido;
	}
	public void setLinkFotoPartido(String linkFotoPartido) {
		this.linkFotoPartido = linkFotoPartido;
	}
	public String getLinkPlanGobierno() {
		return linkPlanGobierno;
	}
	public void setLinkPlanGobierno(String linkPlanGobierno) {
		this.linkPlanGobierno = linkPlanGobierno;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	
	
}
