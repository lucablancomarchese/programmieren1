package luca;

import java.util.Scanner;

public class Zaehler {
	
	//Programm, dass ganzzahlige Benutzereingaben summiert, 
	//wenn sie gerade sind und die Gesamtsumme und die Eingaben ausgibt.
	
	public static void main(String[] args) {
		
		
		int input;
		int inputs = 0;
		int sum = 0;
		
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.println("Geben Sie eine Zahl ein: ");
			input = in.nextInt();
			
			if(input >= 0) {
				inputs++;
				if(input % 2 == 0) {
					sum = sum + input;
					System.out.println("Aktueller Stand: " + sum);
					
				}
			}
			
		} while( input >= 0);
		
		System.out.println("Programm beendet!");
		System.out.println("Eingaben: " + inputs);
		System.out.println("Gesammtsumme lautet: " + sum);

	}

}
