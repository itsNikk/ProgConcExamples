package ClassiQuinte.ConcEx3;

public class Main {

    private static final int NUM_CARS = 10;
    public static final int NUM_SLOTS = 5;

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(NUM_SLOTS);

        for (int i = 0; i < NUM_CARS; i++) new Car("Car" + (i + 1), parkingLot).start();
    }
}
