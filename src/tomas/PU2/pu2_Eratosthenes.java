package tomas.PU2;

import java.util.Scanner;
import java.util.Arrays;

public class pu2_Eratosthenes {
	public static void main(String[] args) {
		
		System.out.println("Enter your max. number: ");
		Scanner in = new Scanner(System.in);
		
		int input = in.nextInt();
		boolean[] isPrime = new boolean [input + 1];
		
		Arrays.fill(isPrime, true);
		
		
		// First loop ensures that only prime numbers up to the square root of the input are considered.
		for(int p = 2; p * p <= input; p++) {
			
			// Checks if current number is marked as prime, if it is, then it executes the loop inside.
			if (isPrime[p]) {
				
				// Second loop starts from the square of the current prime number. Every multiple of 'p' is marked as non-prime
				for (int i = p * p; i <= input; i += p) {
					isPrime[i] = false;
				}
			}
		}
		
		System.out.println("Prime numbers up to " + input + " ");
		for(int i = 2; i <= input; i++) {
			if (isPrime[i]) {
				System.out.println(i + " ");
			}
		}
		in.close();	
	}
}


/*  For this task, the use of multiplication and division is prohibited in the entire source code. */ 

/* Use array list for dynamic list and then add 'X' with If statement. */