package com.boris.venues.controller.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.boris.venues.model.Venue;
import com.boris.venues.model.Venue.VenueBuilder;

import com.boris.venues.BaseVenueTest;
import com.boris.venues.TestConfig;
import com.boris.venues.dao.VenueDao;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@WebAppConfiguration
public class VenueControllerIntegrationTest extends BaseVenueTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	VenueDao venueDao;

	@Before
	public void setup() {
		venueDao.deleteAll();

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void getAllVenues() throws Exception {
		venueDao.save(DUMMY_VENUE_1);

		this.mockMvc.perform(get("/venues/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.[0].id").value(DUMMY_VENUE_1.getId()))
				.andExpect(jsonPath("$.[0].name").value(DUMMY_VENUE_1.getName()));
	}
	
	@Test
	public void getAllTablesForVenue() throws Exception {
		venueDao.save(DUMMY_VENUE_1);

		this.mockMvc.perform(get("/venues/" + DUMMY_VENUE_ID_1 + "/tables").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.[0].number").value(DUMMY_TABLE_1.getNumber()))
				.andExpect(jsonPath("$.[0].capacity").value(DUMMY_TABLE_1.getCapacity()));
	}

	@Test
	public void getVenueForId_venueExists() throws Exception {
		venueDao.save(DUMMY_VENUE_1);

		this.mockMvc.perform(get("/venues/" + DUMMY_VENUE_ID_1).accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(DUMMY_VENUE_1.getId()))
				.andExpect(jsonPath("$.name").value(DUMMY_VENUE_1.getName()));
	}

	@Test
	public void getVenueForId_venueNotPresent() throws Exception {
		this.mockMvc.perform(get("/venues/" + DUMMY_VENUE_ID_1).accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(""));
	}

	@Test
	public void addVenue() throws Exception {
		Venue venueToAdd = new VenueBuilder().withLocation(DUMMY_LOCATION_1).withName(DUMMY_VENUE_NAME_1).withTables(Lists.newArrayList(DUMMY_TABLE_1)).build();
		
		this.mockMvc
		.perform(post("/venues/").contentType(MediaType.APPLICATION_JSON).content(asJsonString(venueToAdd))
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
		.andExpect(status().isOk()).andExpect(jsonPath("$.id").isNotEmpty());
	}

	private static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
