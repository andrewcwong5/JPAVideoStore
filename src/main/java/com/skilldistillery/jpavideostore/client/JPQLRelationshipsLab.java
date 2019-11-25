package com.skilldistillery.jpavideostore.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Customer;
import com.skilldistillery.jpavideostore.entities.Film;
import com.skilldistillery.jpavideostore.entities.InventoryItem;
import com.skilldistillery.jpavideostore.entities.Rental;
import com.skilldistillery.jpavideostore.entities.Store;

public class JPQLRelationshipsLab {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
	EntityManager em = emf.createEntityManager();
	JPQLRelationshipsLab lab = new JPQLRelationshipsLab();
	
	public static void main(String[] args) {

	}
	public List<Store> getStoresByState(String state) {
		
		 String queryString = "SELECT s FROM Store s WHERE s.state = :state";
		List<Object> results= em.createQuery(queryString, Object.class).getResultList();
		 List<Store> stores = new ArrayList<>() ;
		 results.stream().forEach(x->stores.add((Store)x));
		return stores;
		
	}
	
	public List<Rental> getRentalsForCustomerWithCustomerId(int id) {
		
		String queryString = "SELECT c FROM Customer c JOIN FETCH c.rentals WHERE c.id = :customer_id";
		Customer customer = em.createQuery(queryString, Customer.class)
				.setParameter("CustomerId", id)
				.getResultList()
				.get(0); 
		em.close();
		
		// Rentals were retrieved while em was still open.
		
		List<Rental> rentals = customer.getRentals();
		return rentals;
	}
	public List<Film> getInventoryForStoreWithId(int id) {
		List<Film> films = null;
		
//		//manytomany Store to Film going through inventory table
//		//dot notation when using JPA
//		String jpql = "SELECT f FROM Film f JOIN f.stores WHERE s.id = :sid";
//		films = em.createQuery(jpql, Film.class)
//		.setParameter("sid", id)
//		.getResultList();
		
		Store store = em.find(Store.class, id);
		films = store.getFilms();
		return films;
		}

	
	public int checkFilmInventoryItemsForStoreById(int id, String title) {
		int count = -1;
		String jpql = "SELECT COUNT(i) From InventoryItem i where i.store.id = :sid AND i.film.title = :title" ;
		long items = em.createQuery(jpql,InventoryItem.class)
				.setParameter("sid", id)
				.setParameter("title, title)"
				.getSingleResult();
			count = (int)items;
			return count;
	}
	public List<Film> getFilmsRentedForCustomerWithId(int id) {
		List<Film> films = null;
		String jpql = "SELECT f From film f join f.copies c join c.rentals r where r.customer.id = c.id";
		films = em.createQuery(jpql, Film.class)
				.setParameter("cid", id)
				.getResultList();
	return films;
	
	}
}
