package tomas.PU3;

import java.util.Scanner;

public class Parkhaus {
	
	static String entry;
	static String exit;
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner (System.in);
		
		boolean validInput = false;
		boolean input = false;
		
		int i = 0;
		//Variable to store parking time
		int parkingTime = 0;
		double feeToBePayed = 0;
		
		// Allow up to two attempts
        while (i < 2 && !input) {
            System.out.println("Time of Entry (hh:mm): ");
            entry = sc.nextLine();
            
            System.out.println("Time of Exit (hh:mm): ");
            exit = sc.nextLine();
            
            input = isInputCorrect(entry, exit);
            
            // If input is correct, break out of the loop
            if (input) {
                validInput = true;
                parkingTime = parkingTime(entry, exit);
                feeToBePayed = parkingFee(parkingTime);
            } else {
                i++;
                System.out.println("You have " + (2 - i) + " attempt(s) left. \n");
            }
        }
        
        // If all attempts are used and input is still incorrect, display a message
        if (!validInput) {
            System.out.println("Maximum attempts reached.\nExiting program.");
        }
        
        sc.close();
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

	
	public static boolean isInputCorrect(String entry, String exit) {
		
		
	    // Check if entry and exit strings have the expected length and format
	    if (!entry.matches("\\d{2}:\\d{2}") || !exit.matches("\\d{2}:\\d{2}")) {
	        System.out.println("Invalid input format. Please provide input in the format hh:mm.");
	        return false;
	    }
	    
	    // Parse entry and exit times
	    String[] entryParts = entry.split(":");
	    String[] exitParts = exit.split(":");
	    
	    int entryHour = Integer.parseInt(entryParts[0]);
	    int entryMinute = Integer.parseInt(entryParts[1]);
	    int exitHour = Integer.parseInt(exitParts[0]);
	    int exitMinute = Integer.parseInt(exitParts[1]);
	    
	    // Check if entry time is within operating hours (06:00 to 22:00)
	    if (entryHour >= 6 && exitHour <= 22) {
	        // Entry time is within operating hours, no need for further checks
	        return true;
	    } else {
	        // Entry time is outside operating hours
	        System.out.println("Car Park is closed.");
	        return false;
	    }
	}

	
	
	/**
	 * Calculates the duration in minutes for which parking charges apply,
	 * taking into account the free parking times.
	 * The parking fee starts after a free period from 06:00 to 10:00
	 * as well as an additional first free hour after the start of the parking fee obligation at 10:00 am. 
	 * If the parking time is zero minutes or the entire parking time is within the free parking period, there are no charges and therefore the parking time = 0.
	 * @param entry The entry time in the format hh:mm
	 * @param exit The exit time in the format hh:mm
	 * @return The duration in minutes for which parking charges apply, after deduction of all
	 * free parking times
	 */

	// TODO: Take in note that the time to be payed is always -1 hour (the first hour is for free)
	public static int parkingTime(String entry, String exit) {
		
		// Parse entry and exit times
	    String[] entryParts = entry.split(":");
	    String[] exitParts = exit.split(":");
	    
	    int entryHour = Integer.parseInt(entryParts[0]);
	    int entryMinute = Integer.parseInt(entryParts[1]);
	    int exitHour = Integer.parseInt(exitParts[0]);
	    int exitMinute = Integer.parseInt(exitParts[1]);
		
		boolean result = isInputCorrect(entry, exit);
		
		int totalEntryMinutes = entryHour * 60 + entryMinute;
		int totalExitMinutes = exitHour * 60 + exitMinute;
		
		int parkingDuration = totalExitMinutes - totalEntryMinutes;
		
		if(result) {
			
			// Subtract the first free hour
			if(parkingDuration > 60) {
				parkingDuration -= 60;
			} else {
				// Parking is free if less than an hour
				parkingDuration = 0;
			}
			
			System.out.println("\nYour parking time is (subtracting free hour): " + parkingDuration + " minutes.");
			
			return parkingDuration;
		}
		
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

	
	// TODO: Turn parse entry and exit times into a method to be reused.
	
	public static double parkingFee(int parkingTime) {
		
		 int totalParkingFee = 0;
		    
		    // if parking duration is greater than 90 minutes
		    if (parkingTime > 90) {
		        // Flat rate for the first 90 minutes
		        totalParkingFee = 300; // 3 euro in cents
		        
		        // Calculate additional fee for each hour after the first 90 minutes
		        int additionalHours = (int) Math.ceil((parkingTime - 90) / 60.0);
		        
		        // Convert euro to cents
		        double additionalFee = additionalHours * 1.5 * 100; 
		        
		        // Cap the additional fee at 10.00 euro
		        	// 10.00 euro in cents
		        if (additionalFee > 1000.0) { 
		        	// 10.00 euro in cents
		            additionalFee = 1000.0; 
		        }
		        
		        totalParkingFee += (int) additionalFee;
		        
		    } else {
		        // Flat rate for the first 90 minutes
		    	// 3 euro in cents
		    	totalParkingFee = 300; 
		    }
		    
		    // Convert totalParkingFee to euro and cents
		    int euros = totalParkingFee / 100;
		    int cents = totalParkingFee % 100;
		    
		    // Print the parking fee
		    System.out.println("\nYour parking fee is: " + euros + " euros and " + cents + " cents");
		    
		    return totalParkingFee;	
	}
//
//	
//	
//	/**
//	 * Überprüft die Gültigkeit der vom Benutzer eingegebenen Zahlung.
//	 * Eine gültige Zahlung muss im Format €€,cc erfolgen,
//	 * darf keine negativen Werte enthalten und die Cent-Angabe muss
//	 * durch 10 teilbar sein.
//	 *
//	 * @param zahlung Die eingegebene Zahlung als String im Format €€,cc
//	 * @return Den Wert der Zahlung in Cent, wenn diese gültig ist; andernfalls -1.
//	 */
//	
//	public static int paymentValid(String payment) {
//		
//	}
//
//	
//	
//	/**
//	 * Calculates the division of the change into different coin denominations
//	 * based on the total amount transferred in cent.
//	 * The method divides the change into the largest possible coin values,
//	 * starting with 2 euros, followed by 1 euro,
//	 * 50 cents, 20 cents and 10 cents. It then returns the change in
//	 * descending order.
//	 *
//	 * @param rueckgeld The change amount in cent to be split.
//	 * @return An array of integers containing the number of coins for each denomination.
//	 * denomination. The order in the array corresponds to: [2 euro coins,
//	 * 1 euro coins, 50 cent coins, 20 cent coins, 10 cent coins].
//	 */
//	
//	public static int[] change(int change) {
//		
//		return [0];
//	}

}
