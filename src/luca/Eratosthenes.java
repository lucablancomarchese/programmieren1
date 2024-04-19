package luca;

import java.util.Scanner;

public class Eratosthenes {
	
	/*
	 * Programm, dass Primzahlen mithilfe 
	 * des "Sieb des Eratosthenes" aussortiert.
	 * 
	*/

	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Gebe dein Maximum ein: ");
		
		int input = in.nextInt() + 1;
		
		boolean[] numbers = new boolean[input];
		
		
		// 0 und 1 auf true setzen, da sie sowieso keine Primzahlen sind
		numbers[0] = true;
		numbers[1] = true;
	
		
		// Schleife um Primzahlen zu sortieren.
		for (int i = 2; i < input - i; i++) {
			
			for (int j = i + 1; j < input; j++) {
				
				if(j%i == 0&& j != i) {
					numbers[j] = true;
				} 
				 
				
			} 
	
		}
		
		System.out.print("Die Primzahlen bis " + (input-1) + " lauten: ");
		
		
		// Ausgabe der Primzahlen
		for (int k = 0; k < numbers.length; k++) {
			
			if (!numbers[k]) {
				System.out.print(" [ "+k+" ] ");
			}
			
		}	

	}

}
