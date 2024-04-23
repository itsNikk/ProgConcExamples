package ClassiQuarte.AI.Esercizi.TheBouncer;

public class Bouncer {
    private int capacitaMassima;
    private int personeInterno;

    public Bouncer(int capacitaMassima) {
        this.personeInterno = 0;
        this.capacitaMassima = capacitaMassima;
    }

    public synchronized void enterUser(int eta) throws InterruptedException {
        // interrompi il thread che ha chiamato questo metodo
        if (eta < 18) Thread.currentThread().interrupt();

        while (personeInterno >= capacitaMassima) wait();

        personeInterno++;
        System.out.println(Thread.currentThread().getName() + " entra nel locale. Persone all'interno: " + personeInterno);
    }

    public synchronized void exitUser() {
        personeInterno--;
        System.out.println(Thread.currentThread().getName() + " esce nel locale. Persone all'interno: " + personeInterno);
        notifyAll();
    }
}
