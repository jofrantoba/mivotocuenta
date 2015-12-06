package org.mivotocuenta.client.service;

import org.mivotocuenta.server.beans.Candidato;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServiceGestionCandidatoAsync {

	void insertarCandidato(Candidato bean, AsyncCallback<Boolean> callback);

}
