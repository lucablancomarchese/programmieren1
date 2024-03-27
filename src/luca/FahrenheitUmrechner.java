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
					System.out.println("Eingabe der Celsius-Temperatur:");
					//Eingabe wird eingelesen und in Varible gemacht
					c = in.nextDouble();
					
					//Umrechnen in Fahrenheit
					f = c* 9.0/5.0 + 32;
					
					//Die Zahl in Fahrenheit ausgeben
					System.out.println("... in Fahrenheit " + f + " Grad \n");
					
				} while (Math.abs(c) > epsilon); //Math abs um aus einer Zahl einen Betrag zu machen:
				
				System.out.println("Programm beendet!");
	}

}
