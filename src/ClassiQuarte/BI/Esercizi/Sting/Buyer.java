package ClassiQuarte.BI.Esercizi.Sting;


import java.util.Random;

public class Buyer extends Thread {
    private final Random random;
    private final TicketCounter ticketCounter;

    public Buyer(String name, TicketCounter ticketCounter) {
        super(name);
        this.ticketCounter = ticketCounter;
        random = new Random();
    }

    @Override
    public void run() {
        try {
            sleep(random.nextInt(3000));
            ticketCounter.arriveAtCounter(this);
            sleep(random.nextInt(5));
            ticketCounter.leaveCounter();
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto. Non ci sono più biglietti.");
        }
    }
}
