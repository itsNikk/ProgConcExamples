package ClassiQuarte.AI.Esercizi.Benzinaio;

public class PompaBenzina {
    private int codice;
    private boolean isAvailable;

    public PompaBenzina(int codice) {
        this.codice = codice;
        this.isAvailable = true;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
