package BasicSemaphore;

public class SubtracterThread extends Thread {

    private final SharedResource res;

    public SubtracterThread(String name, SharedResource res) {
        super(name);
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            res.Subtract(1);
        }
    }
}
