package ClassiQuarte.BI.Esercizi.ParcheggioOnDemand;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ParcheggioOnDemand p = new ParcheggioOnDemand(5);

        final int NUM_THREADS = 6;
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {
            cars.add(new Car("Auto#" + (i + 1), p));
        }

        // faccio partire tutti i thread
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).start();
        }

    }
}
