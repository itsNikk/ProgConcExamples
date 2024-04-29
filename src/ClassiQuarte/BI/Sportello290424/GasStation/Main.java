package ClassiQuarte.BI.Sportello290424.GasStation;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GasStation gasStation = new GasStation(5);
        final int NUM_THREADS = 20;
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < NUM_THREADS; i++) {
            vehicles.add(new Vehicle("Vehicle#" + (i + 1), gasStation));
        }

        for (int i = 0; i < vehicles.size(); i++) {
            vehicles.get(i).start();
        }
        for (int i = 0; i < vehicles.size(); i++) {
            vehicles.get(i).join();
        }


        System.out.println("Bnezinaio chiude.");
    }
}
