package com.boris.venues.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boris.venues.model.Venue;

public interface VenueDao extends CrudRepository<Venue, String>{
	
	List<Venue> findByNameLike(String name);

}
