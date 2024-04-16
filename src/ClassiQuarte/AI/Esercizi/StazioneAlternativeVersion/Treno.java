package ClassiQuarte.AI.Esercizi.StazioneAlternativeVersion;

public class Treno extends Thread {

    private int codiceTreno;
    private Stazione stazione;

    public Treno(int codiceTreno, Stazione stazioneDiDestinazione) {
        //super(String) = setName(String)
        super("Treno" + codiceTreno);
        this.codiceTreno = codiceTreno;
        this.stazione = stazioneDiDestinazione;
    }

    @Override
    public void run() {
        //1) Guida verso la stazione
        int tempoViaggio = (int) (Math.random() * 5000) + 1500;
        int tempoAttesa = (int) (Math.random() * 5000) + 1000;

        try {
            System.out.println(getName() + " in viaggio verso stazione. " +
                    "Tempo di viaggio " + tempoViaggio / 1000 + "secondi");
            sleep(tempoViaggio);
            Binario binarioAssegnato = stazione.arrivaTreno();
            //Se prendo un binario, ci sto per un po'
            System.out.println(getName() + " prende il binario " + binarioAssegnato.getNumeroBinario());
            sleep(tempoAttesa);
            stazione.parteTreno(binarioAssegnato);
            System.out.println(getName() + " libera il binario " + binarioAssegnato.getNumeroBinario());
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto.");
        }

    }
}
