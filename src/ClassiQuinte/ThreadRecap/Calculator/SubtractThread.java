package ClassiQuinte.ThreadRecap.Calculator;

public class SubtractThread extends Thread {

    private Counter c;

    public SubtractThread(Counter c) {
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            c.Subtract(1);
        }
    }
}
