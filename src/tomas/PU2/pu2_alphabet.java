package tomas.PU2;

import java.util.Scanner;

public class pu2_alphabet {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your sentence: ");
		
		String input = sc.nextLine();
		String inputString = String.valueOf(input);
		String processedString = " ";
		
		
		// First loop breaks down string into individual characters
		
		for (int i = 0; i < inputString.length(); i++) {
			
			char c = inputString.charAt(i);
			
		// Checks if elements of the string are letters, if so then it replaces every letter with the next one in the alphabet using ASCII.	
		// Also checks for Upper case in order to keep upper-lower case parity in the transformation.
			
			if(Character.isLetter(c)) {
				
				// Check for lower case letters.
				
				if(c >= 'a' && c <= 'z') { 
					c = (char) (c + 1); 
					
				// Wrap around for lower case 'z' (from z -> a).
					
				} else if (c == 'z') { 
					c = 'a';
					
				// Check for upper case letters.	
					
				} else if (c >= 'A' || c < 'Z') { 
					c = (char) (c + 1);
					
				// Wrap around (z -> a) for upper case 'Z'.
					
				} else if (c == 'Z') { 
					c = 'A';
				}
				
			// When input isn't a character it adds a space.
				
			} else {
				c = ' ';
			}
			
			// Concatenate 'c' (Broken down input string) characters into one String.
			
			processedString += c;
		}
		
		System.out.println("Input: " + input);
		System.out.println("Output: " + processedString);
		
		sc.close();
	}
}
