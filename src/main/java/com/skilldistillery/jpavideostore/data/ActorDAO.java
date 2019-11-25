package com.skilldistillery.jpavideostore.data;

import com.skilldistillery.jpavideostore.entities.Actor;
import com.skilldistillery.jpavideostore.entities.Film;

public interface ActorDAO {
	public Actor create(Actor actor);
	public Actor update(int id, Actor actor);
	public boolean destroy(int id);
	
	public Actor createActorAndFilm(Actor actor, Film film);
}
