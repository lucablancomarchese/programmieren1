package luca.PU6;

public class Paket {
    String empfaenger;
    String adresse;
    int i = 5;


    public Paket(String pEmpfaenger, String pAdresse) {
        empfaenger = pEmpfaenger;
        adresse = pAdresse;
    }

    public String getAnschrift() {
        return adresse;
    }

    public String getEmpfaenger() {
        return empfaenger;
    }
    public String toString() {
        return "Empfänger: " + empfaenger + "\n" + "Adresse: " + adresse;
    }
}
