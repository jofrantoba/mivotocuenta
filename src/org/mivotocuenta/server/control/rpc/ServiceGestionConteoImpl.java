package org.mivotocuenta.server.control.rpc;

import org.mivotocuenta.client.service.ServiceGestionConteo;
import org.mivotocuenta.server.beans.Conteo;
import org.mivotocuenta.shared.UnknownException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ServiceGestionConteoImpl extends RemoteServiceServlet implements ServiceGestionConteo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1459605289099444763L;

	@Override
	public Boolean insertarVoto(Conteo bean) throws UnknownException {
		// TODO Auto-generated method stub
		return true;
	}

}
