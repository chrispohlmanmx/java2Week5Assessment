/**
 * @author Christopher Pohlman - cmpolhman
 * CIS175 - Spring 2022
 * Feb 24, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GameLibrary;

/**
 * 
 */
public class GameLibraryHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("VideoGames");
	
	public void insertNewGameLibrary(GameLibrary gl) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(gl);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<GameLibrary> getLibraries(){
		EntityManager em = emfactory.createEntityManager();
		List<GameLibrary> allLibraries = em.createQuery("SELECT gl FROM GameLibrary gl").getResultList();
		return allLibraries;
	}

	/**
	 * @param tempId
	 * @return
	 */
	public GameLibrary searchForGameLibraryById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		GameLibrary found = em.find(GameLibrary.class, tempId);
		em.close();
		return found;
	}

	/**
	 * @param toDelete
	 */
	public void deleteLibrary(GameLibrary toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<GameLibrary> typedQuery = em.createQuery("select gl from GameLibrary gl where gl.id = :selectedId", GameLibrary.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		typedQuery.setMaxResults(1);
		GameLibrary result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
		
	}
}
