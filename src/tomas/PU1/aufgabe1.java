package tomas.PU1;

import java.util.Scanner;

public class aufgabe1 {
public static void main(String[] args) {
		
		// Ben�tigte Variablen deklarieren
		double epsilon = 0.005;
		double c = 0.0, f;
		
		// F�r die Eingabe von der Tastatur
		Scanner in = new Scanner(System.in);
		
		// Berechnungsschleife
		do {
			// Anleitung
			System.out.println("Programm endet durch Eingabe von 1");
			System.out.println("Eingabe der Celsius-Temperatur: ");
			// Eingabe, Double-Wert einlesen
			f = in.nextDouble();
			// Umrechnen in Fahrenheit
			c = (f - 32) * 5.0/9.0;
			// Ausgabe des Ergebnis
			System.out.println("... in Celsius: " + c + " Grad \n");
		// Schleife durch Eingabe von 0 verlassen?
		} while (Math.abs(f - 1) > epsilon);
		
		System.out.println("... und tsch�ss");
		in.close();
	}
}
