package org.mivotocuenta.server.logic;

import java.util.Collection;

import javax.jdo.PersistenceManager;

import org.mivotocuenta.server.beans.Usuario;
import org.mivotocuenta.server.dao.DaoUsuario;
import org.mivotocuenta.shared.BeanParametro;
import org.mivotocuenta.shared.UnknownException;

public class LogicUsuario {
	private PersistenceManager pm;

	public LogicUsuario(PersistenceManager pm) {
		this.pm = pm;
	}

	public boolean mantenimiento(BeanParametro parametro)
			throws UnknownException {
		DaoUsuario dao = new DaoUsuario(this.pm);
		return dao.mantenimiento(parametro);
	}
	
	public Object getBean(Long id) throws UnknownException {
		DaoUsuario dao = new DaoUsuario(this.pm);
		return dao.getBean(id);
	}

	public Collection<Usuario> getListarBean() throws UnknownException {
		DaoUsuario dao = new DaoUsuario(this.pm);
		Collection<Usuario> lista = dao.getListarBean();
		return lista;
	}
}
