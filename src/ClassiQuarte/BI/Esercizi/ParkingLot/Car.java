package ClassiQuarte.BI.Esercizi.ParkingLot;

import java.util.Random;

public class Car extends Thread {

    private final ParkingLot parkingLot;
    private Random random;

    public Car(String name, ParkingLot parkingLot) {
        super(name);
        this.parkingLot = parkingLot;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            int driveTime = random.nextInt(2, 5);
            int parkingTime = random.nextInt(2, 8);
            System.out.println(getName() + " guida per " + driveTime + " secondi");
            sleep((long) driveTime * 1000);
            parkingLot.enterLot();
            sleep((long) parkingTime * 1000);
            parkingLot.exitLot();
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto");
        }
    }
}
