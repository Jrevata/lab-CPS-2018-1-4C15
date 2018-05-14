package com.tecsup.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.gestion.model.Deparment;


public class DeparmentMapper implements RowMapper<Deparment> {

	public Deparment mapRow(ResultSet rs, int row) throws SQLException{
		Deparment depa = new Deparment();
		
		depa.setDeparement_id(rs.getInt("department_id"));
		depa.setName(rs.getString("name"));
		depa.setDescription(rs.getString("description"));
		depa.setCity(rs.getString("city"));
		
		return depa;
		
	}
	
}
