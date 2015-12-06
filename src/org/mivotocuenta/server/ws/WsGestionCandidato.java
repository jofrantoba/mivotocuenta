package org.mivotocuenta.server.ws;

import org.mivotocuenta.server.beans.Candidato;
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

@Api(name = "wsgestioncandidato", namespace = @ApiNamespace(ownerDomain = "mivotocuenta.org", ownerName = "mivotocuenta.org", packagePath = "server.ws"))
public class WsGestionCandidato {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listCandidato")
	public CollectionResponse<Candidato> listCandidato(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<Candidato> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(Candidato.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<Candidato>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Candidato obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Candidato> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getCandidato")
	public Candidato getCandidato(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Candidato candidato = null;
		try {
			candidato = mgr.getObjectById(Candidato.class, id);
		} finally {
			mgr.close();
		}
		return candidato;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param candidato the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertCandidato")
	public Candidato insertCandidato(Candidato candidato) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsCandidato(candidato)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.makePersistent(candidato);
		} finally {
			mgr.close();
		}
		return candidato;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param candidato the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateCandidato")
	public Candidato updateCandidato(Candidato candidato) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsCandidato(candidato)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(candidato);
		} finally {
			mgr.close();
		}
		return candidato;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeCandidato")
	public void removeCandidato(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Candidato candidato = mgr.getObjectById(Candidato.class, id);
			mgr.deletePersistent(candidato);
		} finally {
			mgr.close();
		}
	}

	private boolean containsCandidato(Candidato candidato) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Candidato.class, candidato.getIdCandidato());
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
