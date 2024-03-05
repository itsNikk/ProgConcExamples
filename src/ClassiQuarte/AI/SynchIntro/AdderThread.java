package ClassiQuarte.AI.SynchIntro;

public class AdderThread extends Thread {
    private Counter counter;

    public AdderThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.add(1);
        }
    }
}
