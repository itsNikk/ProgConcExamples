package ClassiQuarte.AI.Esercizi.StazioneAlternativeVersion;

public class Stazione {
    private String name;
    private Binario[] binari;

    public Stazione(String name, Binario[] binari) {
        this.name = name;
        this.binari = binari;
    }

    public Stazione(String name, int numeroBinari) {
        //TODO: creare i binari dentro questo costruttoere
    }

    public synchronized Binario arrivaTreno() throws InterruptedException {
        // se tutti i binari sono occcupati -> wait()
        while (TuttiIBinariOccupati()) wait();

        //trova il primo binario libero e dallo al Thread che sta cercando di entrare in stazione
        Binario binarioAssegnato = TrovaPrimoBinarioLibero();
        if (binarioAssegnato != null) binarioAssegnato.setOccupato(true);

        return binarioAssegnato;
    }

    public synchronized void parteTreno(Binario binario) {
        //supponiamo di avere già liberato il binario giusto
        binario.setOccupato(false);
        notifyAll();
    }

    private Binario TrovaPrimoBinarioLibero() {
        for (Binario binario : binari) {
            if (!binario.isOccupato()) return binario;
        }
        return null;
    }

    private boolean TuttiIBinariOccupati() {
        for (Binario b : binari) {
            if (!b.isOccupato()) return false;
        }
        return true;
    }

}
