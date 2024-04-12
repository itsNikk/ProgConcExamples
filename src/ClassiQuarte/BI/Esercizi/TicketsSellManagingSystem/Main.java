package ClassiQuarte.BI.Esercizi.TicketsSellManagingSystem;

import java.util.ArrayList;

public class Main {

    // Non ho gestito InterruptedException in questo file per questioni di leggibilità.
    public static void main(String[] args) throws InterruptedException {
        final int THREAD_NUMBER = 20;
        TicketManager ticketManager = new TicketManager(10);
        ArrayList<Utente> utenti = new ArrayList<>();

        for (int i = 0; i < THREAD_NUMBER; i++) utenti.add(new Utente("Utente " + (i + 1), ticketManager));

        for (Utente utente : utenti) utente.start();
        for (Utente utente : utenti) utente.join();

        System.out.println("Main chiude");
    }
}
