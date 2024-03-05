package ClassiQuinte.ThreadRecap.Calculator;

public class AdderThread extends Thread {

    private Counter c;

    public AdderThread(Counter c) {
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            c.Add(1);
        }
    }
}
