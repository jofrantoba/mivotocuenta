package org.mivotocuenta.server.control.rpc;

import org.mivotocuenta.client.service.ServiceGestionUsuario;
import org.mivotocuenta.server.beans.Usuario;
import org.mivotocuenta.shared.UnknownException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ServiceGestionUsuarioImpl extends RemoteServiceServlet implements ServiceGestionUsuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2282486799664149548L;

	@Override
	public Boolean insertarUsuario(Usuario bean) throws UnknownException {
		// TODO Auto-generated method stub
		return true;
	}

}
