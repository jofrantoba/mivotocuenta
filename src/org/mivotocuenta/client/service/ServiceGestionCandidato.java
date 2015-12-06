package org.mivotocuenta.client.service;

import org.mivotocuenta.server.beans.Candidato;
import org.mivotocuenta.shared.UnknownException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("servicegestioncandidato")
public interface ServiceGestionCandidato extends RemoteService {
	Boolean insertarCandidato(Candidato bean) throws UnknownException;
}
