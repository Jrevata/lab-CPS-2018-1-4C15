package com.tecsup.gestion.dao;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Deparment;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration
public class DeparmentDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(DeparmentDAOTest.class);

	@Autowired
	private DeparmentDAO deparmentDAO;

	
	@BeforeClass
	public static void beforeClass() {
		logger.info("Antes de todos los metodos");

	}
	
	@Before
	public  void before() {
		logger.info("Antes de cada metodo");
	}
	
	@Test
	public void testFindDepartmentById() {

		try {
			//
			Deparment depa = deparmentDAO.findDeparmentById(47);

			Assert.assertNotNull(depa);

			Assert.assertEquals("gomez", depa.getName());
			Assert.assertEquals("profesor", depa.getDescription());
			Assert.assertEquals("santa anita" , depa.getCity());

			logger.info(depa.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	public void testCreateDepartment() {
		
		logger.info("--");
		
		String NAME = "Jordan" + (int)(Math.random() * 1000);
		String DESCRIPTION = "Osado :v";
		String CITY = "Lima";

		try {
			//
			deparmentDAO.create(NAME,DESCRIPTION,CITY);
			
			int id = deparmentDAO.findAllDepartments().get(deparmentDAO.findAllDepartments().size()-1).getDeparement_id(); //easy optimization, easy life  :V
			
			Deparment depa = deparmentDAO.findDeparmentById(id);
			
			Assert.assertEquals(NAME, depa.getName());
			Assert.assertEquals(DESCRIPTION, depa.getDescription());
			Assert.assertEquals(CITY, depa.getCity());
			

		} catch (DAOException e) {
			fail(e.getMessage());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	public void testUpdateDepartment() {
		
		String NAME = "Axel" + (int)(Math.random() * 1000);
		String DESCRIPTION = "Otro osado";
		String CITY = "Ate";
		
		String UP_NAME = "Axel" + (int)(Math.random() * 1000);
		String UP_DESCRIPTION = "OTRO osado " + (int)(Math.random() * 100);
		String UP_CITY = "Ate" + (int)(Math.random() * 100);
		
		
		try {
			//
			deparmentDAO.create(NAME, DESCRIPTION, CITY);
			//
			deparmentDAO.update(UP_NAME,UP_DESCRIPTION,UP_CITY);
			//
			int codigo = deparmentDAO.findAllDepartments().get(deparmentDAO.findAllDepartments().size()-1).getDeparement_id();
			Deparment emp = deparmentDAO.findDeparmentById(codigo);

			Assert.assertEquals(UP_NAME, emp.getName());
			Assert.assertEquals(UP_DESCRIPTION, emp.getDescription());
			Assert.assertEquals(UP_CITY, emp.getCity());

		} catch (DAOException e) {
			fail(e.getMessage());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testDeleteDeparment() {

		String NAME = "Revata" + (int)(Math.random() * 1000);
		String DESCRIPTION = "Un osado";
		String CITY = "San borja";

		try {
			//
			deparmentDAO.create(NAME,DESCRIPTION,CITY);

		} catch (DAOException e) {
			fail(e.getMessage());
		}

		try {

			int codigo = deparmentDAO.findAllDepartments().get(deparmentDAO.findAllDepartments().size()-1).getDeparement_id();
			deparmentDAO.delete(codigo);

			deparmentDAO.findDeparmentById(codigo);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyResultException e) {
			// Usuario borrado 
			return;
		}
	}
	
	@After
	public void after() {
		logger.info("Despues de cada metodo");
	}
	
	@AfterClass
	public static void afterClass() {
		logger.info("Despues de todos los metodos");
	}
}
