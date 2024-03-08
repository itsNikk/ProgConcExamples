package ClassiQuarte.AI.SynchIntro;

import java.util.concurrent.Semaphore;

public class AdderThread extends Thread {
    private Counter counter;


    public AdderThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            try {
                counter.add(1);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto.");
                break;
            }
        }
    }
}
