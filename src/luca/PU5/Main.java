package luca.PU5;
import luca.PU5.*;

public class Main {

	public static void main(String[] args) {
		
		Zahlenspiel zs = new Zahlenspiel();
		int userinput = 1423;
		int reversenumber = zs.umdrehenDerZahl(userinput);
		System.out.println("Umgedrehte Zahl von " + userinput + " =" + reversenumber);
		int summe = zs.summeDerZiffern(reversenumber);
		System.out.println("Summe: " +  summe);
		System.out.println(zs.wetteGewonnen(summe));
		int[] list = zs.ziffernSortieren(reversenumber);
		
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i]);
		}
		
		
		
	

	}

}
