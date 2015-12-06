package org.mivotocuenta.server.beans;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class Conteo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4099388828213167352L;
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long idConteo;
	@Persistent
	private Long idCandidato;
	@Persistent
	private Long idUsuario;
	@Persistent
	private Date fechaRegistro;
	@Persistent
	private String opinion;
	@NotPersistent
	private String operacion;
	@NotPersistent
	private Long version;
	
	public Long getIdConteo() {
		return idConteo;
	}
	public void setIdConteo(Long idConteo) {
		this.idConteo = idConteo;
	}
	public Long getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(Long idCandidato) {
		this.idCandidato = idCandidato;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
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
