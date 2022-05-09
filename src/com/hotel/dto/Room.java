package com.hotel.dto;
import java.math.BigDecimal;
import java.util.Arrays;

public class Room {
	
	Integer number;
	RoomType type;
	BigDecimal basePrice;
	Character[] availability = new Character[367];
	
	public Room() {
		Arrays.fill(availability, '0');
	}
	
	public Room(Integer number, RoomType type, BigDecimal basePrice) {
		this.number = number;
		this.type = type;
		this.basePrice = basePrice;
		Arrays.fill(availability, '0');
	}


	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public Character[] getAvailability() {
		return availability;
	}

	public void setAvailability(Character[] availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Room => " + number + ", " + type + ", Price=" + basePrice;
	}
	
	
	
}
