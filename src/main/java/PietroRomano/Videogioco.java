package PietroRomano;

public class Videogioco extends Gioco{
    private String piattaforma;
    private int durataGioco;
    private Genere genere;

    public Videogioco(int idGioco, String titolo, int annoPubblicazioneGioco, double prezzo, String piattaforma, int durataGioco, Genere genere) {
        super(idGioco, titolo, annoPubblicazioneGioco, prezzo);
        this.piattaforma = piattaforma;
        this.durataGioco = durataGioco;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public int getDurataGioco() {
        return durataGioco;
    }

    public void setDurataGioco(int durataGioco) {
        this.durataGioco = durataGioco;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public String getDurataInMinuti() {
        return durataGioco + " minuti";
    }

    @Override
    public String toString() {
        return "Videogioco{" +
                "piattaforma='" + piattaforma + '\'' +
                ", durataGioco=" + durataGioco +
                ", genere=" + genere +
                '}';
    }
}
