package com.boris.venues.model;

public class Table {
	private int capacity;
	private int number;
	
	public Table() {
	}
	
	public Table(int capacity, int number) {
		this.capacity = capacity;
		this.number = number;
	}

	public int getCapacity() {
		return capacity;
	}
	public int getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + number;
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
		Table other = (Table) obj;
		if (capacity != other.capacity)
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	
}
