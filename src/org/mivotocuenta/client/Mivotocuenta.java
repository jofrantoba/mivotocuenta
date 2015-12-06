package org.mivotocuenta.client;


import org.mivotocuenta.client.service.ServiceGestionCandidato;
import org.mivotocuenta.client.service.ServiceGestionCandidatoAsync;
import org.mivotocuenta.server.beans.Candidato;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Mivotocuenta implements EntryPoint {
	private final ServiceGestionCandidatoAsync SERVICE = GWT
			.create(ServiceGestionCandidato.class);
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		Candidato bean=new Candidato();
		//bean.setIdCandidato(1L);
		bean.setCandidato("Cesar Acuña");
		bean.setOperacion("I");
		SERVICE.insertarCandidato(bean, new AsyncCallback<Boolean>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				Window.alert(result.toString());
			}});
	}
	
}
