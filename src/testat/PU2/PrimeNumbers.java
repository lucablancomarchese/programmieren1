package testat.PU2;

import java.util.Scanner;

public class PrimeNumbers {
	
	/*
	 * Program that calculates prime numbers up to a maximum entered by the user.
	 */

	public static void main(String[] args) {
		int input;
		
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.println("Enter a number: ");
			input = in.nextInt();
			if(input < 2) {
				System.out.println("Enter a number greater than 1");
			}
			
		} while(input < 2);
		
		// First loop breaks down inputed number into a range excluding 1 (5 = 5,4,3,2)
		
		System.out.println("Prime numbers up to " + input + ":");
		
		for(int i = 2; i <= input; i++) {
			
			boolean isPrime = true;
			
		// Checks if broken down numbers are divisible by 2.
		// If divisible, then the number isn't prime.
			
			for(int j = 2; j <= i/2; j++) {
				
				if(i % j == 0) {
					isPrime = false;
				}
			}
			
		// If not divisible then number is prime and gets printed in the console.
			
			if(isPrime) {
				System.out.println(" [ "+i+" ] ");
			}
		}
		in.close();	
	}

	}


