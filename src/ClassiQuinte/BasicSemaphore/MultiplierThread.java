package ClassiQuinte.BasicSemaphore;

public class MultiplierThread extends Thread {

    private final SharedResource res;

    public MultiplierThread(String name, SharedResource res) {
        super(name);
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                sleep(5);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted.");
            }
            res.Double();
        }
    }
}
