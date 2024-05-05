package tomas.PU3;

import java.util.Scanner;

public class Parkhaus {
	
	static String entry;
	static String exit;
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner (System.in);
		boolean input;
		
		/*Input of parking times*/
		
		do {
			
			System.out.println("Time of Entry (hh:mm): ");
			entry = sc.nextLine();
			
			System.out.println("Time of Exit (hh:mm): ");
			exit = sc.nextLine();
			
			input = isInputCorrect(entry, exit);
		} while (input == false);
	}
	


	/**
	 * Checks the validity of the input times in the format hh:mm.
	 * The method checks,
	 * whether the times are within the operating hours of the car park
	 * operating hours of the car park (06:00 to 22:00),
	 * whether the entry time is not after the exit time and whether the format
	 * hh:mm (i.e. only numbers and :) are correctly adhered to.
	 *
	 * @param entry The entry time as a string in the format hh:mm
	 * @param exit The exit time as a string in the format hh:mm
	 */

	
	// TODO: Test method and fix return as in the method returning true or false
	public static boolean isInputCorrect(String entry, String exit) {
		
		boolean timeChecker = false;
		boolean format = false;
		boolean operatingHours = false;
		
		
		// Extracts the characters of the entry time to check if the format is correct
		char entryIndex0 = entry.charAt(0);
		char entryIndex1 = entry.charAt(1);
		char entryIndex2 = entry.charAt(2);
		char entryIndex3 = entry.charAt(3);
		char entryIndex4 = entry.charAt(4);
		
		// Extracts the characters of the exit time to check if the format is correct
		char exitIndex0 = exit.charAt(0);
		char exitIndex1 = exit.charAt(1);
		char exitIndex2 = exit.charAt(2);
		char exitIndex3 = exit.charAt(3);
		char exitIndex4 = exit.charAt(4);
		
		// Extract hour part of entry and exit
		String entryHourString = entry.substring(0, 2);
		String exitHourString = exit.substring(0, 2);
		
		// Parse hour part into an integer
		int entryHour = Integer.parseInt(entryHourString);
		int exitHour = Integer.parseInt(exitHourString);
		
		
		// Check whether entry time is formatted correctly
		boolean entryFormat = Character.isDigit(entryIndex0) && Character.isDigit(entryIndex1) && entryIndex2 == ':' && Character.isDigit(entryIndex3) && Character.isDigit(entryIndex4);

		// Check whether exit time is formatted correctly
		boolean exitFormat = Character.isDigit(exitIndex0) && Character.isDigit(exitIndex1) && exitIndex2 == ':' && Character.isDigit(exitIndex3) && Character.isDigit(exitIndex4);
		
		
		// Check both entry and exit formats
		if (entryFormat && exitFormat) {
			format = true;
			
		} else {
			System.out.println("Syntax error");
			
		}
		
		// Checks if the entry is within the operating hours, assuming entry is a String representing time in the format "hh:mm"
		if(entryHour >= 6 && entryHour < 22) {
			operatingHours = true;
			
		} else {
			System.out.println("Car Park is closed");
			
		}
		
		return true;
	}
	
	
	
	/**
	 * Calculates the duration in minutes for which parking charges apply,
	 * taking into account the free parking times.
	 * The parking fee starts after a free period from 06:00 to 10:00
	 * as well as an additional
	 * first free hour after the start of the parking fee obligation at 10:00 am. If the
	 * parking time is zero minutes
	 * or the entire parking time is within the free parking period,
	 * there are no charges and therefore the parking time = 0.
	 *
	 * @param entry The entry time in the format hh:mm
	 * @param exit The exit time in the format hh:mm
	 * @return The duration in minutes for which parking charges apply, after deduction of all
	 * free parking times
	 */

	// TODO: Take in note that the time to be payed is always -1 hour (the first hour is for free)
	public static int parkingTimeToBePayed(String entry, String exit) {
		
		
		return 0;
	}
	
	
	
	/**
	 * Calculates the parking fee based on the total chargeable parking time in minutes.
	 * Parking duration in minutes.
	 * The first 90 minutes after the free time cost a flat rate of 3.00 euros.
	 * Thereafter, every hour or part thereof
	 * 1.50 euros until a maximum of 10.00 euros is reached.
	 *
	 * @param parking duration The total chargeable parking duration in minutes.
	 * @return The parking fee in cent. For a parking duration of 0 minutes or less
	 * no fee is charged.
	 */

	
	public static int calculateParkingFee(int parkinDuration) {
			
	}

	
	
	/**
	 * Überprüft die Gültigkeit der vom Benutzer eingegebenen Zahlung.
	 * Eine gültige Zahlung muss im Format €€,cc erfolgen,
	 * darf keine negativen Werte enthalten und die Cent-Angabe muss
	 * durch 10 teilbar sein.
	 *
	 * @param zahlung Die eingegebene Zahlung als String im Format €€,cc
	 * @return Den Wert der Zahlung in Cent, wenn diese gültig ist; andernfalls -1.
	 */
	
	public static int paymentValid(String payment) {
		
	}

	
	
	/**
	 * Calculates the division of the change into different coin denominations
	 * based on the total amount transferred in cent.
	 * The method divides the change into the largest possible coin values,
	 * starting with 2 euros, followed by 1 euro,
	 * 50 cents, 20 cents and 10 cents. It then returns the change in
	 * descending order.
	 *
	 * @param rueckgeld The change amount in cent to be split.
	 * @return An array of integers containing the number of coins for each denomination.
	 * denomination. The order in the array corresponds to: [2 euro coins,
	 * 1 euro coins, 50 cent coins, 20 cent coins, 10 cent coins].
	 */
	
	public static int[] change(int change) {
		
		return [0];
	}

}
