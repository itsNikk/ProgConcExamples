package ClassiQuarte.BI.IntroSynch;

import java.util.concurrent.Semaphore;

public class Counter {
    private long counter;

    private static final Semaphore sem = new Semaphore(1);

    public void Add(long val) throws InterruptedException {
        sem.acquire();
        counter += val;
        sem.release();
    }

    public void Subtract(long value) {
        counter -= value;
    }

    public long getCounter() {
        return counter;
    }
}
