package com.elbers.Ue5.A2_Testen_mit_Unit;

import org.eclipse.persistence.jpa.jpql.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MobiltelefonTest {
    Mobiltelefon mobil;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @BeforeEach
    void setUp() {
        mobil = new Mobiltelefon("user", "marke", "farbe");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void einschalten() {
        Assert.isFalse(mobil.getEingeschaltet(), "einschaltenCon1");
        mobil.einschalten();
        Assert.isTrue(outContent.toString().trim().equals("Mobiltelefon von user : Wird eingeschaltet..."),
                "einschaltenCon2.1");
        outContent.reset();
        Assert.isTrue(mobil.getEingeschaltet(), "eingeschaltenCon2.2");
        mobil.einschalten();
        Assert.isTrue(outContent.toString().trim().equals("Das Mobiltelefon von: user  ist schon eingeschaltet"),
                "einschaltenCon3.1");
        outContent.reset();
        Assert.isTrue(mobil.getEingeschaltet(), "eingeschaltenCon3.2");
        }

    @Test
    void ausschalten() {
        Assert.isTrue(mobil.getAusgeschaltet(), "ausschaltenCon1");
        mobil.einschalten();
        outContent.reset();
        mobil.ausschalten();
        Assert.isTrue(outContent.toString().trim().equals("Mobiltelefon von user : Ausschalten des Mobiltelefons"),
                "ausschaltenCon2.1");
        outContent.reset();
        Assert.isTrue(mobil.getAusgeschaltet(), "ausgeschaltenCon2.2");
    }

    @Test
    void telefonieren() {
        for(int i = 1; i < 3; i++) {
            mobil.telefonieren("1234");
            Assert.isTrue(outContent.toString().trim().equals("Mobiltelefon von user : Anrufen der Nummer: 1234"),
                    "telCon1." + i);
            outContent.reset();
        }
        mobil.telefonieren("1234");
        Assert.isTrue(outContent.toString().trim().equals("Mobiltelefon von user : Bitte aufladen"),
                "telCon2.1");
    }

    @Test
    void spielen() {
        mobil.spielen();
        Assert.isTrue(outContent.toString().trim().equals("Mobiltelefon von user : Spielen...."),
                "spielenCon1");
        outContent.reset();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }
}