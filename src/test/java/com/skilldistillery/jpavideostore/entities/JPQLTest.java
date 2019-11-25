package com.skilldistillery.jpavideostore.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.skilldistillery.jpavideostore.client.JPQLLab;

class JPQLTest_SD23 {
	private JPQLLab_SD23 dao;

	@BeforeEach
	void setUp() throws Exception {
		dao = new JPQLLab_SD23();
	}

	@AfterEach
	void tearDown() throws Exception {
		dao = null;
	}

	@Disabled
	@Test
	@DisplayName("testing get customer emails for id range")
	void test1() {
		assertEquals("DOROTHY.TAYLOR@sdvidcustomer.org", dao.getRangeOfCustomers(10, 15).get(0).getEmail());
	}

//  @Disabled
	@Test
	@DisplayName("testing get customer names for id range")
	void test2() {
		List<Object[]> names = dao.getRangeOfCustomerNames(10, 15);
		assertEquals(6, names.size());
		assertEquals("Dorothy", names.get(0)[0]);
	}

//  @Disabled
	@Test
	@DisplayName("testing get Customer email by bad name returns null")
	void test3() {
		String email = dao.getCustomerEmailByName("Trence", "Gunderson");
		assertNull(email);
	}

//  @Disabled
	@Test
	@DisplayName("testing get Customer email by  name")
	void test4() {
		String email = dao.getCustomerEmailByName("Terrence", "Gunderson");
		assertEquals("TERRENCE.GUNDERSON@sdvidcustomer.org", email);
	}

	@Disabled
	@Test
	@DisplayName("testing get film by title")
	void test5() {
		Film film = dao.getFilmByTitle("Academy");
		assertEquals("academy dinosaur", film.getTitle().toLowerCase());
	}

	@Disabled
	@Test
	@DisplayName("testing get films by release year")
	void test6() {
		int count = dao.getFilmsTitlesByReleaseYear(1993).size();
		assertEquals(26, count);
	}

	@Disabled
	@Test
	@DisplayName("getSingleResult not good idea")
	public void test7() {
		assertEquals("academy dinosaur", dao.getFilmByTitleUsingGetSingleResultWhichINeverRecommend("Academy Dinosaur")
				.getTitle().toLowerCase());
		Exception e = assertThrows(Exception.class,
				() -> dao.getFilmByTitleUsingGetSingleResultWhichINeverRecommend("xkcd"));

	}

}
