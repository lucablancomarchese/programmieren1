package testat.PU2;

import java.util.Scanner;

public class RomanNumbers {

	public static void main(String[] args) {
int i = 0;
		
		Scanner in = new Scanner (System.in);
		
		
		
		String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] arabic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		
		String output = " ";
		
		System.out.println("Enter your desired number: ");
		int input = in.nextInt();
		
		
		if(input > 0 && input < 4000) {
			
			while(input > 0) {
		
				/**
				 * The loop works it's way from the biggest to smallest number (1250 -> 1000 + 200 + 50).
				
				 The biggest number is added to the output as a Roman numeral and subtracted from the input (1250 -> 250 || output: M).
				
				 The loop repeats itself until all numbers are converted and the input is 0.  
				 */
				
				while (input >= arabic[i]) {
					
					output += roman[i];
					input -= arabic[i];
				}
				i++;
			}
		} else {
			System.out.println("Error");
		}

		
		// Prevents the printing of: "Your conversion is: ", when there is an error.	
		if(output.length() > 1) {
			System.out.println("Your conversion is: " + output);			
		}
		
		in.close();

	}

}
