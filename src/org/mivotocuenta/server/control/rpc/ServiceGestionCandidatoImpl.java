package org.mivotocuenta.server.control.rpc;

import org.mivotocuenta.client.service.ServiceGestionCandidato;
import org.mivotocuenta.server.beans.Candidato;
import org.mivotocuenta.server.process.GestionCandidato;
import org.mivotocuenta.shared.UnknownException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ServiceGestionCandidatoImpl extends RemoteServiceServlet implements ServiceGestionCandidato{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7305234951336525908L;

	@Override
	public Boolean insertarCandidato(Candidato bean) throws UnknownException {
		// TODO Auto-generated method stub
		return GestionCandidato.insertarCandidato(bean);
	}

}
