package tomas.PU3;

import java.util.Scanner;

public class ParkhausII {
	
	public static final int MAXIMUM_FEE = 1000;
	public static final int INITIAL_FEE = 300;
	public static final int FOLLOWUP_FEE = 150;
	
	static String entry;
	static String exit;
	static int parkdauer;
	static String zahlung;
	static int rueckgeld;
	
	public static void main (String args[]) {
		
		Scanner sc = new Scanner (System.in);
		
		// Storage for methods
		boolean isInputCorrect;
		int calculatePaidParkingPeriod;
		int calculateParkingFee;
		int paymentValid;
		int change;
		
		boolean terminate = false;
		
		int i = 0;
		
		while(!terminate && i < 2) {
			
			System.out.println("Parkzeitberechnung\n");
			
			System.out.print("Einfahrt (hh:mm): ");
			entry = sc.nextLine();
			
			System.out.print("Ausfahrt (hh:mm): ");
			exit = sc.nextLine();
		
		// Check if input is correct 
		isInputCorrect = isInputCorrect(entry, exit);
		
		
		// If the input is correct then allow the rest of the program to run
		if (isInputCorrect) {
			
			calculatePaidParkingPeriod = calculatePaidParkingPeriod (entry, exit);

			calculateParkingFee = calculateParkingFee (parkdauer);
			
			System.out.print("\nZahlung (€€,cc): ");
			zahlung = sc.nextLine();
			
			paymentValid = paymentValid (zahlung);
			change = change (rueckgeld); 
			
			terminate = true;
		
		// If the input is incorrect return an error and take an attempt away.
		// If all attempts are used, then terminate the program.
		} else {
			  i++;
              System.out.println("Sie haben noch " + (2 - i) + " Versuch(e).\n");
              terminate = false;
			
			}
		}
		sc.close();
	}
	
	public static boolean isInputCorrect (String entry, String exit) {
		
		if (!entry.matches("\\d{2}:\\d{2}") || !exit.matches("\\d{2}:\\d{2}")) {
			
			System.out.println("\nUngültiges Eingabeformat. Bitte geben Sie die Eingabe im Format hh:mm ein");
			return false;
			
		}
		
		// Parse entry and exit times
	    String[] entryParts = entry.split(":");
	    String[] exitParts = exit.split(":");
		
	    // Turn entry and exit times into integers
	    int entryHour = Integer.parseInt(entryParts[0]);
	    int entryMinute = Integer.parseInt(entryParts[1]);
	 	int exitHour = Integer.parseInt(exitParts[0]);
	 	int exitMinute = Integer.parseInt(exitParts[1]);
	 	
	 	
	 	// Convert entry into minutes to then later calculate total stay by exitTimeInMintues - entryTimeInMinutes
	 	int entryHourConversion = entryHour * 60;
	 	int entryTimeInMinutes = entryHourConversion + entryMinute;
	 	
	 	// Convert exit into minutes
	 	int exitHourConversion = exitHour * 60;
	 	int exitTimeInMinutes = exitHourConversion + exitMinute;
		
		// Check if entry and exit strings have the expected length and format
		
	    // Checks that inputs are within operating hours - entry isn't greater than exit
	    if (entryHour >= 6 && exitHour <= 22 && entryMinute >= 0 && entryMinute < 60 && exitHour >= 6 && exitMinute >= 0 && exitMinute < 60 && exitHour > entryHour && exitTimeInMinutes <= 1320) {
	    	
	    	return true;
	    	
	    } else {
	    	
	    	System.out.println("Fehler, ungültige Eingaben");
	    	return false;
	    	
	    }
	}
	
	public static int calculatePaidParkingPeriod (String entry, String exit) {
		
		// Parse entry and exit times
	    String[] entryParts = entry.split(":");
	    String[] exitParts = exit.split(":");
		
	    
	    // Turn entry and exit times into integers
	    int entryHour = Integer.parseInt(entryParts[0]);
	    int entryMinute = Integer.parseInt(entryParts[1]);
	 	int exitHour = Integer.parseInt(exitParts[0]);
	 	int exitMinute = Integer.parseInt(exitParts[1]);
	 	
	 	
	 	// Convert entry into minutes to then later calculate total stay by exitTimeInMintues - entryTimeInMinutes
	 	int entryHourConversion = entryHour * 60;
	 	int entryTimeInMinutes = entryHourConversion + entryMinute;
	 	
	 	// Convert exit into minutes
	 	int exitHourConversion = exitHour * 60;
	 	int exitTimeInMinutes = exitHourConversion + exitMinute;
	 	
	 	int parkdauer = 0;
	 	
	 	if (entryTimeInMinutes >= 360  && exitTimeInMinutes <= 600) {
	 		
	 		// If parking time within free parking period (06:00 - 10:00), then the total parking period is 0.
	 		parkdauer = 0;
	 		
	 	} else if (entryTimeInMinutes <= 600 && exitTimeInMinutes > 600) {
	 		
	 		// The time parked between 06:00 and 10:00 is subtracted  from the total parking time. Then 1 hour is subtracted from the total to account for the free hour.
	 		parkdauer = (exitTimeInMinutes - entryTimeInMinutes) - (600 - entryTimeInMinutes) - 60;
	 	
	 	} else if (entryTimeInMinutes > 600 && exitTimeInMinutes > 600) {
	 		
	 		// If parking time is between the hours after 10:00, then the park time is the exit time - the entry time - 1 hour of free parking.
	 		parkdauer = (exitTimeInMinutes - entryTimeInMinutes) - 60;	 		
	 	
	 	} else if (exitTimeInMinutes - entryTimeInMinutes == 0) {
	 		
	 		// If parking time is 0, then total parking time is also 0
	 		parkdauer = 0;
	 		
	 	}
	 	
		// Return parking time in minutes (parkdauer)
		return parkdauer;
		
	}
	
