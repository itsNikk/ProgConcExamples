package ClassiQuarte.BI.IntroSynch;

import java.util.concurrent.Semaphore;

public class AdderThread extends Thread {

    private Counter counter;


    public AdderThread(String name, Counter counter) {
        setName(name);
        this.counter = counter;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            try {
                counter.Add(1);
            } catch (InterruptedException a) {
                System.out.println(getName() + " interrotto");
                break;
            }

        }
    }
}
