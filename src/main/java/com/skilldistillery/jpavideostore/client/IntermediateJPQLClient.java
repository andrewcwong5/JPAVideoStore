package com.skilldistillery.jpavideostore.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Staff;

public class IntermediateJPQLClient {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
//		queries
		
//		String query = "SELECT s FROM Staff s ORDER BY s.lastName DESC";
//		
//		
//		List<Staff> results = em.createQuery(query, Staff.class).getResultList();
//		for (Staff staff : results) {
//			System.out.println(staff.getFirstName()+ " " + staff.getLastName());
//		}
//		String query1 = "SELECT COUNT(f) FROM Film f";	
//		long count = em.createQuery(query, Long.class).getSingleResult();	
//		System.out.println(count);
		
		String query3 = "SELECT s.firstName, COUNT(s) FROM Staff s GROUP BY s.firstName HAVING COUNT(s) > 1 ";
		List<Object[]> employeeNames = em.createQuery(query3, Object[].class).getResultList();
		for (Object[] employee: employeeNames) {
		System.out.println(employee[1] + " " + employee[0]);
		
			em.close();
			emf.close();
		}
		

		
		
	}

}