	public static int calculateParkingFee (int parkdauer) {
		
		int calculatePaidParkingPeriod = calculatePaidParkingPeriod (entry, exit);
		int fee = 0;
		
		if(calculatePaidParkingPeriod == 0) {
			
			fee = 0;
			
		} else {
			
            // Initial fee for the first 90 minutes
			// Calculate fee for the remaining duration
            fee = INITIAL_FEE;
            
            // Remaining time after the first free hour
            int remainingMinutes = calculatePaidParkingPeriod - 60;

            if (remainingMinutes > 0) {
            	
                // Calculate additional fee for the remaining time
            	
            	// Calculate additional hours
                int additionalHours = (int) Math.ceil((double) remainingMinutes / 60);
                
                // Calculate additional fee
                int additionalFee = additionalHours * FOLLOWUP_FEE;
                
                // Cap the additional fee at the maximum fee
                additionalFee = Math.min(MAXIMUM_FEE - fee, additionalFee); 
                
                // Total fee is the sum of initial fee and additional fee
                fee += additionalFee;
          
                int euros = fee / 100;
                int cents = fee % 100;
                
                // Print the parking fee
                System.out.println("\nParkgebuehr: " + euros + " Euro und " + cents + " Cent\n");

            } else {
            	   
            	
            	
            	 // If no additional time, only the initial fee applies
                return fee;
                
            }
		
		}
		
		return fee;
		
	}
	
	public static int paymentValid (String zahlung) {
		
		String[] splittedZahlung = zahlung.split(",");

	    // Check if the input contains both euro and cents parts
	    if (splittedZahlung.length != 2) {
	    	
	        System.out.println("\nUngültiges Eingabeformat. Bitte geben Sie Ihre Eingaben im Format €€,cc ein");
	        return -1;
	        
	    }

	    // Check if both euro and cents parts are integers
	    if (!splittedZahlung[0].matches("\\d+") || !splittedZahlung[1].matches("\\d+")) {
	    	
	        System.out.println("\nUngültiges Eingabeformat. Bitte geben Sie Ihre Eingaben im Format €€,cc ein");
	        return -1;
	        
	    }

	    int parsedEuro = Integer.parseInt(splittedZahlung[0]);
	    int parsedCents = Integer.parseInt(splittedZahlung[1]);

	    // Check if cents part is divisible by 10
	    if (parsedCents % 10 != 0) {
	    	
	        System.out.println("\nDie Cent-Angabe sollte in 10er-Schritten erfolgen. Bitte geben Sie eine gültige Eingabe ein.");
	        return -1;
	        
	    }

	    // Calculate and print the payment in cents
	    int centConversion = (parsedEuro * 100) + parsedCents;
	    
	    return centConversion;
	    
	}
	
	public static int change (int rueckgeld) {
		
		int paymentValid = paymentValid (zahlung);
		int calculateParkingFee = calculateParkingFee (parkdauer);
		
		if (paymentValid >= calculateParkingFee) {
		    // Calculates change in cents
		    int change = paymentValid - calculateParkingFee;

		    // Define denominations and their values in cents
		    int[] centPayment = {200, 100, 50, 20, 10};
		    String[] returnPayment = {"2 Euro", "1 Euro", "50 Cent", "20 Cent", "10 Cent"};

		    // Initialize array to hold the output
		    String[] output = new String[centPayment.length];

		    // Iterate through denominations and calculate change for each
		    for (int i = 0; i < centPayment.length; i++) {
		    	
		    	// Calculate the number of coins/bills for the denomination
		    	int amount = change / centPayment[i]; 
		    	
		    	// Store denomination and amount in output array
		        output[i] = returnPayment[i] + ": " + amount; 
		        
		        // Update change to be the remainder after using the current denomination
		        change %= centPayment[i]; 
		    }

		    // Display the output array
		    System.out.println("\nRueckgeld\n");
		    
		    for (String denomination : output) {
		    	
		        System.out.println(denomination);
		    
		    }
			
		} else {
			
			System.out.println("Du Geizhals steckst jetzt fest!");
			return 0;
			
		}
		
		
		// Return an array of whole numbers that shows the amount of coins being given back
		return 0;
	}
}
