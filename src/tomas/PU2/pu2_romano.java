package tomas.PU2;

import java.util.Scanner;

public class pu2_romano {
	
	public static void main(String[] args) {

		Scanner in = new Scanner (System.in);
		
		int input = in.nextInt();
		char letter;
		//String processed = String.valueOf(letter);
		String output = " ";
		
		System.out.println("Please enter your desired number: ");
		
		
		for(int i = 0; i <= input; i++) {
			if (input == 1) {
				letter = 'I';
			} else if (input == 5) {
				letter = 'V';
			} else if (input == 10) {
				letter = 'X';
			} else if (input == 50) {
				letter = 'L';
			} else if (input == 100) {
				letter = 'C';
			} else if (input == 500) {
				letter = 'D';
			} else if (input == 1000) {
				letter = 'M';
			}
			//output += processed;
			System.out.println("Your converted number is: " +  output);
		}
	}
}