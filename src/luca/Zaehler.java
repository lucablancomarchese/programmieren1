package luca;
import java.util.Scanner;

public class Zaehler {

	public static void main(String[] args) {
		
		int input = 0;
		int summe = 0;
		
		Scanner in = new Scanner(System.in);
		
		while(input >= 0) {
			System.out.println("Geben Sie eine Zahl ein: ");
			input = in.nextInt();
			
			if (input % 2 == 0) {
				summe = summe + input;
				System.out.println("Gerade, Zahl wurde addiert!");
				System.out.println("Aktueller Stand: " + summe);
			} else {
				System.out.println("Zahl ungerade.");
			}
		}
		System.out.println("Programm beendet!");
		System.out.println("Gesammtsumme lautet:" + summe);

	}

}
