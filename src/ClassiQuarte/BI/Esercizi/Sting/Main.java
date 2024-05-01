package ClassiQuarte.BI.Esercizi.Sting;


public class Main {
    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter(20);

        for (int i = 1; i <= 30; i++) {
            new Buyer("Buyer#" + (i + 1), ticketCounter).start();
        }
    }

}

