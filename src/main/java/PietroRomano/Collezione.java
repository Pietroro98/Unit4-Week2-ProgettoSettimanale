package PietroRomano;

import java.util.*;
import java.util.stream.Collectors;

public class Collezione {
    private Map<Integer, Gioco> collezione;

    public Collezione() {
        this.collezione = new HashMap<>();
    }

    public void aggiungiElemento(Gioco gioco) {
        if (collezione.containsKey(gioco.getIdGioco())) {
            System.out.println("! Esiste giá un gioco con questo id nella tua collezione !");
        }
        this.collezione.put(gioco.getIdGioco(), gioco);
    }

    public Gioco ricercaGiocoPerId(int id) {
        Gioco gioco = this.collezione.get(id);
        if (!collezione.containsKey(id)) {
            System.out.println("! Nessun gioco trovato con l'ID: " + id);
        }
        return collezione.get(id);
    }

    public List<Gioco> ricercaGiocoPerPrezzo (double prezzoMax) {
        return collezione.values().stream().filter(gioco -> gioco.getPrezzo() <= prezzoMax).collect(Collectors.toList());
    }

    public List<GiocoDaTavolo> ricercaPerNumeroGiocatori(int numeroGiocatori) {
        return collezione.values().stream().filter(gioco -> gioco instanceof GiocoDaTavolo)
                .map(gioco ->(GiocoDaTavolo)gioco).filter(gioco -> gioco.getNumeroGiocatori() <= numeroGiocatori)
                .collect(Collectors.toList()) ;
    }

    public void rimuoviElemento(int id) {
        if (!collezione.containsKey(id)) {
            System.out.println("! Nessun gioco puó essere rimosso con questo id !");
            return;
        }
        collezione.remove(id);
    }

    public void aggiornaElemento(Gioco gioco) {
        if (!collezione.containsKey(gioco.getIdGioco())) {
            System.out.println("Errore: Nessun gioco trovato con l'ID specificato.");
            return;
        }
        collezione.put(gioco.getIdGioco(), gioco);
    }

    public void stampaStatistiche() {
        long numeroVideogiochi = collezione.values().stream().filter(gioco -> gioco instanceof Videogioco).count();
        long numeroGiochiDaTavolo = collezione.values().stream().filter(gioco -> gioco instanceof GiocoDaTavolo).count();
        OptionalDouble mediaPrezzi = collezione.values().stream().mapToDouble(Gioco::getPrezzo).average();
        Optional<Gioco> giocoPrezzoMax = collezione.values().stream().max(Comparator.comparingDouble(Gioco::getPrezzo));

        System.out.println("Numero totale di videogiochi: " + numeroVideogiochi);
        System.out.println("Numero totale di giochi da tavolo: " + numeroGiochiDaTavolo);

        if (giocoPrezzoMax.isPresent()) {
            Gioco giocoPrezzoMassimo = giocoPrezzoMax.get();
            System.out.println("Gioco con il prezzo piú alto: " + giocoPrezzoMassimo.getTitolo() +
                    " - " + giocoPrezzoMassimo.getPrezzo() + " €");
        } else {
            System.out.println("Media dei prezzi di tutti i giocatori: " + mediaPrezzi + " €");
        }

    }
}
