package com.skilldistillery.jpavideostore.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IntermediateJPQLLab {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
		
		
//		calculates the average length of the films in the database
		
		String query = "SELECT AVG(f.length) FROM Film f";

		double average = em.createQuery(query, Double.class).getSingleResult();
		
		System.out.println(average);
		
		
		
//		calculates the number of addresses grouped by their state
		
		String query1 = "SELECT f.state, COUNT(f) FROM Address f GROUP BY f.state HAVING COUNT(s) > 1";	
		List<Object[]> stateAddress = em.createQuery(query1, Object[].class).getResultList();
		for (Object[] address: stateAddress) {
		System.out.println(address[1] + " " + address[0]);
		}
//		long count = em.createQuery(query1, Long.class).getSingleResult();	
//		System.out.println(count);
	}

}
