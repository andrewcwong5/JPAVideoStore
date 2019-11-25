package com.skilldistillery.jpavideostore.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StaffTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	
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

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	@Test
	void test_last_Name_mappings() {
		Staff staff = em.find(Staff.class, 1);
		assertEquals("Smithers", staff.getLastName());
	}
	@Test
	void test_first_Name_mappings() {
		Staff firstName = em.find(Staff.class, 1);
		assertEquals("Smithers", firstName.getFirstName());
	}
	@Test
	void test_email_mappings() {
		Staff email = em.find(Staff.class, 1);
		assertEquals("Smithers", email.getFirstName());
	}
}
