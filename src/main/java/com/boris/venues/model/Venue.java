package com.boris.venues.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Venue {

	@Id
	private String id;
	private String name;
	private String mainPicUrl;
	private Location location;
	private List<Table> tables;

	public String getId() {
		return id;
	}

	public String getMainPicUrl() {
		return mainPicUrl;
	}

	public String getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}

	public List<Table> getTables() {
		return tables;
	}

	private void setId(String id) {
		this.id = id;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setLocation(Location location) {
		this.location = location;
	}

	private void setTables(List<Table> tables) {
		this.tables = tables;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tables == null) ? 0 : tables.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venue other = (Venue) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tables == null) {
			if (other.tables != null)
				return false;
		} else if (!tables.equals(other.tables))
			return false;
		return true;
	}


	public static class VenueBuilder {
		private Venue venue;

		public VenueBuilder() {
			this.venue = new Venue();
		}

		public VenueBuilder withId(String id) {
			this.venue.setId(id);
			return this;
		}

		public VenueBuilder withName(String name) {
			this.venue.setName(name);
			return this;
		}

		public VenueBuilder withLocation(Location location) {
			this.venue.setLocation(location);
			return this;
		}

		public VenueBuilder withTables(List<Table> tables) {
			this.venue.setTables(tables);
			return this;
		}

		public Venue build() {
			return this.venue;
		}

	}
}
