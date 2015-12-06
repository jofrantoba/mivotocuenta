package org.mivotocuenta.server.dao;

import java.util.Collection;

import javax.jdo.PersistenceManager;

import org.mivotocuenta.server.beans.Candidato;
import org.mivotocuenta.shared.BeanParametro;
import org.mivotocuenta.shared.UnknownException;

public class DaoCandidato {
	private PersistenceManager pm;

	public DaoCandidato(PersistenceManager pm) {
		this.pm = pm;
	}

	public boolean mantenimiento(BeanParametro parametro)
			throws UnknownException {
		Querys query = new Querys(this.pm);
		return query.mantenimiento(parametro);
	}

	public Object getBean(Long id) throws UnknownException {
		Querys query = new Querys(this.pm);
		return query.getBean(Candidato.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<Candidato> getListarBean() throws UnknownException {
		Querys query = new Querys(this.pm);
		Collection<Candidato> lista = (Collection<Candidato>) query
				.getListaBean(Candidato.class);
		return lista;
	}
}
