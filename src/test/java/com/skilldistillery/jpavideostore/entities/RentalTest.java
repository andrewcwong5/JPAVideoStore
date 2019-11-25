package com.skilldistillery.jpavideostore.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RentalTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Rental rental;
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
	@DisplayName("testing RentalDate")
	void test_rental_temporal_annotations() {
		Rental rental = em.find(Rental.class, 1);
		assertEquals("2014-05-24", rental.getRentalDate().toString());
		assertEquals("2014-05-26", rental.getReturnDate().toString());
		
	}
//	@Test
//	@DisplayName("testing ReturnDate")
//	void test_returnDate_temporal_annotations() {
//		Rental rental = em.find(Rental.class, 1);
//		assertEquals("2014-05-26", rental.getReturnDate().toString());
//		
//	}
	@Test
	void test_Rental_InventoryItem_ManyToOne() {
		asertNotNUll(rental)
		//select * FROM rental WHERE id = 1;
		assertEquals("Montery Labyrihting", item)
	}
}
