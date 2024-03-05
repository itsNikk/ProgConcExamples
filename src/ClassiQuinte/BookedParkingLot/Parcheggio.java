package ClassiQuinte.BookedParkingLot;

import java.util.Arrays;

public class Parcheggio {
    private int numeroPosti;
    private boolean[] posti;

    public Parcheggio(int numeroPosti) {
        this.numeroPosti = numeroPosti;
        this.posti = new boolean[numeroPosti];
        Arrays.fill(posti, true); // Tutti i posti sono inizialmente liberi
    }

    public Parcheggio() {
        this(5);
    }

    public synchronized void prenotaPosto(int posto) {
/*        if (posto < 0 || posto >= numeroPosti || !posti[posto]) {
            return false; // Il posto è già prenotato o non esiste
        }*/

        while (!posti[posto]) {
            try {
                wait(); // Aspetta finché il posto non è disponibile
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        posti[posto] = false;
        System.out.println(Thread.currentThread().getName() + " prenota posto: " + posto);
    }

    public synchronized void liberaPosto(int posto) {
        if (posto >= 0 && posto < numeroPosti) {
            posti[posto] = true;
            System.out.println(Thread.currentThread().getName() + " libera posto: " + posto);
            notifyAll(); // Notifica tutti gli automobilisti in attesa di un posto
        }
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }
}

