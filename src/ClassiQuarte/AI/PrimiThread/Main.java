package ClassiQuarte.AI.PrimiThread;

public class Main {
    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread();

        daemonThread.start();
        try {
            Thread.sleep(7500);
        } catch (InterruptedException e) {}
        System.out.println("Main chiude");
    }
}
