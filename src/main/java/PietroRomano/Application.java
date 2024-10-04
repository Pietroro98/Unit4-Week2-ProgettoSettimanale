package PietroRomano;

import java.sql.SQLOutput;

public class Application {

    public static void main(String[] args) {

        Collezione collezione = new Collezione();
        System.out.println("--------------------------------------------------------------");
        Videogioco videogioco1 = new Videogioco(1,"FIFA 25",2024, 59.88, "PS5", 7, Genere.SPORT);
        Videogioco videogioco2 = new Videogioco(2,"Assassin's Creed Shadows | Limited Edition", 2025, 79.99, "XBOX Series X", 1800 /*1800=30 ore in minuti*/, Genere.AZIONE);
        Videogioco videogioco3 = new Videogioco(3,"Guitar Hero 5",2010, 69.99, "PC", 1200, Genere.MUSICA);

        System.out.println("VIDEOGIOCO:  ");
        System.out.println("ID: " + videogioco1.getIdGioco());
        System.out.println("Titolo: " + videogioco1.getTitolo());
        System.out.println("Anno di pubblicazione: " + videogioco1.getAnnoPubblicazioneGioco());
        System.out.println("Durata media: " + videogioco1.getDurataInMinuti());
        System.out.println("Prezzo : " + videogioco1.getPrezzo() + " €");
        System.out.println("Genere: " + videogioco1.getGenere());

        System.out.println("--------------------------------------------------------------");

        GiocoDaTavolo giocoDaTavolo1 = new GiocoDaTavolo(4, "Monopoly Ultimate Banking", 2016, 82.37, 4, 20);
        GiocoDaTavolo giocoDaTavolo2 = new GiocoDaTavolo(5, "RISIKO", 2017, 35.79, 6, 480);
        GiocoDaTavolo giocoDaTavolo3 = new GiocoDaTavolo(6, "Gioco dell'oca", 2023, 7.99, 6, 50);

        System.out.println("GIOCO DA TAVOLO:");
        System.out.println("ID: " + giocoDaTavolo1.getIdGioco());
        System.out.println("Titolo: " + giocoDaTavolo1.getTitolo());
        System.out.println("Anno Pubblicazione: " + giocoDaTavolo1.getAnnoPubblicazioneGioco());
        System.out.println("Prezzo: " + giocoDaTavolo1.getPrezzo() + " €");
        System.out.println("Numero di Giocatori: " + giocoDaTavolo1.getNumeroGiocatori());
        System.out.println("Durata Media Partita: " + giocoDaTavolo1.getDurataInMinuti());

        System.out.println("--------------------------------------------------------------");

        System.out.println("Aggiungi gioco alla collezione:");
        collezione.aggiungiElemento(videogioco1);
        collezione.aggiungiElemento(videogioco2);
        collezione.aggiungiElemento(videogioco3);
        collezione.aggiungiElemento(giocoDaTavolo1);
        collezione.aggiungiElemento(giocoDaTavolo2);
        collezione.aggiungiElemento(giocoDaTavolo3);


        System.out.println("--------------------------------------------------------------");

        System.out.println("Ricerca Gioco per ID: ");
        Gioco gioco = collezione.ricercaGiocoPerId(1);
        if (gioco != null) {
            System.out.println("Gioco trovato per ID 1: " + gioco.getTitolo());
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println("Ricerca Gioco per prezzo: ");




    }
}
