package luca;
import java.util.Scanner;

public class Zaehler {

	public static void main(String[] args) {
		
		int input = 0;
		int inputs = 0;
		int sum = 0;
		
		Scanner in = new Scanner(System.in);
		
		while(input >= 0) {
			System.out.println("Geben Sie eine Zahl ein: ");
			input = in.nextInt();
			
			if (input % 2 == 0 && input >= 0) {	//Überprüfung ob Rest 0 ist beim Teilen durch 2
				sum = sum + input; 
				System.out.println("Gerade, Zahl wurde addiert!");
				System.out.println("Aktueller Stand: " + sum);
				inputs++;
			} else if(input >= 0){
				System.out.println("Zahl ungerade.");
				inputs++;
			}
			
		}
		System.out.println("Programm beendet!");
		System.out.println("Eingaben: " + inputs);
		System.out.println("Gesammtsumme lautet: " + sum);

	}

}
