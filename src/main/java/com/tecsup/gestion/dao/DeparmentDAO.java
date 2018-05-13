package com.tecsup.gestion.dao;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Deparment;

public interface DeparmentDAO {

	Deparment findDeparmentById(int id) throws DAOException, EmptyResultException;
	
	void create(String name, String description, String city) throws DAOException;
	
	void update(String name, String description, String city) throws DAOException;
	
	void delete(int id) throws DAOException;
}
