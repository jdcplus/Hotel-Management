package com.hotel.dto;

public enum RoomType {
	
	REGULAR(101), DELUXE(102), LUXURY(103), SUITE(104);
	
	private int roomType;
	
	private RoomType(int type) {
		this.roomType = type;
	}
	
	public int getRoomType() {
		return roomType;
	}
}
