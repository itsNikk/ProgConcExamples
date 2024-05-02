package ClassiQuarte.AI.Esercizi.Benzinaio;


import java.util.ArrayList;

public class StazioneBenzina {
    private int numeroPompe;
    private ArrayList<PompaBenzina> pompe;

    public StazioneBenzina(int numeroPompe) {
        this.numeroPompe = numeroPompe;
        pompe = new ArrayList<>();
        FillPompe();
    }

    public synchronized void getPump(Veicolo veicolo) throws InterruptedException {
        while (AreAllPumpsBusy()) wait();

        PompaBenzina primaLibera = TrovaPrimaPompaDisponibile();
        primaLibera.setAvailable(false);

        //Assegna a veicolo la prima pompa libera
        veicolo.setPompaAssegnata(primaLibera);
        System.out.println(veicolo.getName() + " riceve la pompa numero " + primaLibera.getCodice());

    }

    public synchronized void releasePump(Veicolo veicolo) {
        veicolo.getPompaAssegnata().setAvailable(true);
        System.out.println(veicolo.getName() + " rilascia la pompa numero " + veicolo.getPompaAssegnata().getCodice());
        notifyAll();
    }

    private PompaBenzina TrovaPrimaPompaDisponibile() {
        for (PompaBenzina pompaBenzina : pompe) {
            if (pompaBenzina.isAvailable()) return pompaBenzina;
        }
        //attenzione: necessario ma pericolos...
        return null;
    }

    private boolean AreAllPumpsBusy() {
        for (PompaBenzina pompaBenzina : pompe) {
            if (pompaBenzina.isAvailable()) return false;
        }
        return true;
    }

    public void FillPompe() {
        for (int i = 0; i < numeroPompe; i++) {
            pompe.add(new PompaBenzina(i + 1));
        }
    }
}
