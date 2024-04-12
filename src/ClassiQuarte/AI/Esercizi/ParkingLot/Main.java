package ClassiQuarte.AI.Esercizi.ParkingLot;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int availableLots = 10;
        final int THREAD_NUM = 10;

        ParkingLot parkingLot = new ParkingLot(availableLots);
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < THREAD_NUM; i++) cars.add(new Car("Car" + (i + 1), parkingLot));

        for (Car car : cars) car.start();
        for (Car car : cars) car.join();

        System.out.println("Fine giornata :)");
    }
}
