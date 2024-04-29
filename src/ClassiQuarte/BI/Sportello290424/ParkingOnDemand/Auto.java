package ClassiQuarte.BI.Sportello290424.ParkingOnDemand;

public class Auto extends Thread {
    private int desiredLot;

    private final ParkingLot parkingLot;

    public Auto(String name, int desiredLot, ParkingLot parkingLot) {
        super(name);
        this.desiredLot = desiredLot;
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        try {
            int driveTime = (int) (Math.random() * (2000 - 1000)) + 1000;
            int parkingTime = (int) (Math.random() * (1500 - 500)) + 500;
            sleep(driveTime);
            parkingLot.enterParking(this);
            sleep(parkingTime);
            parkingLot.exitParking(this);
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto");
        }
    }

    public int getDesiredLot() {
        return desiredLot;
    }

    public void setDesiredLot(int desiredLot) {
        this.desiredLot = desiredLot;
    }
}
