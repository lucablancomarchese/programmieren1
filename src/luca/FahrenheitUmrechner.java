package luca;

import java.util.Scanner;

public class FahrenheitUmrechner {

	public static void main(String[] args) {
		
				//Variablen deklaration:
				double epsilon = 0.005;
				double c = 0.0, f;
				
				// Variable zum einlesen:
				Scanner in = new Scanner(System.in);
				
				do {
					System.out.println("Programm endet durch Eingabe von 0");
					System.out.println("Eingabe der Fahrenheit Temperatur:");
					//Eingabe wird eingelesen und in Varible gemacht
					f = in.nextDouble();
					
					//Umrechnen in Fahrenheit
					c = (f - 32) * 5/9;
					
					//Die Zahl in Fahrenheit ausgeben
					System.out.println("... in Celsius " + c + " Grad Celsius \n");
					
				} while (Math.abs(f - 1) > epsilon); //Math abs um aus einer Zahl einen Betrag zu machen:
				
				System.out.println("Programm beendet!");
	}

}
