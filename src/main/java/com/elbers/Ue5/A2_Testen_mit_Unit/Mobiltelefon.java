package com.elbers.Ue5.A2_Testen_mit_Unit;

	public class Mobiltelefon {
		private String besitzer;
		private String marke;
		private String farbe;
		private Boolean eingeschaltet;
		private int ladezustand;

		public Mobiltelefon(String bBesitzer, String mMarke, String fFarbe)
		{
				besitzer = bBesitzer;
				marke = mMarke;
				farbe = fFarbe;
				eingeschaltet = false;
				ladezustand = 100;

				System.out.println("Erzeugen eines neuen Mobiltelefons: " + "Besitzer : " + besitzer + 							" " + "Marke: "+ marke + " " + "Farbe: " + farbe);
		}

		public void einschalten()
		{
				if (!eingeschaltet) {
					System.out.println("Mobiltelefon von " + besitzer + " : " + "Wird eingeschaltet... 	");
					eingeschaltet = true;
					ladezustand = ladezustand - 10;
				}
				else {
					System.out.println("Das Mobiltelefon von: " + besitzer + " " + " ist schon eingeschaltet");
				}
		}

		public void ausschalten()
		{
				System.out.println("Mobiltelefon von " + besitzer + " : " + "Ausschalten des Mobiltelefons");
				eingeschaltet = true;
		}
	
		
		public void telefonieren(String nummer)
		{
			if (ladezustand > 50) {
				System.out.println("Mobiltelefon von " + besitzer + " : " + "Anrufen der Nummer: " + nummer);
				ladezustand = ladezustand - 30;
			}
			else {
				System.out.println("Mobiltelefon von " + besitzer + " : Bitte aufladen");
			}
		}

		public void spielen()
		{
			System.out.println("Mobiltelefon von " + besitzer + " : " + "Spielen....");
			ladezustand = ladezustand - 20;
		}
		
		public boolean getEingeschaltet()
		{
			return eingeschaltet;
		}
		
		public boolean getAusgeschaltet()
		{
			return eingeschaltet!=true;
		}
	
}

