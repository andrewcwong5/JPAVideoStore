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

class InventoryItemTest {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private InventoryItem item;

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
        item = em.find(InventoryItem.class, 1);
    }

    @AfterEach
    void tearDown() throws Exception {
        em.close();
        item = null;
    }

    @Test
    public void test_InventoryItem_entity_mappings() {
        assertNotNull(item);
        assertEquals(MediaCondition.Used, item.getMediaCondition());
    }
    
    @Test
    public void test_InventoryItem_Film_ManyToOne_relationship_mapping() {
        assertNotNull(item.getFilm());
        assertEquals("ACADEMY DINOSAUR", item.getFilm().getTitle());
    }
    
    @Test
    public void test_InventoryItem_Store_ManyToOne_relationship_mapping() {
        assertNotNull(item.getStore());
        assertEquals("LaFever", item.getStore().getManager().getLastName());
    }
}
//import static org.junit.jupiter.api.Assertions.*;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class InventoryItemTest {
//	private static EntityManagerFactory emf;
//	private EntityManager em;
//	
//	InventoryItem item;
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
//		
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//		em.close();
//	}
//
//	@Test
//	public void test_InventoryItem_entity_map() {
//		assertNotNull(item);
//		assertEquals("MediaCondition.Used", item.getMediaCondition());
//	}
//	@Test
//	public void test_InventoryItem_File_ManyToOne_relationship_mapping() {
//		assertNotNull(item.getFilm());
//		assertEquals("Academy Dinosaur", getFilm().getTitle());
//	}
//	@Test
//	public void test_InventoryItem_File_OneToMany() {
//		assertTRue(item.getRentals().size()> 0);
//	}
//}
