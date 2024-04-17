package luca;

import java.util.Scanner;

//Programm, das eine Zeichenkette um Ihre jeweiligen drauffolgenden Buchstaben verschlüsselt.


public class Verschluesslung {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie den zu verschlüsselnden Text ein:");
		
		String s = in.nextLine();
		String newS =  "";
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int j;
			
			if((c >= 'a' && c < 'z') || (c >= 'A' && c < 'Z')) {
				j = c; 
				j++; 
				c = (char) j;
			} else if(c == 'z') {
				c = 'a';
			} else if(c == 'Z') {
				c = 'A';
			} 
			
			newS = newS + c;	
			
		}
		
		System.out.println("Verschlüsselter Text: " + newS);
		
		in.close();


	}

}
