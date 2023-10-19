package ProdConsWithCustomQueue;

import java.util.ArrayList;

public class Queue {
    private final ArrayList<String> buffer = new ArrayList<>();

    public synchronized void put(String elem) {
        //Add here synchronization if we wanted to also control the producer ;)
        buffer.add(elem);
        notify();
    }

    public synchronized String get() throws InterruptedException {
        String res;
        while (buffer.isEmpty()) wait();
        res = buffer.get(0);
        buffer.remove(0);
        return res;
    }
}
