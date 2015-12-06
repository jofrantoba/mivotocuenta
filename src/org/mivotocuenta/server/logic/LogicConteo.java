package org.mivotocuenta.server.logic;

import java.util.Collection;

import javax.jdo.PersistenceManager;

import org.mivotocuenta.server.beans.Conteo;
import org.mivotocuenta.server.dao.DaoConteo;
import org.mivotocuenta.shared.BeanParametro;
import org.mivotocuenta.shared.UnknownException;

public class LogicConteo {
	private PersistenceManager pm;

	public LogicConteo(PersistenceManager pm) {
		this.pm = pm;
	}

	public boolean mantenimiento(BeanParametro parametro)
			throws UnknownException {
		DaoConteo dao = new DaoConteo(this.pm);
		return dao.mantenimiento(parametro);
	}
	
	public Object getBean(Long id) throws UnknownException {
		DaoConteo dao = new DaoConteo(this.pm);
		return dao.getBean(id);
	}

	public Collection<Conteo> getListarBean() throws UnknownException {
		DaoConteo dao = new DaoConteo(this.pm);
		Collection<Conteo> lista = dao.getListarBean();
		return lista;
	}
}
