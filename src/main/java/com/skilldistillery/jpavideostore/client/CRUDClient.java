package com.skilldistillery.jpavideostore.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Address;
import com.skilldistillery.jpavideostore.entities.Staff;

public class CRUDClient {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
	EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		CRUDClient cc = new CRUDClient();
		updateNullEmails(int id, Staff updatedStaff);
	}
	public Staff updateNullEmails(int id, Staff updatedStaff) {
		
		String queryString = "Select s from customer s where email IS null";
		
//		List<Staff> staffs1 = em.createQuery(jpql, Staff.class).getResultList();
//		for (Staff staff : staffs1)
		Staff foundStaff = em.find(Staff.class, id);
		em.getTransaction().begin();
		foundStaff.setEmail(foundStaff.getFirstName()
							+"."+foundStaff.getLastName()+"@sdcustomer.org");
		em.flush();
	 return foundStaff;
	 
		if (email.equals("null")) {
			
	}
		public boolean updateNullEmails() {
			EntityManager em 0 emf.create();
			boolean success = false;
			em.getTransaction().begin();
			
		}
		
		
		
//	public Address addNewAddress(Address addr) {
//		
//	}
	
	public boolean deleteAddress(int id) {
		boolean success = false;
		Address address = em.find(Address.class, 1);
		if (address != null)
			em.remove(address);
		
		
	}

		  
		  
		  
		  

		 
		}
}
