package com.hotel.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HotelManagement {

	private String name;
	private Integer capacity;
	private String location;
	private List<Room> rooms = new ArrayList<>();

	public HotelManagement() {
	}

	public void updatePriceForRooms(int lowerBound, int upperBound, BigDecimal newPrice) {
		boolean isPriceUpdated = false;
		for (Room room : this.rooms) {
			if (room.getNumber() >= lowerBound && room.getNumber() <= upperBound) {
				room.setBasePrice(newPrice);
				isPriceUpdated = true;
				System.out.println("New price for Room :" + room.getNumber() + " is :" + room.getBasePrice());
			}
		}
		if (!isPriceUpdated) {
			System.out.println("None of the room's price has been updated.");
		}
	}

	public void checkAvailabilityAndBook(RoomType type, int startDay, int endDay) {

		boolean isCurrentRoombooked = false;
		boolean findAvailableRoom = false;
		for (Room room : this.rooms) {
			
			if (room.getType().equals(type)) {
				
				Character[] availability = room.getAvailability();
				for (int i = startDay; i <= endDay; ++i) {
					if (availability[i] == '1') {
						isCurrentRoombooked = true;
//						System.out.println("Room "+room.getNumber()+" is not available");
						break;
					}
				}

				if (isCurrentRoombooked) {
					isCurrentRoombooked = false;
					continue;
				} else {
					bookRoom(room, startDay, endDay);
					System.out.println("Success !! Room " + room.getNumber() + " is booked for you for $"+room.getBasePrice()+" for one day.");
					findAvailableRoom = true;
					break;
				}
			}
		}
		if (!findAvailableRoom) {
			System.out.println("No room of type " + type.toString() + " is available for given dates.");
		}

	}

	public void bookRoom(Room room, int startDay, int endDay) {

		Character[] roomAvailability = room.getAvailability();
		for (int index = startDay; index <= endDay; ++index) {
			roomAvailability[index] = '1';
		}
	}

	/* Getters and Setters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
}
