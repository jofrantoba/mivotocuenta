package org.mivotocuenta.server.process;

import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import org.mivotocuenta.server.beans.Usuario;
import org.mivotocuenta.server.dao.PMF;
import org.mivotocuenta.server.logic.LogicUsuario;
import org.mivotocuenta.shared.BeanParametro;
import org.mivotocuenta.shared.UnknownException;


public class GestionUsuario {
	private static final Logger LOG = Logger.getLogger(GestionUsuario.class
			.getName());
	
	public static Boolean insertarUsuario(Usuario bean) throws UnknownException {
		if (bean.getOperacion().equalsIgnoreCase("I")
				&& bean.getCorreo() != null) {			
			BeanParametro parametro = new BeanParametro();	
			PersistenceManager pm = null;
			Transaction tx = null;
			try {
				parametro.setBean(bean);
				parametro.setTipoOperacion(bean.getOperacion());
				pm = PMF.getPMF().getPersistenceManager();
				tx = pm.currentTransaction();
				tx.begin();
				LogicUsuario logic = new LogicUsuario(pm);												
				Boolean resultado1 = logic.mantenimiento(parametro);		
				if (resultado1) {
					tx.commit();
					pm.close();
					return true;
				} else {
					tx.rollback();
					pm.close();
					return false;
				}				
			} catch (Exception ex) {
				LOG.warning(ex.getMessage());
				LOG.info(ex.getLocalizedMessage());
				throw new UnknownException(ex.getMessage());
			} finally {
				if (!pm.isClosed()) {
					if (tx.isActive()) {
						tx.rollback();
					}
					pm.close();
				}
			}
		} else {
			throw new UnknownException("Verifique Catalogo de Servicio");
		}
	}
	
}
