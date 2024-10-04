package PietroRomano;

public class Gioco {
   private int idGioco;
   private String titolo;
   private int annoPubblicazioneGioco;
   private double prezzo;

    public Gioco(int idGioco, String titolo, int annoPubblicazioneGioco, double prezzo) {
        this.idGioco = idGioco;
        this.titolo = titolo;
        this.annoPubblicazioneGioco = annoPubblicazioneGioco;
        this.prezzo = prezzo;
    }

    public int getIdGioco() {
        return idGioco;
    }

    public void setIdGioco(int idGioco) {
        this.idGioco = idGioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazioneGioco() {
        return annoPubblicazioneGioco;
    }


    public void setAnnoPubblicazioneGioco(int annoPubblicazioneGioco) {
        this.annoPubblicazioneGioco = annoPubblicazioneGioco;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Gioco{" +
                "idGioco=" + idGioco +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazioneGioco=" + annoPubblicazioneGioco +
                ", prezzo=" + prezzo +
                '}';
    }
}
