package ClassiQuarte.BI.Sportello290424.ParkingOnDemand;
public class ParkingLot {
    private final int maxCapacity;
    private boolean[] availableSlots;

    public ParkingLot(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        availableSlots = new boolean[maxCapacity];
        for (int i = 0; i < maxCapacity; i++) {
            availableSlots[i] = true;
        }
    }

    public synchronized void enterParking(Auto auto) throws InterruptedException {
        while (!availableSlots[auto.getDesiredLot()]) {
            System.out.println(auto.getName() + " aspetta che il parcheggio " + auto.getDesiredLot() + " si liberi");
            wait();
        }
        availableSlots[auto.getDesiredLot()] = false;
        System.out.println(auto.getName() + " entra nel parcheggio nello slot #" + auto.getDesiredLot());
    }

    public synchronized void exitParking(Auto auto) {

        availableSlots[auto.getDesiredLot()] = true;
        System.out.println(auto.getName() + " esce nel parcheggio nello slot #" + auto.getDesiredLot());
        notifyAll();
    }


}
