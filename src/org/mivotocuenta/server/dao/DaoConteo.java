package org.mivotocuenta.server.dao;

import java.util.Collection;

import javax.jdo.PersistenceManager;

import org.mivotocuenta.server.beans.Conteo;
import org.mivotocuenta.shared.BeanParametro;
import org.mivotocuenta.shared.UnknownException;

public class DaoConteo {
	private PersistenceManager pm;

	public DaoConteo(PersistenceManager pm) {
		this.pm = pm;
	}

	public boolean mantenimiento(BeanParametro parametro)
			throws UnknownException {
		Querys query = new Querys(this.pm);
		return query.mantenimiento(parametro);
	}

	public Object getBean(Long id) throws UnknownException {
		Querys query = new Querys(this.pm);
		return query.getBean(Conteo.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<Conteo> getListarBean() throws UnknownException {
		Querys query = new Querys(this.pm);
		Collection<Conteo> lista = (Collection<Conteo>) query
				.getListaBean(Conteo.class);
		return lista;
	}
}
