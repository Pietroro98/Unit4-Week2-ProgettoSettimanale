package PietroRomano;




public class Application {

    public static void main(String[] args) {


        System.out.println("--------------------------------------------------------------");

        Videogioco videogioco1 = new Videogioco(1, "FIFA 25", 2024, 59.88, "PS5", 7, Genere.SPORT);
        Videogioco videogioco2 = new Videogioco(2, "Assassin's Creed Shadows | Limited Edition", 2025, 79.99, "XBOX Series X", 1800, Genere.AZIONE);
        Videogioco videogioco3 = new Videogioco(3, "Guitar Hero 5", 2010, 69.99, "PC", 1200, Genere.MUSICA);

        GiocoDaTavolo giocoDaTavolo1 = new GiocoDaTavolo(4, "Monopoly Ultimate Banking", 2016, 82.37, 4, 20);
        GiocoDaTavolo giocoDaTavolo2 = new GiocoDaTavolo(5, "RISIKO", 2017, 35.79, 6, 480);
        GiocoDaTavolo giocoDaTavolo3 = new GiocoDaTavolo(6, "Gioco dell'oca", 2023, 7.99, 6, 50);


        Collezione collezione = new Collezione();
        collezione.aggiungiElemento(videogioco1);
        collezione.aggiungiElemento(videogioco2);
        collezione.aggiungiElemento(videogioco3);
        collezione.aggiungiElemento(giocoDaTavolo1);
        collezione.aggiungiElemento(giocoDaTavolo2);
        collezione.aggiungiElemento(giocoDaTavolo3);


        System.out.println("VIDEOGIOCHI: ");
        stampaDettagliGioco(videogioco1);
        stampaDettagliGioco(videogioco2);
        stampaDettagliGioco(videogioco3);

        System.out.println("--------------------------------------------------------------");
        System.out.println("GIOCHI DA TAVOLO:");
        stampaDettagliGioco(giocoDaTavolo1);
        stampaDettagliGioco(giocoDaTavolo2);
        stampaDettagliGioco(giocoDaTavolo3);

        System.out.println("--------------------------------------------------------------");

    }
    private static void stampaDettagliGioco (Gioco gioco){
        System.out.println("ID: " + gioco.getIdGioco());
        System.out.println("Titolo: " + gioco.getTitolo());
        System.out.println("Anno di pubblicazione: " + gioco.getAnnoPubblicazioneGioco());
        System.out.println("Prezzo : " + gioco.getPrezzo() + " €");

        if (gioco instanceof Videogioco videogioco) {
            System.out.println("Piattaforma: " + videogioco.getPiattaforma());
            System.out.println("Durata media: " + videogioco.getDurataInMinuti());
            System.out.println("Genere: " + videogioco.getGenere());
        } else {
            GiocoDaTavolo g = (GiocoDaTavolo) gioco;
            System.out.println("Numero di Giocatori: " + g.getNumeroGiocatori());
            System.out.println("Durata Media Partita: " + g.getDurataInMinuti());
        }
        System.out.println("--------------------------------------------------------------");
    }
}