package com.skilldistillery.jpavideostore.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Actor;
import com.skilldistillery.jpavideostore.entities.Film;
import com.skilldistillery.jpavideostore.entities.Language;

public class ActorDAOImpl implements ActorDAO{

	private static EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("VideoStore");
	
	@Override
	public Actor createActorAndFilm(Actor actor, Film film) {
		EntityManager em = emf.createEntityManager();
		
		Language language = em.find(Language.class, 1);
		film.setLanguage(language);
		
		actor.addFilm(film);
		em.getTransaction().begin();
		
		System.out.println("Before save " + actor);
		em.persist(actor);
		em.flush();
		System.out.println("After save " + actor);
		
		em.getTransaction().commit();
		em.close();
		return actor;
	}
	
	
	@Override
	public Actor create(Actor actor) {
		EntityManager em = emf.createEntityManager();

	// start the transaction
	em.getTransaction().begin();

	System.out.println("Pre-save actor id: " + actor.getId());
	// write the actor to the database
	em.persist(actor);

	System.out.println("Post-save actor id: " + actor.getId());
	// update the "local" Actor object
	em.flush();
	// commit the changes (actually perform the operation)
	em.getTransaction().commit();

	// return the Actor object
	return actor;
	
	
//	Actor anActor = new Actor("Fred", "Freddette");
//	Actor refreshActor = dao.update(205, actor);
	
	}
	
	@Override
	public Actor update(int id, Actor updatedActor){
		EntityManager em = emf.createEntityManager();
		
		  Actor foundActor = em.find(Actor.class, id);
		  
		  em.getTransaction().begin();
		  
		  foundActor.setFirstName(foundActor.getFirstName());
		  foundActor.setLastName(foundActor.getLastName());
		  em.flush();
		  

		  return foundActor;
		}
	
	@Override
	public boolean destroy(int id) {
		EntityManager em = emf.createEntityManager();
		Actor a = em.find(Actor.class, 1);
		em.getTransaction().begin();

		em.remove(a); // performs the delete on the managed entity

		em.getTransaction().commit();

		a.getFirstName();
		// a is now a detached entity and does not correspond to a row in the db...
		// ... however, it is still an object and can be used as such
		if (a == null)
			return true;
		else
			return false;
	}
}
