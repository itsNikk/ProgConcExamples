package ClassiQuarte.AI.PrimiThread;

public class DaemonThread extends Thread {

    public DaemonThread() {
        //setDaemon(false);
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            System.out.println(getName() + ": counterValue: " + counter++);
            try {
                sleep(3500);
            } catch (InterruptedException e) {
            }
        }
    }

}
