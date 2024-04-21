package tomas.PU2;

import java.util.Scanner;

public class pu2_romano {
	
	public static void main(String[] args) {

		Scanner in = new Scanner (System.in);
		
		int input = in.nextInt();
		
		// Join together 1-10, 100-1000,etc. Reduce it to 3 arrays.
		
		String p[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI"};
		String l[] = {"", "XX", "XXX", "XL", "L", "LX", "LXX", "LXX", "LXXX", "XC", "C", "CC", "CCC", "CD"};
		String m[] = {"", "D", "DC", "DCC", "DCCC", "CM", "M"};

		for(int i = 1; i <= input; i++) {
			System.out.println(i);
		}
		
		
		
		/** 
		 * Store each combination in string and if number pair combination with index of string
		 */
		
	}
}