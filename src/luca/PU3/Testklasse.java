package luca.PU3;

public class Testklasse {

	public static void main(String[] args) {
	String time = "10:06";
	double hourInNumber = 0;
	double minuteInNumber = 0;
	System.out.println(time.length());
	for (int i = 0; i < time.length(); i++) {
		if(i == 0) {
			hourInNumber = ((double) time.charAt(i)-48) * 10;
		}
		if(i == 1) {
			hourInNumber = hourInNumber + ((double) time.charAt(i)-48);
		}
		if(i == 3) {
			minuteInNumber = ((double) time.charAt(i)-48) / 10;
		}
		if(i == 4) {
			minuteInNumber = minuteInNumber + ((double) time.charAt(i)-48) / 100;
		}
	}
	
	System.out.println(hourInNumber+ minuteInNumber);
	System.out.println();
			
			
	}

}
