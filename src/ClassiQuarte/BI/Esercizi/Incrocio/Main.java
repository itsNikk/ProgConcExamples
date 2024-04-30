package ClassiQuarte.BI.Esercizi.Incrocio;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Incrocio incrocio = new Incrocio();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) threads.add(new AutoVert(incrocio));

        // leggesi 'per ogni thread in threads esegui .start()'
        for (Thread thread : threads) thread.start();

    }
}
