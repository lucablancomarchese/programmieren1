package luca.PU2;

import java.util.Scanner;

/*
 * 
 * Programm, dass Primzahlen, bis zu einem vom 
 * Benutzer eingebenenen Maximum berechnet.
 * 
 */

public class Primzahlen {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie Ihr Maximum ein: ");
		
		int input; 
		
		do {
			input = in.nextInt();
			if(input < 2) {
				System.out.println("Bitte gebe eine Zahl, die größer als 1 ist ein!");
			}
		} while (input < 2);
		
		System.out.println("Primzahlen bis " + input + " sind: ");
		
		for (int i = 2; i <= input ; i++) {
			int modulo = 1;
			
			for (int j = 2; modulo != 0 && j < i ; j++) {
				modulo = i % j;
			}
		
			if(modulo != 0) {
				//Output prime numbers
				System.out.println(i);
			}
		}
		
		System.out.println("Programm beendet!");
		in.close();
	}

}
