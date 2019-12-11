package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.SQLException;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Departement;


public interface DepartementDao {
	public void insert( Departement departement) throws  SQLException;

}
