package org.mivotocuenta.client.service;

import org.mivotocuenta.server.beans.Usuario;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServiceGestionUsuarioAsync {

	void insertarUsuario(Usuario bean, AsyncCallback<Boolean> callback);

}
