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

class FilmTest {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Film film;

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
        film = em.find(Film.class, 1);
    }

    @AfterEach
    void tearDown() throws Exception {
        em.close();
        film = null;
    }

    @Test
    void test_Film_entity_mappings() {
        assertNotNull(film);
        assertEquals("ACADEMY DINOSAUR", film.getTitle());
        assertTrue(film.getDescription().startsWith("A Epic Drama of a Feminist"));
        assertEquals(1993, film.getReleaseYear());
        assertEquals(0.99, film.getRentalRate());
        assertEquals(86, film.getLength());
        assertEquals(20.99, film.getReplacementCost());
    }

    @Test
    void test_Film_enumeration_mappings() {
        assertNotNull(film);
        assertEquals(Rating.PG, film.getRating());
    }

    @Test
    void test_Film_Language_ManyToOne_relationship_mapping() {
        assertNotNull(film.getLanguage());
        assertEquals("Japanese", film.getLanguage().getName());
    }

    @Test
    void test_Film_Actor_ManyToMany_relationship_mapping() {
        assertNotNull(film.getActors());
        assertTrue(film.getActors().size() > 0);
    }
    
    @Test
    void test_Film_Category_ManyToMany_relationship_mapping() {
        assertNotNull(film.getCategories());
        assertTrue(film.getCategories().size() > 0);
        assertEquals("Documentary", film.getCategories().get(0).getName());
    }
    
    @Test
    void test_Film_Store_ManyToMany_relationship_mapping() {
        assertNotNull(film.getStores());
        assertTrue(film.getStores().size() > 0);
    }
    
    @Test
    void test_Film_InventoryItem_OneToMany_relationship_mapping() {
        assertNotNull(film.getCopies());
        assertTrue(film.getCopies().size() > 0);
    }
}
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//class FilmTest {
//	private static EntityManagerFactory emf;
//	private EntityManager em;
//	private Film film;
//	private Language lang;
//	
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//		emf = Persistence.createEntityManagerFactory("VideoStore");
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//		emf.close();
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//		em = emf.createEntityManager();
//		film = em.find(film.class, 1);
//		lang = em.find(lang.class, 1;)
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//		film = null;
//		lang = null;
//		em = null;
//		em.close();
//	}
//
//	@Test
//	@DisplayName("testing film entity mappings")
//	void test() {
//		Film film = em.find(Film.class, 1);
//		assertEquals("Academy Dinosaur", film.getTitle().toUpperCase());
//		// assertTrue();
//		assertEquals(1993, film.getReleaseYear());
//	}
//	@Test
//	@DisplayName("testing film rating")
//	void testforRating() {
//		assertEquals("PG", film.getRating().toString());
////		assertEquals("Rating.PG, film.getRating()");
//	}
//	@Test
//	void test_has_a_language() {
//		assertEquals("english", film.getLanguage().getName());
//	}
//	@Test
//	void test_language_has_list_of_films() {
//		assertEquals(982, lang.getFilms().size());
//		assertEquals("ACE GOlDFINGER", lang.getFilms().get(0).getTitle());
//	}
//}
