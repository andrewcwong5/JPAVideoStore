package com.skilldistillery.jpavideostore.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Staff;

public class JPQLClient {

	
	
	public static void main(String[] args) {
		JPQLClient fakeDAO = new JPQLClient();
		List<Staff> staffs = fakeDAO.getStaffWithIdLessThan10();
		
		for (Staff staff : staffs) {
			System.out.println();
		}
		
		//2
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
		String jpql = null;
		jpql = "SELECT splat FROM staff splat WHERE splat.id < 10";
		
		List<Staff> staffs1 = em.createQuery(jpql, Staff.class).getResultList();
		for (Staff staff : staffs1) {
			System.out.println(staff.getFirstName()+ " " + staff.getEmail());
			
			
			em.close();
			emf.close();
		}
		System.out.println();
		
		String jpql2 = null;
		jpql = "SELECT staff.last_name FROM staff staff WHERE staff.id <10";
		
	}
		public List<Staff> getStaffWithIdLessThan10() {
			EntityManager em = emf.createEntityManager();
			
			String jpql = null;
			int idNum = 10;
			
			jpql = "Select splat FROM Staff splat WHERE splat.id = :idNum";
			
			List<Staff> staffs = em.createQuery(jpql, Staff.class);
					.setParameter("idNum", parm)
					.getResultList();
					
			
		}
	
		
		List<String> lastNames = fakeDAO.getStaffWithIdLess10();
		for (String s : lastNames) {
			System.out.println(s);
			
	}
		String queryString = "Selects.firstName, s.lastName FROM Staff s";
		
		List<Object[]> names = fakeDAO.getStaffWithIdLess10();
		for (Object[] column : columns) {
			System.out.println("First: " + column[0] + " Last: " + column[1]);
		

}
