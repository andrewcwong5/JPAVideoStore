package com.skilldistillery.jpavideostore.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Language;

public class LanguageClient {

	public static void main(String[] args) {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
EntityManager em = emf.createEntityManager();

	Language addr = em.find(Language.class, 1);
	System.out.println(addr);
	
	em.close();
	emf.close();
	}

}
