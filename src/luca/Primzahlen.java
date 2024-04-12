package luca;

import java.util.Scanner;

public class Primzahlen {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie Ihr Maximum ein: ");
		
		int input = in.nextInt();
		
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
	}

}
