package ClassiQuarte.AI.SynchIntro;

import java.util.concurrent.Semaphore;

public class Counter {
    long count = 0;

    //private static final Semaphore sem = new Semaphore(1);

    public synchronized void add(long value) throws InterruptedException {
        //sem.acquire();
        count += value;
        //sem.release();
    }

    public long getCount() {
        return count;
    }
}
