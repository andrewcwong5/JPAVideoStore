package com.skilldistillery.jpavideostore.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
// SD23 https://thoughts-on-java.org/common-hibernate-mistakes-cripple-performance/
import com.skilldistillery.jpavideostore.entities.Address;
import com.skilldistillery.jpavideostore.entities.Customer;
import com.skilldistillery.jpavideostore.entities.Language;
public class CustomerDAOImpl implements CustomerDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
    public boolean deleteAddress(int id) {
        boolean success = false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // find managed address to remove
        Address address = em.find(Address.class, id);
        if (address != null) {
            em.remove(address);
        }
        success = ! em.contains(address); 
        em.getTransaction().commit();
        return success;
    }
    
    
    public boolean updateNullEmails() {
        EntityManager em = emf.createEntityManager();
        boolean success = false;
        em = emf.createEntityManager();
        em.getTransaction().begin();
        String jpql = "SELECT customer FROM Customer customer WHERE customer.email IS NULL OR customer.email = ''";
        List<Customer> customers = em.createQuery(jpql, Customer.class).getResultList();
        for (Customer customer : customers) {
            customer.setEmail(customer.getFirstName() + "." + customer.getLastName() + "@sdcustomer.org");
        }
        em.flush();
        em.getTransaction().commit();
        success = true;
        return success;
    }
    public List<Customer> getCustomersWithNullEmail() {
        EntityManager em = emf.createEntityManager();
        em = emf.createEntityManager();
        String jpql = "SELECT customer FROM Customer customer WHERE customer.email IS NULL OR customer.email = ''";
        List<Customer> customers = em.createQuery(jpql, Customer.class).getResultList();
        return customers;
    }
    public Address createAddress(Address addr) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(addr);
        em.flush();
        em.getTransaction().commit();
        em.close();
        return addr;
    }
    public Address getAddress(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Address.class, id);
    }
    // SD23 bulk update, instead of forEach
    @Override
    public int bulkUpdate(String oldCity, String newCity) {
        String updateJpql = "UPDATE Address address SET address.city = :newCity WHERE address.city = :oldCity";
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.flush();   // flush pending changes to the database
        em.clear();   // clean up current persistence context
        
        int numChanged = em.createQuery(updateJpql)
           .setParameter("newCity",  newCity)
           .setParameter("oldCity",  oldCity)
           .executeUpdate();
        
        em.getTransaction().commit();
        return numChanged;
    }
    
    @Override
    public boolean bulkUpdateSlow(String oldCity, String newCity) {
        EntityManager em = emf.createEntityManager();
        boolean success = false;
        em = emf.createEntityManager();
        em.getTransaction().begin();
        String jpql = "SELECT address FROM Address address WHERE address.city = :oldCity";
        List<Address> addresses = em.createQuery(jpql, Address.class)
                .setParameter("oldCity", oldCity).getResultList();
        for (Address addr : addresses) {
            addr.setCity(newCity);
        }
        em.flush();
        em.getTransaction().commit();
        success = true;
        return success;
    }


	@Override
	public Customer createCustomerAndAddress(Customer cust, Address addr) {
		EntityManager em = emf.createEntityManager();
		
		cust.addAddress(addr);
		em.getTransaction().begin();
		
		System.out.println("Before save " + actor);
		em.persist(actor);
		em.flush();
		System.out.println("After save " + actor);
		
		em.getTransaction().commit();
		em.close();
		return actor;
		return null;
	}
}