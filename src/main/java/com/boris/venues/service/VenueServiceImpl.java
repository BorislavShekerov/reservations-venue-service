package com.boris.venues.service;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boris.venues.dao.VenueDao;
import com.boris.venues.model.Table;
import com.boris.venues.model.Venue;

@Service
public class VenueServiceImpl implements VenueService {
	
	@Autowired
	VenueDao venueDao;
	
	@Override
	public List<Venue> getAllVenues() {
		return Lists.newArrayList(venueDao.findAll());
	}

	@Override
	public Venue getVenueForId(String venueId) {
		return venueDao.findOne(venueId);
	}

	@Override
	public Venue addVenue(Venue venueToAdd) {
		return venueDao.save(venueToAdd);
	}

	@Override
	public List<Table> getTablesForVenue(String venueId) {
		return venueDao.findOne(venueId).getTables();
	}

	@Override
	public List<Venue> searchVenues(String searchStr) {
		return venueDao.findByNameLike(searchStr);
	}

}
