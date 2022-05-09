package com.hotel.utility;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.hotel.dto.RoomType;

public class Utility {

	public static final List<RoomType> VALID_ROOM_TYPE = Arrays.asList(RoomType.REGULAR, RoomType.DELUXE,
			RoomType.LUXURY, RoomType.SUITE);

	public static final String DATE_yyyy_mm_dd = "uuuu-MM-dd";

	public static RoomType validateAndParseRoomType(String roomType) {

		for (RoomType type : VALID_ROOM_TYPE) {
			if (type.toString().equalsIgnoreCase(roomType)) {
				return type;
			}
		}
		System.err.println("Please select a valid room type. [REGULAR/DELUXE/LUXURY/SUITE]");
		return null;
	}

	public static LocalDate validateAndParseDate(String date) {

		LocalDate parsedDate = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_yyyy_mm_dd)
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			parsedDate = LocalDate.parse(date, formatter);
		} catch (DateTimeParseException exception) {
			System.err.println("Given date '" + date + "' is invalid.");
		}
		return parsedDate;
	}

	public static Integer[] validateAndParseRange(String rangeStr) {
		Integer[] range = null;
		String[] rangeBounds = rangeStr.split("-");
		if (rangeBounds.length != 2) {
			System.out.println("Given range is invalid.");
		} else {
			Integer lowerBound = validateAndParseToInteger(rangeBounds[0]);
			Integer upperBound = validateAndParseToInteger(rangeBounds[1]);
			if (Objects.nonNull(upperBound) && Objects.nonNull(lowerBound)) {
				range = new Integer[2];
				range[0] = lowerBound;
				range[1] = upperBound;
			}
		}

		return range;
	}

	public static Integer validateAndParseToInteger(String input) {
		Integer number = null;
		try {
			number = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid numeric input.");
		}
		return number;
	}

	public static BigDecimal validateAndParseToBigDecimal(String input) {
		BigDecimal price = null;
		try {
			price = new BigDecimal(input);
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid numeric input.");
		}

		return price;

	}

}
