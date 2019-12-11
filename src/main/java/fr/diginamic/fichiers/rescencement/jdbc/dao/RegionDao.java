package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.SQLException;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Region;


public interface RegionDao {
	public void insert( Region region) throws  SQLException;
}
