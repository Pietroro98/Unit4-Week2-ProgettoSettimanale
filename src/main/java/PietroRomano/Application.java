package PietroRomano;

import java.sql.SQLOutput;

public class Application {

    public static void main(String[] args) {
        Videogioco videogioco1 = new Videogioco(1,"FIFA 25",2024, 59.88, "PS5", 7, Genere.SPORT);
        // Videogioco videogioco2 = new Videogioco(2,"Assassin's Creed Shadows | Limited Edition", 2025, 79.99, "XBOX Series X", 1800 /*1800=30 ore in minuti*/, Genere.AZIONE);
        // Videogioco videogioco3 = new Videogioco(3,"Guitar Hero 5",2010, 69.99, "PC", 1200, Genere.MUSICA);

        System.out.println("VIDEOGIOCO:  ");
        System.out.println("ID: " + videogioco1.getIdGioco());
        System.out.println("Titolo: " + videogioco1.getTitolo());
        System.out.println("Anno di pubblicazione: " + videogioco1.getAnnoPubblicazioneGioco());
        System.out.println("Durata media: " + videogioco1.getDurataInMinuti());
        System.out.println("Prezzo : " + videogioco1.getPrezzo() + " €");
        System.out.println("Genere: " + videogioco1.getGenere());

        System.out.println("--------------------------------------------------------------");

        GiocoDaTavolo giocoDaTavolo1 = new GiocoDaTavolo(1, "Monopoly Ultimate Banking", 2016, 82.37, 4, 20);
        System.out.println("GIOCO DA TAVOLO:");
        System.out.println("ID: " + giocoDaTavolo1.getIdGioco());
        System.out.println("Titolo: " + giocoDaTavolo1.getTitolo());
        System.out.println("Anno Pubblicazione: " + giocoDaTavolo1.getAnnoPubblicazioneGioco());
        System.out.println("Prezzo: " + giocoDaTavolo1.getPrezzo() + " €");
        System.out.println("Numero di Giocatori: " + giocoDaTavolo1.getNumeroGiocatori());
        System.out.println("Durata Media Partita: " + giocoDaTavolo1.getDurataInMinuti());



    }
}
