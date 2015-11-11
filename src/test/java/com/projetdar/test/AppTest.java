package com.projetdar.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.projetdar.dao.MuseeAvisDAO;
import com.projetdar.entity.Admin;
import com.projetdar.entity.Avis;
import com.projetdar.service.AdminManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
@TransactionConfiguration
// @Transactional
public class AppTest extends AbstractTransactionalJUnit4SpringContextTests {
	private AdminManager dao;

	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:beans.xml" });
		dao = (AdminManager) context.getBean("adminManager");
	}

	@Test
	public void test() {
		// Musee m = new Musee("Louvre", "Pharaon", "Paris", "url", "image");
		// dao.addMusee(m);
		// assertTrue(dao.getAllMusees().size() == 3);

//		Musee m2 = dao.getMuseeById(2L);
//		m2.setAdresse("Versaille");
//		m2.setDescription("Hadi Versaille akhali");
//		m2.setImage("photooo");
//		m2.setNom("Mus�e de Versaille");
//		m2.setUrl("www.versaille.fr");
//		dao.updateMusee(m2);
//		dao.deleteMusee(3L);
//		assertTrue(dao.getAllMusees().size() == 2);
		Admin a = dao.getAdminByLogin("hamza9");
		assertTrue(a==null);
	}
}