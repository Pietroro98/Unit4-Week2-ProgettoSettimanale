package PietroRomano;

public class GiocoDaTavolo extends Gioco {
    private int numeroGiocatori;
    private int durataMediaPartita;

    public GiocoDaTavolo(int idGioco, String titolo, int annoPubblicazioneGioco, double prezzo, int numeroGiocatori, int durataMediaPartita) {
        super(idGioco, titolo, annoPubblicazioneGioco, prezzo);
        this.numeroGiocatori = numeroGiocatori;
        this.durataMediaPartita = durataMediaPartita;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public void setNumeroGiocatori(int numeroGiocatori) {
        this.numeroGiocatori = numeroGiocatori;
    }

    public int getDurataMediaPartita() {
        return durataMediaPartita;
    }

    public void setDurataMediaPartita(int durataMediaPartita) {
        this.durataMediaPartita = durataMediaPartita;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "numeroGiocatori=" + numeroGiocatori +
                ", durataMediaPartita=" + durataMediaPartita +
                '}';
    }
}