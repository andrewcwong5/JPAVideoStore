package com.skilldistillery.jpavideostore.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Customer customer;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 emf = Persistence.createEntityManagerFactory("VideoStore");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		 emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		 em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		 em.close();
	}
	@Test
	void test_Customer_mappings() {
		Customer cust = em.find(Customer.class, 1);
		assertEquals("Smithers", cust.getLastName());
	}
	@Test
	@DisplayName("testing createdAt date")
	void test_customer_temporal_annotations() {
		Customer cust = em.find(Customer.class, 1);
		assertEquals("2014-05-25", cust.getCreatedAt().toString());
		
	}

}
