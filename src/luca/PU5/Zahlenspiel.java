package luca.PU5;

import java.util.Iterator;

public class Zahlenspiel {
	
	
	
	
	
	
	/**
	 * Methode die eine von Benutzer eingebene Zahl
	 * um "180" Grad umdreht. 180 -> 081
	 * @param input
	 * @return
	 */
	
	public static int umdrehenDerZahl(int input) {
		String sInput = "" + input;
		String sReverseInput = "";
		int reverseInput = 0;
		
		for (int i = (sInput.length() - 1); i >= 0; i--) {
			char c = sInput.charAt(i);
			sReverseInput = sReverseInput + c;
		}
		
		reverseInput = Integer.parseInt(sReverseInput);
		
		return reverseInput;
	}
	
	public static int summeDerZiffern(int reverseInput) {
		String sReverseInput = "" + reverseInput;
		int sumOfDigits = 0;
		for (int i = 0; i < sReverseInput.length(); i++) {
			char c = sReverseInput.charAt(i);
			int digit = (int) c - '0';
			sumOfDigits = sumOfDigits + digit;
		}
		
		return sumOfDigits;
	}
	
	public static boolean wetteGewonnen(int input) {
		int sumOfDigits = input;
		String isWin = "" + sumOfDigits;
		char lastChar = isWin.charAt(isWin.length() - 1);
		if(lastChar == '0') {
			System.out.println("Wette gewonnen!");
			return true;
		} else {
			System.out.println("Wette verloren!");
		}
		return false;
	}
	
	public static int[] ziffernSortieren(int input) {
		String sinput = "" + input;
		int[] numberList = new int[sinput.length()];
		for (int i = 0; i < numberList.length; i++) {
			char c = sinput.charAt(i);
			numberList[i] = (int) c - '0';
			
		}
		
		for (int i = 0; i < numberList.length; i++) {
			for (int j = i + 1; j < numberList.length; j++) {
				if (numberList[i] < numberList[j]) {
					int temp = numberList[i];
					numberList[i] = numberList[j];
					numberList[j] = temp;
				}
			}
		}
		
		return numberList;
	}
	
}
