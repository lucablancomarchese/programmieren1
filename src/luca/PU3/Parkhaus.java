package luca.PU3;

import java.util.Scanner;

public class Parkhaus {
	
	static String einfahrt;
	static String ausfahrt;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		boolean parkhaus = false;
		int parkgebuehr = 0;
		int parkdauer = 0;
		
		System.out.println("Parkzeitberechnung \n \n");
		System.out.print("Einfahrt (hh:mm): ");
		einfahrt = in.nextLine();
		System.out.print("Ausfahrt (hh:mm): ");
		ausfahrt = in.nextLine();	
		parkhaus = istEingabeGueltig(einfahrt, ausfahrt);
		
		if(parkhaus==true) {
			parkdauer = berechneZuZahlendeParkdauer(einfahrt, ausfahrt);
			parkgebuehr = berechneParkgebuehr(parkdauer);
			
			if (parkgebuehr > 0) {
				System.out.print("Zahlung (€€,cc): ");
				String zahlung = in.nextLine();
				int convertedZahlung = zahlungGueltig(zahlung);
				
				
				if( convertedZahlung < parkgebuehr) {
					if(convertedZahlung == -1) {
						System.out.println("Falscher Geldbetrag!");
					}
					if(convertedZahlung < -1) {
					System.out.println("Du Geizhals steckst jetzt fest!");
					}
				
					
				} else {
					int rueckgeld = convertedZahlung - parkgebuehr;
					System.out.println(rueckgeld);
					int[] coins = rueckgeld(rueckgeld);
					System.out.println("\nRueckgeld");
					for (int i = 0; i < coins.length; i++) {
						if(i == 0) {System.out.println("2 Euro: " + coins[i]);}
						if(i == 1) {System.out.println("1 Euro: " + coins[i]);}
						if(i == 2) {System.out.println("50 Cent: " + coins[i]);}
						if(i == 3) {System.out.println("20 Cent: " + coins[i]);}
						if(i == 4) {System.out.println("10 Cent: " + coins[i]);}
						
					}
					
				}
			}	
		} else {
			System.out.println("Programm beendet!");
		}
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
		
			//Überprüfung, ob das Format stimmt.
			if(!einfahrt.matches("\\d{2}:\\d{2}") || !ausfahrt.matches("\\d{2}:\\d{2}")) {
				System.out.println("Bitte halten, Sie sich an das richtige Format!");
				return false;
			}

			//Überprüfung, ob die Minuteneingabe innerhalb der Minutenzeit sind.
			if(!ueberpruefeMinutenEingabe(einfahrt) || !ueberpruefeMinutenEingabe(ausfahrt)) {
				System.out.println("Bitte geben Sie eine gültige Minutenzahl ein!");
				return false;
			}

			int einfahrtInMinuten = konvertiereEingabe(einfahrt);
			int ausfahrtInMinuten = konvertiereEingabe(ausfahrt);
			//System.out.println(einfahrtInMinuten);
			//System.out.println(ausfahrtInMinuten);


			//Überprüfung, ob die Zeiten innerhalb der Betriebszeiten liegen.
			if(ausfahrtInMinuten - einfahrtInMinuten > 960 || einfahrtInMinuten < 360 || ausfahrtInMinuten > 1320) {
				System.out.println("Bitte halten sie sich an die Öffnungszeiten!");
				return false;
			}
			
			if(ausfahrtInMinuten < einfahrtInMinuten) {
				System.out.println("Die Einfahrtszeit muss vor der Ausfahrtszeit sein!");
				return false;
			}

			return true;
		}
	
	
	
	/**
	* Hilfsmethode um die Zeiteingabe in Minuten umzuwandeln
	* 
	* @param Zeitangabe (Einfahrts- oder Ausfahrtszeit.)
	* @return die Zeiteingabe in Minuten.
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
	* Hilfsmethode um die Minuteneingabe der Zeiten zu überprüfen
	* 
	* @param Zeitangabe (Einfahrts- oder Ausfahrtszeit.)
	* @return true, wenn die Minuten sich im Uhrenformat Zeitformat sind.
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
		
		// Alles zwischen 6:00 und 11:00 ist kostenlos.
		if(ausfahrtInMinuten <= 660) {
			parkdauer = 0;
		// Fall, wenn Parkzeit zwischen gebührenfreien und g ebührenpflichtigen Zeit ist.
		} else if (einfahrtInMinuten <= 660 && ausfahrtInMinuten > 660) {
			//Parkdauer wird erst ab 11:00 gezählt.
			parkdauer = ausfahrtInMinuten - 660;
		// Fall, alles ab 10:00 
		} else if(einfahrtInMinuten > 600) {
			//Erste Stunde wird abgezogen
			parkdauer = ausfahrtInMinuten - einfahrtInMinuten - 60;
			
			//Fall, sollte dann die Parkdauer unter 0 gehen.
			if(parkdauer < 0) {
				// zuZahlenden Parkdauer beträgt 90 Minuten als0 3,00€
				parkdauer = 90;
			}
		} 
	
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
		int parkgebuehr = 0;
		
		if(parkdauer == 0) {
			parkgebuehr = 0;
			System.out.println("\nKeine Parkgebuehr erforderlich.");
		} else {
			// Berechnet die ersten 1.5 Stunden
			parkdauer = parkdauer - 90;
			parkgebuehr = parkgebuehr + 300;
			// Fall, wenn die Parkdauer noch nicht 0 ist.
			if (parkdauer > 0) {
				//Solange Parkdauer noch nicht 0 ist, werden für jede angefangene Stunde 1,50€ addiert.
				boolean loop = false;
				while (parkdauer > 0 || loop == true) {
					
					if(parkdauer <= 0) {
						loop = true;
					}
					parkgebuehr += 150;
					parkdauer -= 60; 
				}
			}
			// Checkt, dass Parkgebühren nicht mehr als 10,00 werden.
			if (parkgebuehr > 1000) {
				parkgebuehr = 1000;	
			}	
			//Ausgabe der Parkgebuehr 
			int cent, euro;
			cent = parkgebuehr % 100;
			euro = (parkgebuehr - cent) / 100;
			System.out.println("\nParkgebuehr: " + euro + " Euro und " + cent + " Cent");
		}
		return parkgebuehr;
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
		//Umwandlung der Zahlung in Cents.
		String parts[] = zahlung.split(",");
		int[] convertedParts = new int[parts.length];
		for (int i = 0; i < parts.length; i++) {
			convertedParts[i] = Integer.parseInt(parts[i]);
		}
		
		int convertedZahlung = convertedParts[0] * 100 + convertedParts[1];
		//Überprüft, dass die Zahlung nicht über 99,90 und nur durch 10 teilbar ist.
		if(convertedZahlung > 9900 || convertedZahlung % 10 != 0) {
			System.out.println("Falscher Geldbetrag!");
			return -1;
		}
		
		return convertedZahlung;
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
	*/
	public static int[] rueckgeld(int rueckgeld) {
		
		int[] coins = new int[5]; // Münztypen: 10, 20, 50, 100, 200
	    int[] coinValues = {200, 100, 50, 20, 10}; // Werte der Münztypen
	    int i = 0;

	    while (rueckgeld > 0 && i < coins.length) {
	        while (rueckgeld >= coinValues[i]) {
	            coins[i]++;
	            rueckgeld -= coinValues[i];
	        }
	        i++;
	    }
	    return coins;

	
	}
	
	

}
