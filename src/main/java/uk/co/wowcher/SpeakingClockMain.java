package uk.co.wowcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpeakingClockMain {

	private static final String[] TENS = { "oh ", "", "twenty ", "thirty ", "forty ", "fifty " };

	private static final String[] ONES = { "twelve ", "one ", "two ", "three ", "four ", "five ", "six ", "seven ",
			"eight ", "nine ", "ten ", "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ",
			"seventeen ", "eighteen ", "nineteen " };

	public String getDetails(String hour) {

		try {
			hour.trim().split(":");
		} catch (NumberFormatException e) {
			throw new NumberFormatException("You need to pass a valid 24 hour format hour");
		}

		String[] hours = hour.trim().split(":");
		if (hours.length != 2) {
			throw new NumberFormatException("You need to pass a valid 24 hour format hour");
		}

		try {
			Integer.parseInt(hours[0]);
			Integer.parseInt(hours[1]);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("You need to pass a valid 24 hour format hour");
		}

		int hours1 = Integer.parseInt(hours[0]);
		int minutes1 = Integer.parseInt(hours[1]);

		String hourInWords = convertToWords(hours1, minutes1);

		if (hourInWords.equals("")) {
			return "It was not possible to convert the hour passed to words";
		} else {
			return hourInWords;
		}
	}

	private String convertToWords(int hour, int minutes) {

		StringBuilder result = new StringBuilder();

		if (minutes == 0) {

			if (hour == 12) {
				return result.append("It's Midday").toString();
			}

			if (hour == 24) {
				return result.append("It's Midnight").toString();
			}

			result.append("It's ").append(ONES[hour % 12]);

		} else if (minutes % 10 == 0) {
			result.append("It's ").append(ONES[hour % 12]).append(TENS[minutes / 10]);
		} else if (minutes < 10 || minutes > 20) {
			result.append("It's ").append(ONES[hour % 12]).append(TENS[minutes / 10]).append(ONES[minutes % 10]);
		} else {
			result.append("It's ").append(ONES[hour % 12]).append(ONES[minutes]);
		}

		return result.toString();
	}

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the 24 hour format you want to be converted into words: ");
		String hour = reader.readLine();

		SpeakingClockMain speakingClockMain = new SpeakingClockMain();
		String result = speakingClockMain.getDetails(hour);
		System.out.println(result);
	}
}
