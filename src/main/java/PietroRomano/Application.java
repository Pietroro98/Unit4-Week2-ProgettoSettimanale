package PietroRomano;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        while (true) {

            mostraMenu();
            int scelta = ottieniSceltaUtente(scanner);
            eseguiOperazione(scelta, scanner, collezione);
        }
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

    private static void mostraMenu() {
        System.out.println("Scegli un'operazione:");
        System.out.println("1. Aggiungi gioco");
        System.out.println("2. Ricerca gioco per ID");
        System.out.println("3. Ricerca giochi per prezzo massimo");
        System.out.println("4. Ricerca giochi da tavolo per numero di giocatori");
        System.out.println("5. Rimuovi gioco per ID");
        System.out.println("6. Aggiorna gioco per ID");
        System.out.println("7. Stampa statistiche collezione");
        System.out.println("8. Esci");
    }

    private static int ottieniSceltaUtente(Scanner scanner) {
        int scelta = -1;
        try {
            scelta = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Inserimento non valido. Riprova.");
            scanner.nextLine();
        }
        return scelta;
    }

    private static void eseguiOperazione(int scelta, Scanner scanner, Collezione collezione) {
        switch (scelta) {
            case 1:
                aggiungiGioco(scanner, collezione);
                break;
            case 2:
                ricercaGiocoPerId(scanner, collezione);
                break;
            case 3:
                ricercaPerPrezzo(scanner, collezione);
                break;
            case 4:
                ricercaPerNumeroDIGiocatori(scanner, collezione);
                break;
            case 5:
                rimuoviGiocoDallaCollezione(scanner, collezione);
                break;
            case 6:
                aggiornaGioco(scanner, collezione);
                break;
            case 7:
                collezione.stampaStatistiche();
                break;
            case 8:
                System.out.println("Sei uscito con successo!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Scelta non valida. Riprova!");
                break;
        }
    }

    private static void aggiungiGioco(Scanner scanner, Collezione collezione) {
        System.out.println("Aggiungi un videogioco (1) o un gioco da tavolo (2)?");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.println("Inserisci l'ID, Titolo, Anno di Pubblicazione, Prezzo, Piattaforma, Durata in Minuti, Genere:");
            int id = scanner.nextInt();
            scanner.nextLine();
            String titolo = scanner.nextLine();
            int anno = scanner.nextInt();
            scanner.nextLine();
            double prezzo = scanner.nextDouble();
            scanner.nextLine();
            String piattaforma = scanner.nextLine();
            int durata = scanner.nextInt();
            scanner.nextLine();
            Genere genere = Genere.valueOf(scanner.nextLine().toUpperCase());

            Videogioco videogioco = new Videogioco(id, titolo, anno, prezzo, piattaforma, durata, genere);
            collezione.aggiungiElemento(videogioco);
            System.out.println("Videogioco aggiunto con successo!");
        } else if (tipo == 2) {
            System.out.println("Inserisci l'ID, Titolo, Anno di Pubblicazione, Prezzo, Numero di Giocatori, Durata in Minuti:");
            int id = scanner.nextInt();
            scanner.nextLine();
            String titolo = scanner.nextLine();
            int anno = scanner.nextInt();
            scanner.nextLine();
            double prezzo = scanner.nextDouble();
            scanner.nextLine();
            int numGiocatori = scanner.nextInt();
            scanner.nextLine();
            int durata = scanner.nextInt();
            scanner.nextLine();

            GiocoDaTavolo giocoDaTavolo = new GiocoDaTavolo(id, titolo, anno, prezzo, numGiocatori, durata);
            collezione.aggiungiElemento(giocoDaTavolo);
            System.out.println("Gioco da tavolo aggiunto con successo!");
        } else {
            System.out.println("Scelta non valida.");
        }

    }

    private static void ricercaGiocoPerId(Scanner scanner, Collezione collezione) {
        System.out.println("Inserisci l'ID del gioco da cercare:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Gioco gioco = collezione.ricercaGiocoPerId(id);
        if (gioco != null) {
            System.out.println("Gioco trovato: " + gioco.getTitolo() + " - " + gioco.getAnnoPubblicazioneGioco() +
                    " - " + gioco.getPrezzo() + " €");
        } else {
            System.out.println("Nessun gioco trovato con l'ID: " + id);
        }
    }

    private static void ricercaPerPrezzo(Scanner scanner, Collezione collezione) {
        System.out.println("Inserisci il prezzo massimo:");
        double prezzoMax = scanner.nextDouble();
        scanner.nextLine();
        List<Gioco> giochi = collezione.ricercaGiocoPerPrezzo(prezzoMax);
        for (Gioco gioco : giochi) {
            System.out.println(gioco.getTitolo() + " - " + gioco.getPrezzo() + " €");
        }
    }

    private static void ricercaPerNumeroDIGiocatori(Scanner scanner, Collezione collezione) {
        System.out.println("Inserisci il numero di giocatori:");
        int numGiocatori = scanner.nextInt();
        scanner.nextLine();
        List<GiocoDaTavolo> giochi = collezione.ricercaPerNumeroGiocatori(numGiocatori);
        for (GiocoDaTavolo gioco : giochi) {
            System.out.println(gioco.getTitolo() + " - " + gioco.getNumeroGiocatori() + " giocatori");
        }
    }

    private static void rimuoviGiocoDallaCollezione(Scanner scanner, Collezione collezione) {
        System.out.println("Inserisci l'ID del gioco da rimuovere:");
        int id = scanner.nextInt();
        scanner.nextLine();
        collezione.rimuoviElemento(id);
        System.out.println("Gioco con id: " + id + " rimosso con successo!");
    }

//    private static void aggiornaGioco(Scanner scanner, Collezione collezione) {
//        System.out.println("Aggiorna un videogioco (1) o un gioco da tavolo (2)?");
//        int tipo = scanner.nextInt();
//        scanner.nextLine();
//        if (tipo == 1) {
//            System.out.println("Inserisci l'ID, Titolo, Anno di Pubblicazione, Prezzo, Piattaforma, Durata in Minuti, Genere:");
//            int id = scanner.nextInt(); scanner.nextLine();
//            String titolo = scanner.nextLine();
//            int anno = scanner.nextInt(); scanner.nextLine();
//            double prezzo = scanner.nextDouble(); scanner.nextLine();
//            String piattaforma = scanner.nextLine();
//            int durata = scanner.nextInt(); scanner.nextLine();
//            Genere genere = Genere.valueOf(scanner.nextLine().toUpperCase());
//
//            Videogioco videogioco = new Videogioco(id, titolo, anno, prezzo, piattaforma, durata, genere);
//            collezione.aggiornaElemento(videogioco);
//            System.out.println("Videogioco aggiornato con successo!");
//        } else if (tipo == 2) {
//            System.out.println("Inserisci l'ID, Titolo, Anno di Pubblicazione, Prezzo, Numero di Giocatori, Durata in Minuti:");
//            int id = scanner.nextInt(); scanner.nextLine();
//            String titolo = scanner.nextLine();
//            int anno = scanner.nextInt(); scanner.nextLine();
//            double prezzo = scanner.nextDouble(); scanner.nextLine();
//            int numGiocatori = scanner.nextInt(); scanner.nextLine();
//            int durata = scanner.nextInt(); scanner.nextLine();
//
//            GiocoDaTavolo giocoDaTavolo = new GiocoDaTavolo(id, titolo, anno, prezzo, numGiocatori, durata);
//            collezione.aggiornaElemento(giocoDaTavolo);
//            System.out.println("Gioco da tavolo aggiornato con successo!");
//        } else {
//            System.out.println("Scelta non valida.");
//        }
//    }

    private static void aggiornaGioco(Scanner scanner, Collezione collezione) {
        System.out.println("Aggiorna un videogioco (1) o un gioco da tavolo (2)?");
        while (true) {
            try {
                int tipo = scanner.nextInt();
                scanner.nextLine();

                if (tipo == 1) {

                    System.out.println("Inserisci l'ID, Titolo, Anno di Pubblicazione, Prezzo, Piattaforma, Durata in Minuti, Genere:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    String titolo = scanner.nextLine();
                    int anno = scanner.nextInt();
                    scanner.nextLine();
                    double prezzo = scanner.nextDouble();
                    scanner.nextLine();
                    String piattaforma = scanner.nextLine();
                    int durata = scanner.nextInt();
                    scanner.nextLine();
                    String genereInput = scanner.nextLine().toUpperCase();
                    Genere genere = Genere.valueOf(genereInput);

                    Videogioco videogioco = new Videogioco(id, titolo, anno, prezzo, piattaforma, durata, genere);

                    collezione.aggiornaElemento(videogioco);
                    System.out.println("Videogioco aggiornato con successo!");
                    break;

                } else if (tipo == 2) {

                    System.out.println("Inserisci l'ID, Titolo, Anno di Pubblicazione, Prezzo, Numero di Giocatori, Durata in Minuti:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    String titolo = scanner.nextLine();
                    int anno = scanner.nextInt();
                    scanner.nextLine();
                    double prezzo = scanner.nextDouble();
                    scanner.nextLine();
                    int numGiocatori = scanner.nextInt();
                    scanner.nextLine();
                    int durata = scanner.nextInt();
                    scanner.nextLine();

                    GiocoDaTavolo giocoDaTavolo = new GiocoDaTavolo(id, titolo, anno, prezzo, numGiocatori, durata);

                    collezione.aggiornaElemento(giocoDaTavolo);
                    System.out.println("Gioco da tavolo aggiornato con successo!");
                    break;

                } else {
                    System.out.println("Scelta non valida. Inserisci 1 o 2.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Errore: Inserisci un numero valido (1 o 2).");
                scanner.nextLine();
            }
        }
    }

}