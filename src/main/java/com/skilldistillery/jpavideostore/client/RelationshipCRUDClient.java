package com.skilldistillery.jpavideostore.client;

import com.skilldistillery.jpavideostore.data.ActorDAO;
import com.skilldistillery.jpavideostore.data.ActorDAOImpl;
import com.skilldistillery.jpavideostore.data.CustomerDAO;
import com.skilldistillery.jpavideostore.data.CustomerDAOImpl;
import com.skilldistillery.jpavideostore.entities.Actor;
import com.skilldistillery.jpavideostore.entities.Address;
import com.skilldistillery.jpavideostore.entities.Customer;
import com.skilldistillery.jpavideostore.entities.Film;

public class RelationshipCRUDClient {

	
	public static void main(String[] args) {
		
		RelationshipCRUDClient rcc = new RelationshipCRUDClient();
		rcc.addNewActorToFilm();
	}
	
	public void addNewActorToFilm() {
	
	ActorDAO dao = new ActorDAOImpl();
	
	Actor actor = new Actor ("Sponge Bob");
	Film film = new Film ();
	film.setTitle("LADYBUGS ARMAGEDDON");
	film.setId(507);
	Actor newActor = dao.createActorAndFilm(actor, film);
	}
	public void newCustomerAndAddress() {
		CustomerDAO dao = new CustomerDAOImpl();
		Customer cust = new Customer();
		Address addr = new Address();
		addr.setStreet("street");
		addr.setCity("city");
		addr.setState("state");
		addr.setPhone("1233455678");
		Customer newCustomer = dao.createCustomerAndAddress();
	}
}
