package com.skilldistillery.jpavideostore.client;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.skilldistillery.jpavideostore.entities.Customer;
import com.skilldistillery.jpavideostore.entities.Film;

public class JPQLLab {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
	private EntityManager em;

	public List<Customer> getRangeOfCustomers(int low, int hi) {
		em = emf.createEntityManager();

		String jpql = "SELECT customer FROM Customer customer WHERE customer.id BETWEEN :lowId AND :hiId ORDER BY customer.id";

		List<Customer> custs = em.createQuery(jpql, Customer.class).setParameter("lowId", low).setParameter("hiId", hi)
				.getResultList();

		em.close();
		return custs;
	}

	public List<Object[]> getRangeOfCustomerNames(int low, int hi) {
		em = emf.createEntityManager();
		String jpql = "SELECT ct.firstName, ct.lastName FROM Customer ct WHERE ct.id BETWEEN :lowId AND :hiId";
		List<Object[]> custs = em.createQuery(jpql, Object[].class).setParameter("lowId", low).setParameter("hiId", hi)
				.getResultList();

		em.close();
		return custs;
	}

	public String getCustomerEmailByName(String fn, String ln) {
		em = emf.createEntityManager();
		String jpql = "SELECT ct.email FROM Customer ct WHERE ct.firstName = :fn AND ct.lastName = :ln";
		List<String> custs = em.createQuery(jpql, String.class).setParameter("fn", fn).setParameter("ln", ln)
				.getResultList();

		em.close();
		return custs.size() == 0 ? null : custs.get(0);
	}

	public Film getFilmByTitle(String title) {
		em = emf.createEntityManager();
		String jpql = "SELECT film FROM Film film WHERE film.title LIKE :title";
		List<Film> films = em.createQuery(jpql, Film.class).setParameter("title", "%" + title + "%").getResultList();

		em.close();
		return films.size() == 0 ? null : films.get(0);
	}

	public List<String> getFilmsTitlesByReleaseYear(int yr) {
		em = emf.createEntityManager();
		String jpql = "SELECT film.title FROM Film film WHERE film.releaseYear = :year ORDER BY film.title";
		List<String> films = em.createQuery(jpql, String.class).setParameter("year", yr).getResultList();

		em.close();
		return films;
	}

	public Film getFilmByTitleUsingGetSingleResultWhichINeverRecommend(String title) {
		String jpql = "SELECT film FROM Film film WHERE film.title = :t";
		em = emf.createEntityManager();
		Film film = em.createQuery(jpql, Film.class).setParameter("t", title).getSingleResult();

		Film result = null;
		if (film != null) {
			result = film;
		}
		em.close();
		return result;
	}

	public static void closeEMF() {
		emf.close();
	}
}
//package com.skilldistillery.jpavideostore.client;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import com.skilldistillery.jpavideostore.entities.Customer;
//import com.skilldistillery.jpavideostore.entities.Staff;
//
//public class JPQLLab {
//
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
//	EntityManager em = emf.createEntityManager();
//	
//	public List<Customer> getRangeofCustomers(int low, int high) {
//		em = emf.createEntityManager();
//		String jpql = "Select customer FROM Customer customer WHERE id BETWEEN: lowId ANd :highId";
//		List<Customer> custs = em.createQuery(jpql, Customer.class)
//								.setParameter("lowId", low) //binds low parameter
//								.setParameter("highId", high)
//								.getResultList();
//		
//		em.close();
//		return result;
//	}
//	
//	
//}

//	
//	String jpql = null;
//	
//	{
//		int minId = 100;
//		int maxId = 110;
//	jpql = "SELECT splat FROM staff splat WHERE splat.id BETWEEN minId AND maxId";
//	
//	List<Staff> staffs1 = em.createQuery(jpql, Staff.class).getResultList();
//		for (Staff staff : staffs1) {
//		System.out.println(staff.getFirstName()+ " " + staff.getEmail());
//		
//		
//		em.close();
//		emf.close();
//		}
//	System.out.println();
//	}
//	
//		
//		
//	String queryString = "SELECT s FROM Staff s";
//	List<Staff> staffs2 = em.createQuery(queryString, Staff.class).getResultList(); 
//	{
//	for (Staff staff : staffs2) {
//		System.out.println(staff.getFirstName()+ " " + staff.getEmail());
//	return staff;
//	}
//}
//}
//}
