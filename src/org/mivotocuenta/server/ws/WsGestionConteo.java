package org.mivotocuenta.server.ws;

import org.mivotocuenta.server.beans.Conteo;
import org.mivotocuenta.server.dao.PMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "wsgestionconteo", namespace = @ApiNamespace(ownerDomain = "mivotocuenta.org", ownerName = "mivotocuenta.org", packagePath = "server.ws"))
public class WsGestionConteo {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listConteo")
	public CollectionResponse<Conteo> listConteo(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<Conteo> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(Conteo.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<Conteo>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Conteo obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Conteo> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getConteo")
	public Conteo getConteo(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Conteo conteo = null;
		try {
			conteo = mgr.getObjectById(Conteo.class, id);
		} finally {
			mgr.close();
		}
		return conteo;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param conteo the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertConteo")
	public Conteo insertConteo(Conteo conteo) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsConteo(conteo)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.makePersistent(conteo);
		} finally {
			mgr.close();
		}
		return conteo;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param conteo the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateConteo")
	public Conteo updateConteo(Conteo conteo) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsConteo(conteo)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(conteo);
		} finally {
			mgr.close();
		}
		return conteo;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeConteo")
	public void removeConteo(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Conteo conteo = mgr.getObjectById(Conteo.class, id);
			mgr.deletePersistent(conteo);
		} finally {
			mgr.close();
		}
	}

	private boolean containsConteo(Conteo conteo) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Conteo.class, conteo.getIdConteo());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.getPMF().getPersistenceManager();
	}

}
