package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.SQLException;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

public interface VilleDao {
	public void insert( Ville ville) throws  SQLException;
}
