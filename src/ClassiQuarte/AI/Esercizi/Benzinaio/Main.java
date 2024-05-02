package ClassiQuarte.AI.Esercizi.Benzinaio;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int NUMERO_POMPE = 5;
        final int NUMERO_VEICOLI = NUMERO_POMPE * 2;

        StazioneBenzina stazioneBenzina = new StazioneBenzina(NUMERO_POMPE);

        ArrayList<Veicolo> veicoli = new ArrayList<>();
        for (int i = 0; i < NUMERO_VEICOLI; i++) {
            veicoli.add(new Veicolo("Veicolo#" + (i + 1), stazioneBenzina));
        }

        for (Veicolo veicolo : veicoli) {
            veicolo.start();
        }

        for (Veicolo veicolo : veicoli) {
            veicolo.join();
        }

        System.out.println("Stazione benzina chiude");
    }
}
