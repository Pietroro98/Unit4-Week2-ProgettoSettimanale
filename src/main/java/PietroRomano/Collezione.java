package PietroRomano;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        if (gioco == null) {
            System.out.println("! Nessun gioco trovato con questo id !");
            return null;
        }
        return gioco;
    }

    public List<Gioco> ricarcaGiocoPerPrezzo (double prezzoMax) {
        return collezione.values().stream().filter(gioco -> gioco.getPrezzo() <= prezzoMax).collect(Collectors.toList());
    }
}
