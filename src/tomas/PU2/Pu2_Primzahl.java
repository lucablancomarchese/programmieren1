package tomas.PU2;

import java.util.Scanner;

public class Pu2_Primzahl {
	public static void main(String[] args) {
			
			int input;
		
			Scanner in = new Scanner(System.in);
			System.out.println("Geben Sie eine Nummer ein: ");
			
				
			input = in.nextInt();
			
			// First loop breaks down inputed number into a range excluding 1 (5 = 5,4,3,2)
			
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
					System.out.println(i + " ist eine Primzahl.");
				}
			}
			in.close();	
		}
	}
		
	

	