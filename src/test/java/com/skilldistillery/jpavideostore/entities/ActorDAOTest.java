package com.skilldistillery.jpavideostore.entities;

import com.skilldistillery.jpavideostore.data.ActorDAO;
import com.skilldistillery.jpavideostore.data.ActorDAOImpl;

class ActorDAOTest {
	public static void main(String[] args) {
		ActorDAO dao = new ActorDAOImpl();
		
		Actor actor = new Actor ("Fred Fredette");
		Film film = new Film ();
		film.setTitle("a title");
		film.setRentalRate(.99);
		film.setReplacementCost(1.99);
		
		Actor newActor = dao.createActorAndFilm(actor, film);
		System.out.println("new actors film: " + newActor.getFilms().get(0).getTitle());
	}

}
