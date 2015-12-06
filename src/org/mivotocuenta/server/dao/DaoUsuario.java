package org.mivotocuenta.server.dao;

import java.util.Collection;

import javax.jdo.PersistenceManager;
import org.mivotocuenta.server.beans.Usuario;
import org.mivotocuenta.shared.BeanParametro;
import org.mivotocuenta.shared.UnknownException;

public class DaoUsuario {
	private PersistenceManager pm;

	public DaoUsuario(PersistenceManager pm) {
		this.pm = pm;
	}

	public boolean mantenimiento(BeanParametro parametro)
			throws UnknownException {
		Querys query = new Querys(this.pm);
		return query.mantenimiento(parametro);
	}

	public Object getBean(Long id) throws UnknownException {
		Querys query = new Querys(this.pm);
		return query.getBean(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<Usuario> getListarBean() throws UnknownException {
		Querys query = new Querys(this.pm);
		Collection<Usuario> lista = (Collection<Usuario>) query
				.getListaBean(Usuario.class);
		return lista;
	}
}
