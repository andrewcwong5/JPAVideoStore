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

import com.skilldistillery.jpavideostore.data.ActorDAO;

class ActorTest {
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

	@Test
	@DisplayName("testing actor entity mappings")
	void test() {
		Actor actor = em.find(Actor.class, 1);
		assertEquals("Penelope", actor.getFirstName());
		assertEquals("Guiness", actor.getLastName());
	}
	@Test
	@DisplayName("testing delete")
	void testDelete() {
		Actor dao = em.find(Actor.class, 1);
		
	}
	
//	@Test
//	void test2("test map of actors to films")
//	
//	//select count(*) from film_actor where actor id = 1;
//			assertEquals(19, actor.getFilms());
//			)
//@Test
//void test3("test map of actors to films")
//
////select count(*) from film_actor where actor id = 1;
//		assertEquals(19, film.getActor());
}
