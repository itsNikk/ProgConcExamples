package ClassiQuarte.AI.Esercizi.TheBouncer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bouncer bouncer = new Bouncer(5);
        ArrayList<Utente> utenti = new ArrayList<>();

        for (int i = 0; i < 10; i++) utenti.add(new Utente("Utente#" + (i + 1), 12, bouncer));

        for (Utente utente : utenti) utente.start();
        for (Utente utente : utenti) utente.join();

        System.out.println("Il locale chiude.");
    }
}
