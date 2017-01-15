package com.boris.venues.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.boris.venues.BaseVenueTest;
import com.boris.venues.model.Table;
import com.boris.venues.model.Venue;
import com.boris.venues.service.VenueService;
import com.google.common.collect.Lists;

public class VenueControllerTest extends BaseVenueTest {

	@InjectMocks
	VenueController testObj;

	@Mock
	VenueService venueService;

	@Before
	public void setUp() {
		testObj = new VenueController();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllVenuesTest() {
		when(venueService.getAllVenues()).thenReturn(DUMMY_VENUES);

		List<Venue> result = testObj.getAllVenues();

		verify(venueService, Mockito.only()).getAllVenues();

		assertEquals("There should be 2 venues returned", 2, result.size());
		assertEquals("DUMMY_VENUE_1 should be the first venue returned", DUMMY_VENUE_1, result.get(0));
		assertEquals("DUMMY_VENUE_2 should be the second venue returned", DUMMY_VENUE_2, result.get(1));
	}

	@Test
	public void getVenueForId() {
		when(venueService.getVenueForId(DUMMY_VENUE_ID_1)).thenReturn(DUMMY_VENUE_1);

		Venue result = testObj.getVenue(DUMMY_VENUE_ID_1);

		verify(venueService, Mockito.only()).getVenueForId(DUMMY_VENUE_ID_1);

		assertEquals("The venue returned should be DUMMY_VENUE_1", DUMMY_VENUE_1, result);
	}
	
	@Test
	public void getTablesForVenue(){
		when(venueService.getTablesForVenue(DUMMY_VENUE_ID_1)).thenReturn(Lists.newArrayList(DUMMY_TABLE_1));

		List<Table> result = testObj.getTablesForVenue(DUMMY_VENUE_ID_1);

		verify(venueService, Mockito.only()).getTablesForVenue(DUMMY_VENUE_ID_1);

		assertEquals("The table returned should be 1", 1, result.size());
		assertEquals("The table returned should be 1", DUMMY_TABLE_1, result.get(0));
	}
	
	@Test
	public void addVenue(){
		testObj.addVenue(DUMMY_VENUE_1);

		verify(venueService, Mockito.only()).addVenue(DUMMY_VENUE_1);
	}
}
