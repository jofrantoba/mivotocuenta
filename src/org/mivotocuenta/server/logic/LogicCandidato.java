package org.mivotocuenta.server.logic;

import java.util.Collection;

import javax.jdo.PersistenceManager;

import org.mivotocuenta.server.beans.Candidato;
import org.mivotocuenta.server.dao.DaoCandidato;
import org.mivotocuenta.shared.BeanParametro;
import org.mivotocuenta.shared.UnknownException;

public class LogicCandidato {
	private PersistenceManager pm;

	public LogicCandidato(PersistenceManager pm) {
		this.pm = pm;
	}

	public boolean mantenimiento(BeanParametro parametro)
			throws UnknownException {
		DaoCandidato dao = new DaoCandidato(this.pm);
		return dao.mantenimiento(parametro);
	}
	
	public Object getBean(Long id) throws UnknownException {
		DaoCandidato dao = new DaoCandidato(this.pm);
		return dao.getBean(id);
	}

	public Collection<Candidato> getListarBean() throws UnknownException {
		DaoCandidato dao = new DaoCandidato(this.pm);
		Collection<Candidato> lista = dao.getListarBean();
		return lista;
	}
}
