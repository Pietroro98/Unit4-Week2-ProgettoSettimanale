package PietroRomano;

import java.util.HashMap;
import java.util.Map;

public class Collezione {
    private Map<Integer, Gioco> collezione;

    public Collezione() {
        this.collezione = new HashMap<>();
    }

    public void aggiungiElemento(Gioco gioco) {
        this.collezione.put(gioco.getIdGioco(), gioco);
    }
}
