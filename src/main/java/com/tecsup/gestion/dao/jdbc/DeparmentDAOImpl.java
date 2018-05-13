package com.tecsup.gestion.dao.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.gestion.dao.DeparmentDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Deparment;


@Repository
public class DeparmentDAOImpl implements DeparmentDAO {

	private static final Logger logger = LoggerFactory.getLogger(DeparmentDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public Deparment findDeparmentById(int id) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(String name, String description, String city) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String name, String description, String city) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub

	}

}
