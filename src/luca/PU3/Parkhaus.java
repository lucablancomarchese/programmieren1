package luca.PU3;

import java.util.Scanner;

public class Parkhaus {
	
	static String einfahrt;
	static String ausfahrt;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		boolean parkhaus = false;
		
		
		
		System.out.println("Parkzeitberechnung \n \n");

		System.out.print("Einfahrt (hh:mm): ");
		einfahrt = in.nextLine();
		System.out.print("Ausfahrt (hh:mm): ");
		ausfahrt = in.nextLine();	
		
		parkhaus = istEingabeGueltig(einfahrt, ausfahrt);
		
		if (!parkhaus) {
			System.out.println("Falsche Eingabe! Programm beendet!");
		} else {
			berechneZuZahlendeParkdauer(einfahrt, ausfahrt);
		}
		
		
		
		
	
		konvertiereEingabe(einfahrt);
		
		
	}
		

	/**
	* Überprüft die Validität der Eingabezeiten in dem Format hh:mm.
	* Die Methode kontrolliert,
	* ob die Zeiten innerhalb der Betriebszeiten des Parkhauses
	* liegen (06:00 bis 22:00 Uhr),
	* ob die Einfahrtszeit nicht nach der Ausfahrtszeit liegt und ob das Format
	* hh:mm (also nur Zahlen und :) korrekt eingehalten werden.
	*
	* @param einfahrt Die Einfahrtszeit als String im Format hh:mm
	* @param ausfahrt Die Ausfahrtszeit als String im Format hh:mm
	* @return true, wenn beide Eingaben gültig sind, sonst false.
	*
	*/
		public static boolean istEingabeGueltig(String einfahrt, String ausfahrt) {
		
		
		
		//Kontrolle ob das Format der Eingabe stimmt.
		if(einfahrt.length() != 5 || ausfahrt.length() != 5 || einfahrt.charAt(2) != ':' || ausfahrt.charAt(2) != ':' ) {
			System.out.println("Bitte halten, Sie sich an das richtige Format!");
			return false;
		}
		
		//Kontrolle ob die Eingabe stimmt
		if(!ueberpruefeMinutenEingabe(einfahrt) || !ueberpruefeMinutenEingabe(ausfahrt)) {
			System.out.println("Bitte geben Sie eine gültige Minutenzahl ein!");
			return false;
		}
	
		int einfahrtInMinuten = konvertiereEingabe(einfahrt);
		int ausfahrtInMinuten = konvertiereEingabe(ausfahrt);
		System.out.println(einfahrtInMinuten);
		System.out.println(ausfahrtInMinuten);
		
		
		//Überprüfung, ob die Zeiten innerhalb der Betriebszeiten liegen
		if(ausfahrtInMinuten - einfahrtInMinuten > 960 || einfahrtInMinuten < 360 || ausfahrtInMinuten > 1320) {
			System.out.println("Bitte halten sie sich an die Öffnungszeiten!");
			return false;
		}
		
		
		
		return true;
		}
	
	
	
	/**
	* Hilfsmethode um aus String einen Integer zu machen und um 
	* Vergleiche mit der Einfahrts und Ausfahrtszeit zu machen.
	* Der Doppelpunkt wir hiermit einfach zum Komma.
	*/
		
	public static int konvertiereEingabe(String eingabe) {
		
		String parts[] = eingabe.split(":");
		int convertedParts[] = new int[parts.length];
				for (int i = 0; i < parts.length; i++) {
					convertedParts[i] = Integer.parseInt(parts[i]);
					
					
				}
		int eingabeInMinuten = convertedParts[0] * 60 + convertedParts[1];
		
		return eingabeInMinuten;
	}
	
	/**
	* Hilfsmethode um aus String einen Integer zu machen und um 
	* Vergleiche mit der Einfahrts und Ausfahrtszeit zu machen.
	* Der Doppelpunkt wir hiermit einfach zum Komma.
	*/
	
	public static boolean ueberpruefeMinutenEingabe(String eingabe) {
		
		String parts[] = eingabe.split(":");
		int minutePart = Integer.parseInt(parts[1]);
		
		if(minutePart > 60 && minutePart < 100) {
			return false;
		}
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	/**
	* Berechnet die Dauer in Minuten, für die Parkgebühren anfallen,
	* unter Berücksichtigung der gebührenfreien Zeiten.
	* Die Parkgebühr beginnt nach einer gebührenfreien Zeit von 06:00 bis 10:00 Uhr
	* sowie einer zusätzlichen
	* ersten kostenlosen Stunde nach Beginn der Gebührenpflicht um 10:00 Uhr. Wenn die
	* Parkdauer null Minuten beträgt
	* oder die gesamte Parkzeit innerhalb der gebührenfreien Zeitspannen liegt,
	* fallen keine Gebühren an und somit beträgt die parkdauer = 0.
	*
	* @param einfahrt Die Einfahrtszeit im Format hh:mm
	* @param ausfahrt Die Ausfahrtszeit im Format hh:mm
	* @return Die Dauer in Minuten, für die Parkgebühren anfallen, nach Abzug aller
	* kostenfreien Parkzeiten
	*/
	public static int berechneZuZahlendeParkdauer(String einfahrt, String ausfahrt) {
		
		int einfahrtInMinuten = konvertiereEingabe(einfahrt);
		int ausfahrtInMinuten = konvertiereEingabe(ausfahrt);
		int parkdauer= 0;
		
		// Alles bis 11:00 ist kostenlos
		if(ausfahrtInMinuten <= 660) {
			parkdauer = 0;
			
		
		} else if (einfahrtInMinuten <= 660 && ausfahrtInMinuten > 660) {
			parkdauer = ausfahrtInMinuten - 660;
		} else if(einfahrtInMinuten > 600) {
			parkdauer = ausfahrtInMinuten - einfahrtInMinuten - 60;
			
			if(parkdauer < 0) {
				parkdauer = 90;
			}
		} 
		System.out.println(parkdauer);
		
		
		
		return parkdauer;
	}
	
	/**
	* Berechnet die Parkgebühr basierend auf der gesamten gebührenpflichtigen
	* Parkdauer in Minuten.
	* Die ersten 90 Minuten nach der freien Zeit kosten pauschal 3,00 Euro.
	* Danach wird jede angefangene Stunde
	* mit 1,50 Euro berechnet, bis ein Maximalbetrag von 10,00 Euro erreicht ist.
	*
	* @param parkdauer Die gesamte gebührenpflichtige Parkdauer in Minuten.
	* @return Die Parkgebühr in Cent. Bei einer Parkdauer von 0 Minuten oder weniger
	* wird keine Gebühr berechnet.
	*/
	
	public static int berechneParkgebuehr(int parkdauer) {
		return -1;
	}
	
	/**
	* Überprüft die Gültigkeit der vom Benutzer eingegebenen Zahlung.
	* Eine gültige Zahlung muss im Format €€,cc erfolgen,
	* darf keine negativen Werte enthalten und die Cent-Angabe muss
	* durch 10 teilbar sein.
	*
	* @param zahlung Die eingegebene Zahlung als String im Format €€,cc
	* @return Den Wert der Zahlung in Cent, wenn diese gültig ist; andernfalls -1.
	*/
	public static int zahlungGueltig(String zahlung) {
		return -1;
	}
	
	/**
	* Berechnet die Aufteilung des Rückgelds in verschiedene Münzwerte
	* basierend auf dem übergebenen Gesamtbetrag in Cent.
	* Die Methode teilt das Rückgeld in die größtmöglichen Münzwerte auf,
	* beginnend mit 2 Euro, gefolgt von 1 Euro,
	* 50 Cent, 20 Cent und 10 Cent. Anschliessend gibt diese das Rückgeld in
	* absteigender Reihenfolge zurück.
	*
	* @param rueckgeld Der Rückgeldbetrag in Cent, der aufgeteilt werden soll.
	* @return Ein Array von ganzen Zahlen, das die Anzahl der Münzen für jede
	* Stückelung enthält. Die Reihenfolge im Array entspricht: [2 Euro-Münzen,
	* 1 Euro-Münzen, 50 Cent-Münzen, 20 Cent-Münzen, 10 Cent-Münzen].
	*
	public static int[] rueckgeld(int rueckgeld) {
		return 2;
		
	}
	*/
	

}
