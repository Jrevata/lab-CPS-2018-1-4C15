package com.tecsup.gestion.dao.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.gestion.dao.DeparmentDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.mapper.DeparmentMapper;
import com.tecsup.gestion.mapper.EmployeeMapper;
import com.tecsup.gestion.model.Deparment;
import com.tecsup.gestion.model.Employee;


@Repository
public class DeparmentDAOImpl implements DeparmentDAO {

	private static final Logger logger = LoggerFactory.getLogger(DeparmentDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public Deparment findDeparmentById(int id) throws DAOException, EmptyResultException {
		String query = "SELECT department_id, name , description , city "
				+ " FROM departments WHERE department_id = ?";

		Object[] params = new Object[] { id };

		try {

			Deparment depa = (Deparment) jdbcTemplate.queryForObject(query, params, new DeparmentMapper());
			//
			return depa;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void create(String name, String description, String city) throws DAOException {
		
		String query = "INSERT INTO departments (name, description, city)  VALUES ( ?,?,? )";

		Object[] params = new Object[] { name, description, city };

		Deparment depa = null;
		
		try {
			
			List<Deparment> depas = this.findAllDepartments();
			int cod1 = depas.get(depas.size()-1).getDeparement_id();
			
			jdbcTemplate.update(query, params);
			
			List<Deparment> depas2 = this.findAllDepartments();
			int cod2 = depas2.get(depas.size()-1).getDeparement_id();
			
			if(cod2 > cod1)
				depa = this.findDeparmentByName(name);
			
		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public void update(String name, String description, String city) throws DAOException {
		
		String query = "UPDATE departments SET name = ?, description =?, city = ? WHERE department_id = ?";
		
		try {
		List<Deparment> depas = this.findAllDepartments();
		int codigo = depas.get(depas.size()-1).getDeparement_id();
		Object[] params = new Object[] { name, description, city , codigo};

		
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		

	}

	@Override
	public void delete(int id) throws DAOException {
		String query = "DELETE FROM  departments WHERE department_id = ? ";

		Object[] params = new Object[] { id };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public Deparment findDeparmentByName(String name) throws DAOException, EmptyResultException {
		String query = "SELECT department_id, name , description , city "
				+ " FROM departments WHERE name = ?";

		Object[] params = new Object[] { name };

		try {

			Deparment depa = (Deparment) jdbcTemplate.queryForObject(query, params, new DeparmentMapper());
			//
			return depa;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<Deparment> findAllDepartments() throws DAOException, EmptyResultException {
		String query = "SELECT department_id , name , description , city FROM departments ";

		try {

			List<Deparment> depas = jdbcTemplate.query(query, new DeparmentMapper());
			//
			return depas;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

}
