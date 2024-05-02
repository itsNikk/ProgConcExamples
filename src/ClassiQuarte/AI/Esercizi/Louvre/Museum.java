package ClassiQuarte.AI.Esercizi.Louvre;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.security.PublicKey;

public class Museum {
    private int peopleInside;
    private final int MUSEUM_CAPACITY = 5;

    public Museum() {
        this.peopleInside = 0;
    }

    public synchronized void enterMuseum(Tourist tourist) throws InterruptedException {
        //Quando blocco?
        while (peopleInside == MUSEUM_CAPACITY) wait();

        peopleInside++;
        System.out.println(tourist.getName() + " entra nel museo. Persone all'interno: " + peopleInside);
    }

    public synchronized void exitMuseum(Tourist tourist) {
        peopleInside--;
        System.out.println(tourist.getName() + " esce nel museo. Persone all'interno: " + peopleInside);
        notifyAll();
    }
}
