package org.mivotocuenta.client.service;

import org.mivotocuenta.server.beans.Conteo;
import org.mivotocuenta.shared.UnknownException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("servicegestionconteo")
public interface ServiceGestionConteo extends RemoteService {
	Boolean insertarVoto(Conteo bean) throws UnknownException;
}
