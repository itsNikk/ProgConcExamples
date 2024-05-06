package ClassiQuarte.BI.Esercizi.ProdConsIspettore;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Magazzino magazzino = new Magazzino(5);
        final int NUM_PROD = 2;

        ArrayList<Producer> producers = new ArrayList<>();
        for (int i = 0; i < NUM_PROD; i++) {
            producers.add(new Producer(magazzino));
        }

        Ispettore isp = new Ispettore(magazzino);
        isp.start();

        for (int i = 0; i < producers.size(); i++) {
            producers.get(i).start();
        }

    }
}
