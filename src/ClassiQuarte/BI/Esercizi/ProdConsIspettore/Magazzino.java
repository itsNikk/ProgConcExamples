package ClassiQuarte.BI.Esercizi.ProdConsIspettore;

import java.util.ArrayList;

public class Magazzino {
    private final int maxCapacity;
    private ArrayList<Integer> merci;

    private boolean ispettoreInside;

    private final int SOGLIA = 4;

    public Magazzino(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.merci = new ArrayList<>();
    }

    public synchronized void AddMerce(int merce) throws InterruptedException {
        //quando si ferma un produttore?
        while (ispettoreInside) wait();
        while (merci.size() >= maxCapacity) wait();

        merci.add(merce);
        System.out.println(Thread.currentThread().getName() + " aggiunge: " + merce);
        notifyAll();
    }

    public synchronized void enterIspettore() {
        ispettoreInside = true;
        System.out.println("Ispettore all'interno");

        int sum = 0;
        for (int i = 0; i < merci.size(); i++) {
            sum += merci.get(i);
        }

        if (sum >= SOGLIA) {
            System.out.println("Ma che bel magazzino. Somma: " + sum);
            merci.clear();
        }

        ispettoreInside = false;
        System.out.println("Ispettore esce");
        notifyAll();
    }
}
