package org.mivotocuenta.client.service;

import org.mivotocuenta.server.beans.Usuario;
import org.mivotocuenta.shared.UnknownException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("servicegestionusuario")
public interface ServiceGestionUsuario extends RemoteService {
	Boolean insertarUsuario(Usuario bean) throws UnknownException;
}
