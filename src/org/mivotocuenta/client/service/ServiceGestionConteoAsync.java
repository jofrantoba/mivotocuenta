package org.mivotocuenta.client.service;

import org.mivotocuenta.server.beans.Conteo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServiceGestionConteoAsync {

	void insertarVoto(Conteo bean, AsyncCallback<Boolean> callback);

}
