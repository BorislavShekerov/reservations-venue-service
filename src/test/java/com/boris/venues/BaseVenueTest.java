package com.boris.venues;

import java.util.Arrays;
import java.util.List;

import com.boris.venues.model.Location;
import com.boris.venues.model.Table;
import com.boris.venues.model.Venue;
import com.boris.venues.model.Venue.VenueBuilder;

public class BaseVenueTest {
	protected static final String DUMMY_VENUE_NAME_2 = "dummyNAme2";
	protected static final String DUMMY_VENUE_NAME_1 = "dummyNAme1";
	
	protected static final String DUMMY_VENUE_ID_2 = "2";
	protected static final String DUMMY_VENUE_ID_1 = "1";

	protected static final Table DUMMY_TABLE_1 = new Table(4, 1);
	protected static final Table DUMMY_TABLE_2 = new Table(4, 1);

	protected static final Location DUMMY_LOCATION_1 = new Location(10, 20);
	protected static final Location DUMMY_LOCATION_2 = new Location(20, 30);

	protected static final Venue DUMMY_VENUE_1 = new VenueBuilder().withId(DUMMY_VENUE_ID_1).withLocation(DUMMY_LOCATION_1)
			.withName(DUMMY_VENUE_NAME_1).withTables(Arrays.asList(DUMMY_TABLE_1)).build();
	protected static final Venue DUMMY_VENUE_2 = new VenueBuilder().withId(DUMMY_VENUE_ID_2).withLocation(DUMMY_LOCATION_2)
			.withName(DUMMY_VENUE_NAME_2).withTables(Arrays.asList(DUMMY_TABLE_2)).build();
		
	protected static final List<Venue> DUMMY_VENUES = Arrays.asList(DUMMY_VENUE_1, DUMMY_VENUE_2);
}
