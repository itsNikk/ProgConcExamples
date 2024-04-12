package ClassiQuarte.BI.Esercizi.TicketsSellManagingSystem;

public class Utente extends Thread {

    private final TicketManager ticketManager;

    public Utente(String name, TicketManager ticketManager) {
        super(name);
        this.ticketManager = ticketManager;
    }

    @Override
    public void run() {
        try {
            ticketManager.acquistaBiglietto();
            sleep(5);
        } catch (InterruptedException e) {
            System.out.println(getName() + " non può acquistare un biglietto");
        }
    }
}
