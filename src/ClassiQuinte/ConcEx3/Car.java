package ClassiQuinte.ConcEx3;

import java.util.Random;

public class Car extends Thread {
    private final ParkingLot parkingLot;
    private final Random random;

    public Car(String s, ParkingLot parkingLot) {
        super(s);
        this.parkingLot = parkingLot;
        random = new Random();
    }

    @Override
    public void run() {
        try {
            //the car drives for some time...
            drive(500, 1000);
            //then, the car attempt to enter the parking lot...
            enterParkingLot();
            //if ti succeed, it'll stay inside the parking lot for some time...
            stayInParkingLot(2000, 4000);
            //and finally, it'll leave the parking lot.
            exitParkingLot();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is a wrapper for the <code>ParkingLot.java</code> method that manages
     * the exit action of the car from the PL.
     */
    private void exitParkingLot() {
        parkingLot.exit();
        System.out.println(getName() + ": exited. Free Slots:" + parkingLot.getAvailableSlots());
    }

    /**
     * This method is just a wrapper to simulate the car staying in the parking lot for while.
     * @param minParkingTimeInMillis the minimum time the car will stay in the parkinglot
     * @param maxParkingTimeInMillis the maximum time the car will stay in the parkinglot
     * @throws InterruptedException
     */
    private void stayInParkingLot(int minParkingTimeInMillis, int maxParkingTimeInMillis) throws InterruptedException {
        sleep(minParkingTimeInMillis + random.nextInt(maxParkingTimeInMillis));
    }

    /**
     * This method simulates the car trying to enter the parking lot.
     * The actual logic is managed in <code>ParkingLot.java</code>
     * @throws InterruptedException
     */
    private void enterParkingLot() throws InterruptedException {
        parkingLot.enter();
        System.out.println(getName() + ": entered. Free Slots:" + parkingLot.getAvailableSlots());
    }

    /**
     * This method is just a wrapper to simulate the car driving state.
     * @param minDriveTimeInMillis the min time the car will 'drive'
     * @param maxDriveTimeInMillis the max time the car will 'drive'
     * @throws InterruptedException
     */
    private void drive(int minDriveTimeInMillis, int maxDriveTimeInMillis) throws InterruptedException {
        sleep(minDriveTimeInMillis + random.nextInt(maxDriveTimeInMillis));
    }
}
