package ClassiQuarte.BI.Esercizi.ParcheggioOnDemand;

import java.util.ArrayList;

public class ParcheggioOnDemand {
    private ArrayList<Slot> slots;
    private int numSlots;

    public ParcheggioOnDemand(int numSlots) {
        this.slots = new ArrayList<>();
        this.numSlots = numSlots;
        FillSlots();
    }

    public synchronized void enterParkingLot(int desiderLot) throws InterruptedException {
        while (!slots.get(desiderLot).isAvailable()) {
            System.out.println(Thread.currentThread().getName() + " aspetta che si liberi il posto: " + desiderLot);
            wait();
        }

        slots.get(desiderLot).setAvailable(false);
        System.out.println(Thread.currentThread().getName() + " ottiene il posto: " + desiderLot);
        //sleep()
    }

    public synchronized void exitParkingLot(int slotToRelease) {
        slots.get(slotToRelease).setAvailable(true);
        System.out.println(Thread.currentThread().getName() + " libera il posto: " + slotToRelease);
        notifyAll();
    }

    private void FillSlots() {
        for (int i = 0; i < numSlots; i++) {
            slots.add(new Slot(i));
        }
    }
}
