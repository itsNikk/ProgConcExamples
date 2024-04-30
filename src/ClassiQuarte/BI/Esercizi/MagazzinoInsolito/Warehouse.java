package ClassiQuarte.BI.Esercizi.MagazzinoInsolito;

import com.sun.jdi.event.MonitorWaitedEvent;

import java.util.ArrayList;
import java.util.Queue;

public class Warehouse {

    private ArrayList<Integer> goodsInside;
    private final int maxCapacity;

    public Warehouse(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        goodsInside = new ArrayList<>();
    }

    // per i Suppliers
    public synchronized void supplyGoods(int item) throws InterruptedException {
        while (goodsInside.size() >= maxCapacity / 2) wait();

        goodsInside.add(item);
        System.out.println("Un fornitore ha inserito " + item);
        notifyAll();
    }

    //Per i clients
    public synchronized int getGoods() throws InterruptedException {
        while (goodsInside.isEmpty()) wait();

        int value = goodsInside.get(goodsInside.size() - 1);
        goodsInside.remove(goodsInside.size() - 1);
        System.out.println(Thread.currentThread().getName() + " ha preso " + value);

        notifyAll();
        return value;
    }
}
