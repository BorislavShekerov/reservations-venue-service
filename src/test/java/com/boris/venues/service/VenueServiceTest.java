package com.boris.venues.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boris.venues.BaseVenueTest;
import com.boris.venues.dao.VenueDao;
import com.boris.venues.model.Table;

public class VenueServiceTest extends BaseVenueTest{
	
	@InjectMocks
	VenueServiceImpl testObj;

	@Mock
	VenueDao venueDao;
	
	@Before
	public void setUp() {
		testObj = new VenueServiceImpl();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllTablesForVenue(){
		when(venueDao.findOne(DUMMY_VENUE_ID_1)).thenReturn(DUMMY_VENUE_1);
		
		List<Table> tables = testObj.getTablesForVenue(DUMMY_VENUE_ID_1);
		
		verify(venueDao).findOne(DUMMY_VENUE_ID_1);
		assertEquals("There should be 1 table for venue", 1, tables.size());
		assertEquals("The table should be DUMMY_TABLE_1", DUMMY_TABLE_1, tables.get(0));
	}

	
}
