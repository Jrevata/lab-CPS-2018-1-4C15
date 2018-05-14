package com.tecsup.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.gestion.dao.DeparmentDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Deparment;

public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DeparmentDAO deparmentDAO;
	
	@Override
	public Deparment find(int department_id) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		
		Deparment depa = deparmentDAO.findDeparmentById(department_id);
		
		return depa;
	}

}
