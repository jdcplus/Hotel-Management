package com.hotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.hotel.dto.HotelManagement;
import com.hotel.dto.Room;
import com.hotel.dto.RoomType;
import com.hotel.utility.Utility;

public class Main {

	public static void main(String[] args) throws IOException {

		HotelManagement hotel = new HotelManagement();
		hotel.setName("Hotel Rivendell");
		hotel.setLocation("256, King St, Tornto");
		hotel.setCapacity(600);

		boolean continueExecution = true;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Main.populateRoomsWithDummyData(hotel);
		
		do {

			displayMenu(hotel.getName());

			String choiceStr = reader.readLine();
			Integer choice = Utility.validateAndParseToInteger(choiceStr);

			if (Objects.nonNull(choice)) {
				if (choice == 1) {
					
					System.out.println("Enter room type [REGULAR/DELUXE/LUXURY/SUITE].");
					String roomType = reader.readLine();
					
					System.out.println("Enter check-in date [yyyy-mm-dd]");
					String fromDate = reader.readLine();
					int currentYear = LocalDate.now().getYear();
					System.out.println("Enter check-out date [yyyy-mm-dd]");
					String toDate = reader.readLine();

					RoomType requiredRoomType = Utility.validateAndParseRoomType(roomType);
					LocalDate bookFrom = Utility.validateAndParseDate(fromDate);
					LocalDate bookTo = Utility.validateAndParseDate(toDate);

					if (Objects.nonNull(requiredRoomType) && Objects.nonNull(bookFrom) && Objects.nonNull(bookTo)) {

						if (bookFrom.compareTo(bookTo) > 0) {
							System.out.println(bookFrom + " date should be less than " + bookTo);

						} else if (bookFrom.compareTo(LocalDate.now()) < 0) {
							System.out.println("Booking start date must be either today's date or later");

						} else if(bookFrom.getYear() != currentYear ||
								bookTo.getYear() != currentYear) {
							System.out.println("Bookings are allowed for current year only.");
						} else {
							hotel.checkAvailabilityAndBook(requiredRoomType, bookFrom.getDayOfYear(),
									bookTo.getDayOfYear());
						}
					}
				} else if (choice == 2) {

					System.out.println("Following rooms are present in the hotel.");
					System.out.println(Main.fetchRoomNumberList(hotel.getRooms()));

					System.out.println("Enter a range of room numbers seperated by '-' e.g. 102-105");
					String rangeOfRooms = reader.readLine();

					System.out.println("Enter a new price entered range of rooms e.g. 129.99");
					String price = reader.readLine();

					Integer[] roomRange = Utility.validateAndParseRange(rangeOfRooms);
					BigDecimal newPrice = Utility.validateAndParseToBigDecimal(price);

					if (Objects.nonNull(roomRange) && Objects.nonNull(newPrice)) {
						hotel.updatePriceForRooms(roomRange[0], roomRange[1], newPrice);
					}
				} else if (choice == 3) {
					Main.displayRoomInformation(hotel.getRooms());

				} else if (choice == 4) {
					continueExecution = false;

				} else {
					System.out.println("Please enter a valid choice [1-4].");

				}
			}
		} while (continueExecution);
	}

	public static void displayMenu(String name) {
		System.out.println("---------------------------------------");
		System.out.println("Welcome to " + name);
		System.out.println("---------------------------------------");
		System.out.println("1. Query Room Availability based on Date.");
		System.out.println("2. Change the price for a range of rooms.");
		System.out.println("3. Show all room details.");
		System.out.println("4. Exit");
		System.out.println("---------------------------------------");
		System.out.println("Enter your choice [1-4]: ");
	}

	public static void displayRoomInformation(List<Room> rooms) {
		for (Room room : rooms) {
			System.out.println(room.toString());
		}
	}

	public static String fetchRoomNumberList(List<Room> rooms) {
		StringBuilder sb = new StringBuilder();

		for (Room eachRoom : rooms) {
			sb.append(eachRoom.getNumber()).append(';');
		}
		if (sb.length() > 0)
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static void populateRoomsWithDummyData(HotelManagement hotel) {

		// All Regular rooms
		Room r1 = new Room(101, RoomType.REGULAR, BigDecimal.valueOf(133));
		Room r2 = new Room(102, RoomType.REGULAR, BigDecimal.valueOf(100.49));
		Room r3 = new Room(103, RoomType.REGULAR, BigDecimal.valueOf(96.49));
		Room r4 = new Room(104, RoomType.REGULAR, BigDecimal.valueOf(150.89));
		Room r5 = new Room(105, RoomType.REGULAR, BigDecimal.valueOf(100.49));

		// All deluxe rooms
		Room d1 = new Room(201, RoomType.DELUXE, BigDecimal.valueOf(155.49));
		Room d2 = new Room(202, RoomType.DELUXE, BigDecimal.valueOf(165.49));
		Room d3 = new Room(203, RoomType.DELUXE, BigDecimal.valueOf(175.49));

		// All luxury rooms
		Room l1 = new Room(301, RoomType.LUXURY, BigDecimal.valueOf(225.49));
		Room l2 = new Room(302, RoomType.LUXURY, BigDecimal.valueOf(235.89));

		// Suite
		Room p1 = new Room(401, RoomType.SUITE, BigDecimal.valueOf(440.49));

		hotel.setRooms(Arrays.asList(r1, r2, r3, r4, r5, d1, d2, d3, l1, l2, p1));
	}
}
