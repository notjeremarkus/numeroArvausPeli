/*
 * Numeroarvauspeli
 */

import java.util.*;

public class Numeroarvauspeli {
    private static boolean voitto;

    private static boolean voitto() {
        return voitto;
    }

    private static void voitto(boolean tulos) {
        voitto = tulos;
    }

    public static void main(String[] args) {
        /*
         * Peli kysyy käyttäjän arvaamaan numeroa ja kertoo, onko se pienempi vai suurempi,
         * kuin haettu numero. Numero on 1-50 väliltä ja pelaajalla on kuusi yritystä.
         */

        Random random = new Random();
        int haettuLuku = random.nextInt(50 + 1 - 1) + 1;
        int yritys = 0;
        boolean jatkuu = true;
        voitto(false);


        Scanner scan = new Scanner(System.in);
        System.out.println("Tämä on numeroarvauspeli. " + 
        "Arvaa, mitä numeroa haetaan välillä 1-50. Sinulla on kuusi yritystä");
        int arvaus = 0;
        while (jatkuu == true) {
            if (yritys == 0) {
                System.out.println("Arvaa numero 1-50 välillä. " + (6 - yritys) + " yritystä jäljellä.");
                arvaus = scan.nextInt();
                tarkistus(arvaus, haettuLuku);
                yritys++;
            }
            else if (yritys < 5 && voitto() == false) {
                System.out.println("Etsitty numero on " + pieniVaiSuuri(arvaus, haettuLuku) + " kuin arvauksesi. "
                                    + (6 -yritys) + " yritystä jäljellä.");
                arvaus = scan.nextInt();
                tarkistus(arvaus, haettuLuku);
                yritys++;
            }
            else if (yritys < 6 && voitto() == false) {
                System.out.println("Etsitty numero on " + pieniVaiSuuri(arvaus, haettuLuku) + " kuin arvauksesi. "
                                    + "Viimeinen yritys.");
                arvaus = scan.nextInt();
                tarkistus(arvaus, haettuLuku);
                yritys++;
            }
            else if (voitto() == true) {
                System.out.println("Onnittelut! Arvasit luvun oikein " + yritys + ". arvauksella!");
                jatkuu = false;
            }
            else if (yritys == 6 && voitto() == false) {
                System.out.println("Yritykset loppuivat. Hävisit pelin. Oikea luku oli " + haettuLuku);
                jatkuu = false;
            }
        }


        scan.close();
    }

    public static void tarkistus(int arvaus, int haettuLuku) {
        if (arvaus == haettuLuku) {
            voitto(true);
        }
    }

    public static String pieniVaiSuuri(int arvaus, int haettuLuku) {
        if (arvaus < haettuLuku) {
            return "suurempi";
        }
        else if (arvaus > haettuLuku) {
            return "pienempi";
        }
        else {
            return "";
        }
    } 
}