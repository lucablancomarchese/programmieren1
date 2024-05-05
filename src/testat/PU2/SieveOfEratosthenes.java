package testat.PU2;

import java.util.Scanner;

/*
 * Programm, dass Primzahlen mithilfe 
 * des "Sieb des Eratosthenes" aussortiert.
 * 
*/

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		
Scanner in = new Scanner(System.in);
		
		int input;
		
		//Schleife um Eingabe des Maximums zu überprüfen.
		do {
			 System.out.print("Gebe dein Maximum ein: ");
			 input = in.nextInt();
			 if (input < 2) {
				 System.out.println("Bitte gebe ein Maximum, dass größer als 2 ist ein!");
			} else {
				input++;
			}
		} while(input < 2);
		
			boolean[] numbers = new boolean[input];
			
			// 0 und 1 auf true setzen, da sie sowieso keine Primzahlen sind
			numbers[0] = true;
			numbers[1] = true;
		
			int j;
			// Schleife um Primzahlen zu sortieren. 
			for (int i = 2; i < input - i; i++) {
				
				//Schleife überprüft, ob Zahl sich um eine Primzahl handelt.
<<<<<<< HEAD
				
				int j = i + 1;
				while(j < input) {
					if(j % i == 0) {
						numbers[j] = true;
					}
					j++;
				}
				
//				for (int j = i + 1; j < input; j++) {
//					
//					
//					if(j%i == 0) {
//						numbers[j] = true;
//					} 
//					 
//					
//				} 
			}
			
			System.out.print("Die Primzahlen bis " + (input-1) + " lauten: ");
			
			
			// Ausgabe aller Primzahlen
			for (int k = 0; k < numbers.length; k++) {
				
				if (!numbers[k]) {
					System.out.print(" [ "+k+" ] ");
				}
				
			} 
			
			in.close();
			

	}

}
