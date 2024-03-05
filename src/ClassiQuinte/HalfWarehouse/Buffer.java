package ClassiQuinte.HalfWarehouse;

import java.util.ArrayList;

public class Buffer {
    private final ArrayList<Integer> buffer = new ArrayList<>();
    private final int capacity;
    private boolean producersCanProduce = true;
    private boolean consumersCanConsume = false;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    public Buffer() {
        this(5);
    }

    public synchronized void produce(int item) {
        while (!producersCanProduce) {
            try {
                wait(); // I produttori attendono se non possono produrre
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        buffer.add(item);
        System.out.println(Thread.currentThread().getName() + " ha prodotto: " + item);
        consumersCanConsume = true;
        if (buffer.size() >= capacity / 2) producersCanProduce = false;
        notifyAll();
    }

    public synchronized int consume() {
        while (!consumersCanConsume) {
            try {
                wait(); // I consumatori attendono se non possono consumare
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        int item = buffer.get(buffer.size() - 1);
        buffer.remove(buffer.size() - 1);
        System.out.println(Thread.currentThread().getName() + " ha consumato: " + item);
        producersCanProduce = true;
        if (buffer.isEmpty()) consumersCanConsume = false;
        notifyAll();
        return item;
    }

    public int getBufferSize() {
        return buffer.size();
    }
}
