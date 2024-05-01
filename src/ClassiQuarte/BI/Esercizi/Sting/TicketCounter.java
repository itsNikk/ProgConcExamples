package ClassiQuarte.BI.Esercizi.Sting;

public class TicketCounter {
    private int availableTickets;
    private int buyersAtCounter = 0;

    public TicketCounter(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public synchronized void arriveAtCounter(Buyer buyer) throws InterruptedException {

        if (availableTickets <= 0) buyer.interrupt();

        while (buyersAtCounter >= 5) {
            System.out.println(buyer.getName() + " attende perchè c'è troppa gente al baracchino. Clienti: " + buyersAtCounter);
            wait();
        }
        buyersAtCounter++;
        if (availableTickets > 0) {
            availableTickets--;
            System.out.println(buyer.getName() + " got a ticket. Remaining tickets: " + availableTickets);
        } else buyer.interrupt();
    }

    public synchronized void leaveCounter() {
        buyersAtCounter--;
        notify();
    }
}
