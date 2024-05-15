package luca.PU3;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParkhausTest {

	@Test
    public void testIstEingabeGueltig() {
		assertTrue(Parkhaus.istEingabeGueltig("06:00", "22:00"));
		System.out.println("yes");
		assertTrue(Parkhaus.istEingabeGueltig("06:00", "06:00"));
		assertTrue(Parkhaus.istEingabeGueltig("22:00", "22:00"));
		assertTrue(Parkhaus.istEingabeGueltig("06:59", "21:59"));
		assertTrue(Parkhaus.istEingabeGueltig("06:01", "21:01"));
		assertFalse(Parkhaus.istEingabeGueltig("06:60", "21:60"));
		assertFalse(Parkhaus.istEingabeGueltig("05:59", "22:01"));
		assertFalse(Parkhaus.istEingabeGueltig("05:00", "22:00"));
		assertFalse(Parkhaus.istEingabeGueltig("06:00", "23:00"));
		assertFalse(Parkhaus.istEingabeGueltig("06.00", "22:00"));
		assertFalse(Parkhaus.istEingabeGueltig("06:00", "22.00"));
		assertFalse(Parkhaus.istEingabeGueltig("6:00", "22.00"));
		assertFalse(Parkhaus.istEingabeGueltig("06:00", "2.00"));
		assertFalse(Parkhaus.istEingabeGueltig("006:00", "22.00"));
		assertFalse(Parkhaus.istEingabeGueltig("06:00", "022.00"));
		assertFalse(Parkhaus.istEingabeGueltig("06:0a", "22.00"));
		assertFalse(Parkhaus.istEingabeGueltig("06:00", "2d.00"));
		assertFalse(Parkhaus.istEingabeGueltig("21:00", "20.00"));
		assertFalse(Parkhaus.istEingabeGueltig("06:01", "06.00"));
    }

    @Test
    public void testKonvertiereEingabe() {
        assertEquals(420, Parkhaus.konvertiereEingabe("07:00"));
        assertEquals(900, Parkhaus.konvertiereEingabe("15:00"));
    }

    @Test
    public void testUeberpruefeMinutenEingabe() {
        assertTrue(Parkhaus.ueberpruefeMinutenEingabe("07:00"));
        assertFalse(Parkhaus.ueberpruefeMinutenEingabe("07:60"));
    }

    @Test
    public void testBerechneZuZahlendeParkdauer() {
       
        assertEquals(0, Parkhaus.berechneZuZahlendeParkdauer("06:00", "10:00"));
		assertEquals(0, Parkhaus.berechneZuZahlendeParkdauer("06:00", "11:00"));
		assertEquals(0, Parkhaus.berechneZuZahlendeParkdauer("11:00", "12:00"));
		assertEquals(0, Parkhaus.berechneZuZahlendeParkdauer("12:31", "13:31"));
		assertEquals(1, Parkhaus.berechneZuZahlendeParkdauer("12:00", "13:01"));
		assertEquals(61, Parkhaus.berechneZuZahlendeParkdauer("08:00", "12:01"));

    }

    @Test
    public void testBerechneParkgebuehr() {
        assertEquals(0, Parkhaus.berechneParkgebuehr(0));
        assertEquals(300, Parkhaus.berechneParkgebuehr(90));
        assertEquals(450, Parkhaus.berechneParkgebuehr(150));
        assertEquals(1000, Parkhaus.berechneParkgebuehr(600)); // Maximalgebühr
    }

    @Test
    public void testZahlungGueltig() {
        assertEquals(500, Parkhaus.zahlungGueltig("05,00"));
        assertEquals(-1, Parkhaus.zahlungGueltig("5,00")); // Falsches Format
        assertEquals(-1, Parkhaus.zahlungGueltig("10,99")); // Nicht durch 10 teilbar
    }

    @Test
    public void testRueckgeld() {
        int[] expected = {1, 0, 0, 0, 0};
        assertArrayEquals(expected, Parkhaus.rueckgeld(200));
        
        expected = new int[]{0, 1, 1, 1, 1};
        assertArrayEquals(expected, Parkhaus.rueckgeld(180));
    }

}
