package ClassiQuarte.BI.Sportello290424.ParkingOnDemand;

import java.util.ArrayList;

public class Main {

    public static final int MAX_CAPACITY = 4;

    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = new ParkingLot(MAX_CAPACITY);

        final int NUM_THREADS = 10;
        ArrayList<Auto> autos = new ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {
            autos.add(new Auto("Auto#" + (i + 1), (int) (Math.random() * (MAX_CAPACITY - 1)) + 1, parkingLot));
        }

        for (int i = 0; i < autos.size(); i++) autos.get(i).start();
        for (int i = 0; i < autos.size(); i++) autos.get(i).join();
    }
}
