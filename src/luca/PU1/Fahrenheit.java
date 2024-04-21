package luca.PU1;

import java.util.Scanner;

//Programm zur Berechnung der Celsius Temperatur 
//bei bekannter Fahrenheit Temperatur

public class Fahrenheit {

	public static void main(String[] args) {
		
				// Benötigte Variablen deklarieren
				double epsilon = 0.005;
				double c = 0.0, f;
				
				// Für die Eingabe von der Tastatur
				Scanner in = new Scanner(System.in);
				
				// Berechnungsschleife
				do {
					// Anleitung
					System.out.println("Programm endet durch Eingabe von 1");
					System.out.println("Eingabe der Fahrenheit Temperatur:");
					
					// Eingabe, Double-Wert einlesen
					f = in.nextDouble();
					
					// Umrechnen in Celsius
					c = (f - 32) * 5/9;
					
					// Ausgabe des Ergebnis
					System.out.println("... in Celsius " + c + " Grad Celsius \n");
				
				// Schleife durch Eingabe von 1 verlassen?
				} while (Math.abs(f - 1) > epsilon);
				
				System.out.println("... und tschüss");
				in.close();
	}

}
