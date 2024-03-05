package ClassiQuinte.ConcEx3;

/**
 * @author iTzNikk
 * This class is the MONITOR class of the exercise.
 * To manage the slots I just used an int variable because, to me, it's the easiest way to shape the concept of
 * "Having a certain number of slots". I am not really interested, for now, in managing the real car objects inside the lot.
 */
public class ParkingLot {

    private int slots;

    public ParkingLot(int slots) {
        this.slots = slots;
    }

    /**
     * This method manages the entering action of a car.
     * If the parking lot does NOT have any slot left, it will put the car in wait state,
     * Otherwise it'll reduce the available slots number by one.
     * @throws InterruptedException
     */
    public synchronized void enter() throws InterruptedException {
        while (slots == 0) wait();
        slots--;
    }

    /**
     * This is really <em>the inverse function</em> of the method enter().
     * It'll add one free slots and wake all the waiting threads.
     */
    public synchronized void exit() {
        slots++;
        notifyAll();
    }

    public synchronized int getAvailableSlots() {
        return slots;
    }
}
